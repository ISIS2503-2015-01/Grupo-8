package controllers;



import java.text.ParseException;
import java.util.List;

import javax.persistence.Query;

import com.fasterxml.jackson.databind.JsonNode;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import modelos.Episodio;
import modelos.Medicamento;
import modelos.Paciente;
;

public class EpisodioController extends Controller
{

	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create() throws ParseException
	{
		JsonNode nodo = Controller.request().body().asJson();
		String id = nodo.findPath("fecha").asText();
		String user=nodo.findPath("usuario").asText();
		int dolor=nodo.findPath("dolor").asInt();
		String voz=nodo.findPath("notaVoz").asText();
		String ubicacion=nodo.findPath("ubicacion").asText();
		String descripcion=nodo.findPath("descripcion").asText();
		
	

		if(JPA.em().find(Paciente.class, user)==null)
			return Results.badRequest("El Paciente al que se quiere asociar este episodio no existe");

		else
		{
			Paciente duenio=JPA.em().getReference(Paciente.class, user);
			Episodio e= new Episodio(id, dolor, duenio, voz, ubicacion, descripcion);
			JPA.em().persist(e);
		}

		return Results.created();		
	}
	
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create2() throws ParseException
	{
		JsonNode nodo = Controller.request().body().asJson();
		String id = nodo.findPath("fecha").asText();
		String user=nodo.findPath("usuario").asText();
		String voz=nodo.findPath("notaVoz").asText();
	

		if(JPA.em().find(Paciente.class, user)==null)
			return Results.badRequest("El Paciente al que se quiere asociar este episodio no existe");

		else
		{
			Paciente duenio=JPA.em().getReference(Paciente.class, user);
			Episodio e= new Episodio(id, duenio, voz);
			JPA.em().persist(e);
		}

		return Results.created();		
	}
	
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result agregarMedicamento() throws ParseException
	{
		JsonNode nodo = Controller.request().body().asJson();
		String nombreMed = nodo.findPath("nombreMedicamento").asText();
		String fe =nodo.findPath("fecha").asText();
		String user=nodo.findPath("usuario").asText();

		if(JPA.em().find(Paciente.class, user)==null)
			return Results.badRequest("El Paciente al que se quiere asociar este episodio no existe");

		else
		{
			Paciente e= JPA.em().getReference(Paciente.class, user);
			int id=e.darMedicamento(nombreMed);
			if(id==-1)
				return Results.badRequest("Medicamento no asociado");
			
			Medicamento m=JPA.em().getReference(Medicamento.class, id);
				
			
			Query q=JPA.em().createQuery("from Episodio e where e.paciente.usuario=:u and fecha=:f");
			q.setParameter("u",user);
			q.setParameter("f", fe);
			List<Episodio> l=q.getResultList();
			
			if(l==null || l.size()==0)
				return Results.notFound("el Episodio no existe");
			
			int ide=l.get(0).getId();
			
			Episodio ep=JPA.em().getReference(Episodio.class, ide);
			ep.agregarMedicamento(m);
		}

		return Results.created();		
	}

}
