package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.*;
import modelos.Doctor;
import modelos.Episodio;
import modelos.Paciente;
import modelos.Principal;

public class DoctorController extends Controller
{
    @BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();
		
		Long id = Long.parseLong(nodo.findPath("id").asText());
		String nombres=nodo.findPath("nombres").asText();
		String usuario=nodo.findPath("login").asText();
		String perfil=nodo.findPath("perfil").asText();
		String foto=nodo.findPath("foto").asText();
		
		Doctor n=JPA.em().find(Doctor.class, id);
		if(n!=null)
			return Results.ok("Su tal Doctor ya existe");
		
		n=new Doctor(id, nombres, usuario, foto);
		JPA.em().persist(n);
		return Results.created();
	}

	public static  Result delete(long id)
	{
		Doctor n=JPA.em().find(Doctor.class, id);
		if(n==null)
			return Results.notFound("Su tal Doctor no existe");
		
		JPA.em().remove(n);
		return Results.ok();
		
	}	

	public static Result update(long id)
	{
		JsonNode nodo = Controller.request().body().asJson();


		Long idn = Long.parseLong(nodo.findPath("id").asText());
		String nombres = nodo.findPath("nombres").asText();
		String telefono=nodo.findPath("telefono").asText();
		String usuario= nodo.findPath("usuario").asText();
		String perfil = nodo.findPath("perfil").asText();
		String foto= nodo.findPath("foto").asText();
		
		Doctor n=JPA.em().find(Doctor.class, id);
		if(n==null)
			return Results.notFound();
		
		Doctor d=JPA.em().getReference(Doctor.class,n);
		d=JPA.em().getReference(Doctor.class,n);
		d.setFoto(foto);
		d.setIdentificacion(id);
		d.setNombres(nombres);
		d.setUsuario(usuario);
		return Results.ok();
	}
				
}


