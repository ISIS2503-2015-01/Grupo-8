package controllers;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.persistence.Query;

import com.fasterxml.jackson.databind.JsonNode;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import modelos.Doctor;
import modelos.Dolor;
import modelos.Episodio;
import modelos.Paciente;
import modelos.Principal;

public class EpisodioController extends Controller
{
		
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create() throws ParseException
	{
		JsonNode nodo = Controller.request().body().asJson();
		String id = nodo.findPath("fecha").asText();
		Episodio n = JPA.em().find(Episodio.class, id);
		if(n!=null)
			return Results.ok("El epsodio ya existe");
		else
		{
			n = new Episodio(id);
			JPA.em().persist(n);
		}

		return Results.created();		
	}
	
	public static Result delete(Long idp) throws ParseException
	{
		String datString = idp.toString();
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(datString);
		Episodio p=JPA.em().find(Episodio.class, date);
		if(p == null)
			return Results.notFound("Su tal paciente no existe");
		
     	JPA.em().remove(p);
     	return Results.ok();
	}
}
