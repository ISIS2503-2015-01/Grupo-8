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

import com.fasterxml.jackson.databind.JsonNode;

@Security.Authenticated(Secured.class)
public class MedicamentoController {
	
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();
		
		//TODO terminar
		String nombre=nodo.findPath("nombre").asText();
		String componente=nodo.findPath("componenente").asText();
		
		Medicamento n= JPA.em().find(Medicamento.class, nombre);
		if(n!=null)
			return Results.ok("El paciente ya existe");
		else
		{
			n=new Medicamento(nombre, componente, "asda", "asfas", "fafasa");
			JPA.em().persist(n);
		}
		return Results.created();		
	}
	
	 @play.db.jpa.Transactional
	public static Result getAll()
	{
		List<Medicamento> resp=null;
		Query q=JPA.em().createQuery("from Medicamento");
		resp=q.getResultList();
		return Results.ok(Json.toJson(resp));
	}

}
