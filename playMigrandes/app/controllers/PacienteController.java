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
	//static ArrayList<Paciente> pacientes=new ArrayList<Paciente>();	
	
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();

		int id =Integer.parseInt(nodo.findPath("id").asText());
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
		
	}
	
	public static Result delete(int idp)
	{
		Paciente p=JPA.em().find(Paciente.class, idp);
		if(p==null)
			return Results.notFound("Su tal paciente no existe");
		
     	JPA.em().remove(p);
     	return Results.ok();
     	
		
	}
	
	@play.db.jpa.Transactional
	//fecha en formato 
	public static Result verEpisodiosPacienteFecha(int idp, String fechaIn, String fechaFin)
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
	public static Result verEpisodiosPaciente(int idp) throws Exception
	{
		@SuppressWarnings("unused")
		List<Episodio> resp=null;
		
		//-------------------------Prueba-------------------------------------------------------
		
		//TODO estas son las pruebas de que efectivamente hay persistencia, debemos poblar !
		/**
		 * Probar que esta añadiendo a la BD
		 * 1. crear el paciente y un episodio (Quitar los comentarios) hasta METODO DEL REQ
		 * 2. quitar los comentarios al ultimo return
		 * 3. comentar el return del json
		 * 4. correr la app
		 * 5. comentar todo hasta METODO DEL REQ
		 * 6. comentar el return anterior y desomentar el del json
		 * 7. correr la app 
		 * 8. http://localhost:9000/paciente/getAllEpisodios/1
		 * 9 deberia retornar algo en json : [{"id":10,"fecha":"2015-02-07"}]
		 */
		
		
		//PACIENTE CHECK
		 //Paciente pp=new Paciente(1,"Laura", "laudany3", "faa","fa", "faass");
		 //JPA.em().persist(pp);
		
		
		 //EPISODIO CHECK
		 //String f1="2015-02-12";
		 //SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		
		
		 //EPISODIO CHECK
		 String f2="2015-02-07";
		 //Date Ff = null;
		 //Ff = formatoDelTexto.parse(f2);
				
		 //Episodio ep=new Episodio(f2);
		 //JPA.em().persist(ep);
		 //Episodio ep=JPA.em().find(Episodio.class, f2);
		
		//Medicamentos y actividades
		 //Medicamento m = new Medicamento("apronax", "leveteritacetam", "migranas", "oral", "550 mg");
		 //JPA.em().persist(m);
		 //Episodio e=JPA.em().getReference(Episodio.class, f2);
		 //e.agregarMedicamento(m);
		 
		 //Actividad a=new Actividad("correr", "fasasda", "fafsda", "2015-02-03");
		 //JPA.em().persist(a);
		 //e.agregarActividad(a);
		 
		 
			
		 //Se busca el paciente y add ep
		 //Paciente n=JPA.em().getReference(Paciente.class, 1);
		 //n.addEpisodio(ep);
		 //resp=n.getEpisodios();
		
		
		
		//-------------------------------------METODO DEL REQ-------------------------------------------------------------
		
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
		resp=JPA.em().find(Episodio.class, fe);
		if(resp==null)
			return Results.notFound("el Episodio no existe");
		
		/*/
		else
		{
			
			med=resp.getMedicamentos();
			act=resp.getCatalizador();
			
			r.put("medicamentos", Json.toJson(act).toString());
			r.put("medicamentos", Json.toJson(med).toString());
			r.put("medicamentos", Json.toJson(resp).toString());
			
			 
			r.putAll((Map<String, JsonNode>) Json.toJson(resp));
			
			
		}
		/*/
		
		
		return Results.ok(Json.toJson(resp));
	}
}
