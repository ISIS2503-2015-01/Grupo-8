package controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelos.Doctor;
import modelos.Episodio;
import modelos.Paciente;

import com.avaje.ebean.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;

import play.*;
import play.mvc.*;
import views.html.*;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

//TODO el import no funca y es lo de la guia !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import play.db.jpa.JPA;



public class PacienteController extends Controller
{

	static ArrayList<Paciente> pacientes=new ArrayList<Paciente>();
	


	
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();

		Long id = Long.parseLong(nodo.findPath("id").asText());

		/*
		//se llena la lista de episodios
		ArrayList<Episodio>  episodios= new ArrayList();

		while(episodios.size()<11)
		{
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			Date nFecha;
			try {
				nFecha = format.parse("2014-02-19");
				Episodio nvo=new Episodio(nFecha, null, null);
				episodios.add(nvo);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		/*
		 */
		
		
		//TODO No funciona !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		Paciente n= JPA.em().find(Paciente.class, id);
		//n.setEpisodios(episodios);
		
		if(n==null)
		{
			return Results.ok("El paciente ya existe");
		}
		else
		{
			pacientes.add(n);
		}

		return Results.created();

	}

	public static Result verEpisodiosPaciente(Long idp)
	{
		
		ArrayList<Episodio>  episodios= new ArrayList<Episodio>();
		
		//se crea el paciente de prueba
		/*
		while(episodios.size()<11)
		{
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			Date nFecha;
			try {
				nFecha = format.parse("2014-02-19");
				Episodio nvo=new Episodio(nFecha, null, null);
				episodios.add(nvo);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		Paciente n=new Paciente(idp, null, null, null, null, null);
		n.setEpisodios(episodios);
		pacientes.add(n);
		
		
		//se simula
		ArrayList<Episodio> respuesta=new ArrayList();
		boolean encontrado=false;
		for(int j=0;j<pacientes.size() && encontrado==false;j++)
		{
			Paciente actp=pacientes.get(j);
			if(actp.getIdentificacion() == idp)
			{
				episodios=(ArrayList<Episodio>) actp.getEpisodios();
			}
		}
		*/
		
		//TODO no funciona !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		Paciente p=JPA.em().find(Paciente.class, idp);
		
		if(p==null)
		{
			Results.ok("Paciente no encontrado");
		}
		else
		{
			episodios=(ArrayList<Episodio>) p.getEpisodios();
		}

		
		return Results.ok(Json.toJson(episodios));

		
	}

}
