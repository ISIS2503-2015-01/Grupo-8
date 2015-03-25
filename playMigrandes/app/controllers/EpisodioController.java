package controllers;



import java.text.ParseException;
import com.fasterxml.jackson.databind.JsonNode;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import modelos.Episodio;
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

}
