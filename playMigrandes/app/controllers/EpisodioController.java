package controllers;

import modelos.Paciente;

import com.avaje.ebean.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;

import play.db.jpa.JPA;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class EpisodioController extends Controller
{
	
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();

		//Create para el Episodio
		
		//String fecha=nodo.findPath("fecha").asText(); Se instancia apena llega
		
		String medicamento=nodo.findPath("medicamentoId").asText();
		
		
		String notaVoz=nodo.findPath("notaId").asText();
		
		//Create para el Dolor
		
		
		
		

		
		
		
		//Paciente n= JPA.em().find(Paciente.class, id);
		
		//if(n!=null)
		//{
			//return Results.ok("El paciente ya existe");
		//}
		//else
	//	{
			//n=new Paciente(id, nombres, usuario, perfil, foto, telefono);
			//JPA.em().persist(n);
		//}

		return Results.created();
	}
	
	
	
}
