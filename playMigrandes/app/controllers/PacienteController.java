package controllers;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelos.Actividad;
import modelos.Doctor;
import modelos.Episodio;
import modelos.Medicamento;
import modelos.Paciente;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.*;
import play.mvc.*;
import views.html.*;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;




public class PacienteController extends Controller
{	
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();

		String nombres=nodo.findPath("nombres").asText();
		String usuario=nodo.findPath("usuario").asText();
		String password=nodo.findPath("password").asText();
		
		Paciente n= JPA.em().find(Paciente.class, usuario);
		
		if(n!=null)
			return Results.badRequest("El paciente ya existe");
		else
		{
			n=new Paciente(nombres, usuario,password);
			JPA.em().persist(n);
		}
		return Results.created();		
	}
	
	public static Result delete(String idp)
	{
		Paciente p=JPA.em().find(Paciente.class, idp);
		if(p==null)
			return Results.notFound("Su tal paciente no existe");
		
     	JPA.em().remove(p);
     	return Results.ok();
     			
	}
	
	@play.db.jpa.Transactional
	public static Result getAll()
	{
		List<Medicamento> resp=null;
		Query q=JPA.em().createQuery("from Paciente");
		resp=q.getResultList();
		return Results.ok(Json.toJson(resp));
	}
	
	@play.db.jpa.Transactional
	public static Result verEpisodiosPacienteFecha(String idp, String fechaIn, String fechaFin)
	{

		List<Episodio> resp=null;
		Paciente p=JPA.em().find(Paciente.class, idp);
		if(p==null)
			return Results.notFound("el Paciente no existe");
		
		else if(p.getEpisodios()!=null)
		{
			Query q=JPA.em().createQuery("select ep from Paciente p join p.episodios ep where p.id=:id and ep.fecha between :fi and :ff");
			q.setParameter("fi", fechaIn);
	        q.setParameter("ff", fechaFin);
	        q.setParameter("id", idp);
			resp=q.getResultList();
		}
		
		return Results.ok(Json.toJson(resp));
	}

	
	@play.db.jpa.Transactional
	public static Result verEpisodiosPaciente(String idp) throws Exception
	{
		@SuppressWarnings("unused")
		List<Episodio> resp=null;
		
		Paciente p=JPA.em().find(Paciente.class, idp);
		if(p!=null)
			resp=p.getEpisodios();
		
		else
			throw new Exception("Paciente no encontrado");
		
		return Results.ok(Json.toJson(resp));
		
		//util para verificar inserciones
		//return Results.ok("Debe ser X. Resultado: "+Integer.toString(resp.size()));
	}
	
	
	
	
	
	@play.db.jpa.Transactional
	public static Result verEpisodioFull( String fe )
	{
		ObjectNode r=Json.newObject();
		Episodio resp=null;
		List<Medicamento> med=null;
		Actividad act=null;
		Query q=JPA.em().createQuery("from Episodio e where e.fecha=:f");
		q.setParameter("f", fe);
		List<Episodio> l=q.getResultList();
		if(l==null || l.size()==0)
			return Results.notFound("el Episodio no existe");
		else
			resp=l.get(0);
		
		return Results.ok(Json.toJson(resp));
	}

	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result agregarMedicamento(String idp)
	{
		JsonNode nodo = Controller.request().body().asJson();

		String nombres=nodo.findPath("nombre").asText();
		String descripcion=nodo.findPath("descripcion").asText();
		
		Paciente p=JPA.em().find(Paciente.class, idp);
		
		if(p==null)
			return Results.badRequest("El paciente no existe");
		
		else
		{
			p=JPA.em().getReference(Paciente.class, idp);
			Medicamento m=new Medicamento(nombres,descripcion);
			JPA.em().persist(m);
			p.addMedicamento(m);
		}
		return Results.created();
	}
}
