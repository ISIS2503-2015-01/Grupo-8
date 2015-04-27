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

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;

import com.fasterxml.jackson.databind.JsonNode;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import modelos.Doctor;
import modelos.Episodio;
import modelos.Medicamento;
import modelos.Paciente;


@Security.Authenticated(SecuredP.class)
public class EpisodioController extends Controller
{
	@Restrict({@Group("paciente")})
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create() throws ParseException
	{

		JsonNode nodo = Controller.request().body().asJson();
		String id = nodo.findPath("fecha").asText();
		String notaVoz = nodo.findPath("notaVoz").asText();
		String descripcion = nodo.findPath("descripcion").asText();
		String ubicacion = nodo.findPath("ubicacion").asText();
		String intensidad = nodo.findPath("intensidad").asText();
		String medicamentos = nodo.findPath("medicamentos").asText();

		Episodio n = JPA.em().find(Episodio.class, id);
		if(n!=null)
			return Results.ok("El epsodio ya existe");
		else
		{
			if(notaVoz.isEmpty()&&descripcion.isEmpty()&&ubicacion.isEmpty()&&intensidad.isEmpty())
			{
				//si entra 	quiere decir que se trata de jmeter y solo llega una fecha por parametro
				n = new Episodio(id);
			}
			else if(descripcion.isEmpty()&&ubicacion.isEmpty()&&intensidad.isEmpty())
			{
				//Si entra quiere decir que el paciente creo una nota de voz y por lo tanto solo se recibe la nota de voz y la fecha
				
				n= new Episodio(id,notaVoz);
			}
			else if (!descripcion.isEmpty()&&!ubicacion.isEmpty()&&!intensidad.isEmpty()) {

				//La interfaz web se asegura de que los separadores no pueden ser ingresados por el paciente.
				//Si entra quiere decir que el paciente creo un episodio completo, solo la lista de medicamentos puede estar vacia
				List<Medicamento> medicamentosL = new ArrayList<Medicamento>();
				if(!medicamentos.isEmpty())
				{
					String[] med = medicamentos.split("-Med:");//-Med: es el separador de medicamentos usado por la intrfaz movil
					for (String str : med) 
					{
						if(!str.isEmpty()&&str.contains("-NuD-"))//-NuD- es el separador de los atributos de medicamentos usado por la interfaz movil 
						{
							Medicamento m = new Medicamento(str.split("-NuD-")[0], str.split("-NuD-")[1]);
							medicamentosL.add(m);
						}

					}
				}

				n=new Episodio(id, medicamentosL, descripcion, Integer.parseInt(intensidad), ubicacion);
			}

			JPA.em().persist(n);
		}

		return Results.created();		
	}

	@Restrict({@Group("paciente")})
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
