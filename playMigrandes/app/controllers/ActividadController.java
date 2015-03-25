package controllers;

import java.text.ParseException;

import modelos.Actividad;
import modelos.Episodio;
import modelos.Paciente;

import com.fasterxml.jackson.databind.JsonNode;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class ActividadController extends Controller 
{
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create() throws ParseException
	{
		JsonNode nodo = Controller.request().body().asJson();
		String nombre = nodo.findPath("nombre").asText();
		String des=nodo.findPath("descripcion").asText();
		String fecha=nodo.findPath("fecha").asText();
		String h=nodo.findPath("hora").asText();
		String t=nodo.findPath("tipo").asText();
		String user=nodo.findPath("usuario").asText();
		
	

		if(JPA.em().find(Paciente.class, user)==null)
			return Results.badRequest("El Paciente al que se quiere asociar esta Actividad no existe");
		
		else if(JPA.em().find(Actividad.class, nombre)!=null)
			return Results.badRequest("Ya existe una actividad con ese nombre");
		else
		{
			Paciente duenio=JPA.em().getReference(Paciente.class, user);
			Actividad a=new Actividad(nombre, des, fecha, h, t, duenio);
			JPA.em().persist(a);
			duenio.addActividad(a);
	
		}

		return Results.created();		
	}
}
