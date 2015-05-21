package controllers;

import java.util.List;

import javax.persistence.Query;

import modelos.Medicamento;
import modelos.Paciente;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.Security;
import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;

import com.fasterxml.jackson.databind.JsonNode;

@Security.Authenticated(SecuredP.class)
public class MedicamentoController {
	
	@Restrict({@Group("paciente")})
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();
		
		//TODO terminar
		String nombre=nodo.findPath("nombre").asText();
		String descripcion=nodo.findPath("descripcion").asText();
		
		String hmacRec = nodo.findPath("hmac").asText();
		String[] params = {nombre,descripcion};
		boolean integ = Secured.verificarIntegridad(params, hmacRec);
		if(!integ)
		{
			return Results.unauthorized("La información ha sido alterada.");
		}
		
		Medicamento n= JPA.em().find(Medicamento.class, nombre);
		if(n!=null)
			return Results.ok("El paciente ya existe");
		else
		{
			n=new Medicamento(nombre, descripcion);
			JPA.em().persist(n);
		}
		return Results.ok(Json.toJson(n));		
	}
	
	
	
	@Restrict({@Group("paciente")})
	@play.db.jpa.Transactional
	public static Result getAll()
	{
		List<Medicamento> resp=null;
		Query q=JPA.em().createQuery("from Medicamento");
		resp=q.getResultList();
		return Results.ok(Json.toJson(resp));
	}

}
