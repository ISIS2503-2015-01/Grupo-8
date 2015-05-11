package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.Query;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import be.objectify.deadbolt.java.actions.SubjectNotPresent;

import com.fasterxml.jackson.databind.JsonNode;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import views.html.Pacientes;
import modelos.Doctor;
import modelos.Episodio;
import modelos.Medicamento;
import modelos.Paciente;
import modelos.SecurityRole;


@Security.Authenticated(Secured.class)
public class DoctorController extends Controller
{
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();

		String nombres=nodo.findPath("nombres").asText();
		String correo=nodo.findPath("login").asText();
		String clave=nodo.findPath("password").asText();

		//Verifica integridad
		String hmacRec = nodo.findPath("hmac").asText();
		String[] params = {nombres,correo,clave};
		boolean integ = Secured.verificarIntegridad(params, hmacRec);
		if(!integ)
		{
			return Results.notFound("La información ha sido alterada.");
		}
		
		
		Doctor n=JPA.em().find(Doctor.class, correo);
		if(n!=null)
			return Results.ok("Ya existe");

		n=new Doctor(clave, nombres, correo);
		SecurityRole s=JPA.em().find(SecurityRole.class,(long) 2);
		n.agregarRol(s);
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



		String nombres = nodo.findPath("nombres").asText();
		String usuario= nodo.findPath("usuario").asText();


		Doctor n=JPA.em().find(Doctor.class, usuario);

		if(n==null)
			return Results.notFound();

		Doctor d=JPA.em().getReference(Doctor.class,n);
		d=JPA.em().getReference(Doctor.class,n);
		d.setNombres(nombres);
		d.setEmail(usuario);
		return Results.ok();
	}

	@Transactional
	public static Doctor darDoctor(String nmail)
	{
		return JPA.em().find(Doctor.class, nmail);
	}

	@Restrict({@Group("admin")})
	@play.db.jpa.Transactional
	public static Result darDoctores()
	{
		List<Doctor> resp=null;
		Query q=JPA.em().createQuery("from Doctor");
		resp=q.getResultList();
		return Results.ok(Json.toJson(resp));
	}


	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result darPacientesDoctor(String doc)
	{
		List<Paciente> resp=null;

		Doctor d = null;
		d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));
		if(d==null)
		{
			return Results.notFound("Doctor no encontrado");
		}
		
		resp=d.getPacientes();
		return ok(Pacientes.render("Pacientes", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp));

	}

}


