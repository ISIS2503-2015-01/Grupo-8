package controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
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
import play.db.jpa.JPA;



public class PacienteController extends Controller
{
	//static ArrayList<Paciente> pacientes=new ArrayList<Paciente>();	
	
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();

		Long id = Long.parseLong(nodo.findPath("id").asText());
		String nombres=nodo.findPath("nombres").asText();
		String usuario=nodo.findPath("login").asText();
		String perfil=nodo.findPath("perfil").asText();
		String foto=nodo.findPath("foto").asText();
		String telefono=nodo.findPath("telefono").asText();
		
		

		Paciente n= JPA.em().find(Paciente.class, id);
		
		if(n!=null)
		{
			return Results.ok("El paciente ya existe");
		}
		else
		{
			n=new Paciente(id, nombres, usuario, perfil, foto, telefono);
			JPA.em().persist(n);
		}

		return Results.created();
		
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
	}
	
	public static Result delete(Long idp)
	{
		Paciente p=JPA.em().find(Paciente.class, idp);//8513148
		if(p==null)
			return Results.notFound("Su tal paciente no existe");
		
     	JPA.em().remove(p);
     	return Results.ok();
     	
		
	}
	
	public static Result verEpisodiosPacienteFecha(Long idp, String fechaIn, String fechaFin)
	{
		List<Episodio> resp=null;
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date Fi = null;
		Date Ff = null;
		try {

		Fi = formatoDelTexto.parse(fechaIn);
		Ff = formatoDelTexto.parse(fechaFin);
		} 
		catch (ParseException ex) {

		return Results.ok("error formateando fecha");

		}

		
		Paciente p=JPA.em().find(Paciente.class, idp);
		if(p==null)
		{
			return Results.notFound("Su tal paciente no existe");
		}
		else if(p.getEpisodios()!=null)
		{
			Query query = JPA.em().createQuery("SELECT e FROM Episodio e WHERE e.fecha <="+Ff+" AND e.fecha >= "+Fi+" AND e.pacienteID = "+idp);
			resp=query.getResultList();
		}
		
		return Results.ok(Json.toJson(resp));
	}

	public static Result verEpisodiosPaciente(Long idp)
	{
		List<Episodio> resp=null;
		Paciente p=JPA.em().find(Paciente.class, idp);
		
		if(p==null)
		{
			return Results.notFound("Su tal paciente no existe");
		}
		else if(p.getEpisodios()!=null)
		{
			Query query = JPA.em().createQuery("SELECT e FROM Episodio e WHERE e.idPaciente = "+idp);
			resp=query.getResultList();
		}
		
		return Results.ok(Json.toJson(resp));
		
		
		//ArrayList<Episodio>  episodios= new ArrayList<Episodio>();
		
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
	}
}
