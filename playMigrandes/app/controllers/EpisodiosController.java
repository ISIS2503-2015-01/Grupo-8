package controllers;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Query;

import modelos.Dolor;
import modelos.Episodio;
import modelos.Paciente;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import com.fasterxml.jackson.databind.JsonNode;

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
			n = new Episodio(date, null, dol);
			JPA.em().persist(n);
		}

		return Results.created();
		
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
	
	public String generarGrafica(Long idp)
	{
		List<Episodio> resp=null;
		Paciente p=JPA.em().find(Paciente.class, idp);
		
		List<Episodio> a = p.getEpisodios();
		
		String res = graficar(a);
		
		return res;
	}
	
	public String graficar(List<Episodio> lista)
	{
		//Date Fecha
		//Int Intensidad
		//List<Medicamento> Medicamentos
		
		
		String x = new String();
		for(int i = 0; i < lista.size(); i ++)
			{
				Episodio uno = new Episodio();
				
				uno = lista.get(i);
				Date fecha = uno.getFecha();
				
				int intensidad = uno.getDolor().getIntensidad();
				
				String y = new String();
				if(i != lista.size()-1)
				{
					y = ";";
				}
				x = x + "{\"unit\" : \""+fecha.toString()+"\","
						+ "\"value\" : \""+intensidad+"\""
						+ "}"+y;
			}		
		
		String str = ""
				+ "{"
				+ "\"JSChart\" :{"
				+ "\"datasets\" : ["
				+ "{\"type\" : \"line\","
				+ "\"data\" : ["
				+ x
				+ "]"
				+ "}"
				+ "]"
				+ "}"
				+ "}";
		
		return str;
	}

}
