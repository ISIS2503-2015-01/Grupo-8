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

public class EpisodiosController extends Controller
{
		
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create() throws ParseException
	{
		JsonNode nodo = Controller.request().body().asJson();
		Dolor dol = new Dolor();

		Long id = Long.parseLong(nodo.findPath("id").asText());
		String datString = id.toString();
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(datString);
		dol.setDescripcion(nodo.findPath("nombres").asText());
		
		Episodio n = JPA.em().find(Episodio.class, id);
		
		if(n!=null)
		{
			return Results.ok("El epsodio ya existe");
		}
		else
		{
			//n = new Episodio(date, null, dol);
			//JPA.em().persist(n);
		}

		return Results.created();
		
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
	
	public static Result delete(Long idp) throws ParseException
	{
		String datString = idp.toString();
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(datString);
		Episodio p=JPA.em().find(Episodio.class, date);//8513148
		if(p == null)
			return Results.notFound("Su tal paciente no existe");
		
     	JPA.em().remove(p);
     	return Results.ok();
	}
	
	public JsonNode graficar(List<Episodio> lista)
	{
		//Date Fecha
		//Int Intensidad
		//List<Medicamento> Medicamentos
		
		JsonNode json = Json.toJson(lista);
		
//		for(int i = 0; i < lista.size(); i ++)
//		{
//			Episodio uno = new Episodio();
//			Dolor dol = new Dolor();
//			List<Medicamento> med = uno.getMedicamentos();
//			
//			uno = lista.get(i);
//			Date fecha = uno.getFecha();
//			int intensidad = uno.getDolor().getIntensidad();
//			
//		}
		
		return json;
	}

}
