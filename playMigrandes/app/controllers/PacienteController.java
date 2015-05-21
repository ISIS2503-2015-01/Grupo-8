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
import modelos.SecurityRole;
import modelos.SecurityRole.Builder;
import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import be.objectify.deadbolt.java.actions.SubjectNotPresent;

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
import play.mvc.Security;
import play.data.DynamicForm;
import play.data.DynamicForm.Dynamic;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

public class PacienteController extends Controller
{

	
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{
		JsonNode nodo = Controller.request().body().asJson();
		Logger.info("entro al create");
		String sid = nodo.findPath("id").asText();
		int id =Integer.parseInt(sid);
		String nombres=nodo.findPath("nombres").asText(); 
		String usuario=nodo.findPath("usuario").asText(); 
		String pass=nodo.findPath("password").asText(); 
		
		//Integridad
		String hmacRec = nodo.findPath("hmac").asText();
		String[] params = {sid,nombres,usuario,pass};
		boolean integ = Secured.verificarIntegridad(params, hmacRec);
		if(!integ)
		{
			return Results.unauthorized("La información ha sido alterada.");
		}
		
		Paciente n= JPA.em().find(Paciente.class, id); 

		if(n!=null)
			return Results.badRequest("El paciente ya existe");
		else
		{
			Logger.info("creando paciente");
			n=new Paciente(id, nombres, usuario, pass);
			SecurityRole s=JPA.em().find(SecurityRole.class,(long) 3); 
			n.agregarRol(s);
			JPA.em().persist(n);
			Logger.info("paciente creado");
		}
		return Results.created();		
	}

	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin")})
	public static Result delete(int idp)
	{
		Paciente p=JPA.em().find(Paciente.class, idp);
		if(p==null)
			return Results.notFound("Su tal paciente no existe");

		JPA.em().remove(p);
		return Results.ok();

	}

	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin")})
	@play.db.jpa.Transactional
	public static Result getAll()
	{
		List<Paciente> resp=null;
		Query q=JPA.em().createQuery("from Paciente");
		resp=q.getResultList();

		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		return ok(Pacientes.render("Pacientes", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp));
	}
	
	
	@Restrict({@Group("paciente")})
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result createActividad()
	{
		JsonNode nodo = Controller.request().body().asJson();
		
		String nombre=nodo.findPath("nombre").asText();
		String descripcion=nodo.findPath("descripcion").asText();
		String tipo=nodo.findPath("tipo").asText();
		String fecha = nodo.findPath("fecha").asText();

		
		String hmacRec = nodo.findPath("hmac").asText();
		String[] params = {nombre,descripcion,tipo,fecha};
		boolean integ = Secured.verificarIntegridad(params, hmacRec);
		if(!integ)
		{
			return Results.unauthorized("La información ha sido alterada.");
		}
		
		Actividad a= JPA.em().find(Actividad.class, nombre);
		if(a!=null)
			return Results.ok("La actividad ya existe");
		else
		{
			a=new Actividad(nombre, descripcion,tipo,fecha);
			JPA.em().persist(a);
		}
		return Results.ok(Json.toJson(a));		
	}

	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result verEpisodiosPacienteFecha()
	{
		DynamicForm df = play.data.Form.form().bindFromRequest();
		String idp = df.get("id");
		String fechaIn = df.get("fechaIni");
		String fechaFin = df.get("fechaFin");
		int k = Integer.parseInt(idp);
		
		
//		//Verifica integridad
//		String hmacRec = df.get("hmac");
//		String[] params = {idp,fechaIn,fechaFin};
//		boolean integ = Secured.verificarIntegridad(params, hmacRec);
//		if(!integ)
//		{
//			return Results.notFound("La información ha sido alterada.");
//		}

		List<Episodio> resp=null;
		Paciente p=JPA.em().find(Paciente.class, k);
		if(p==null)
			return Results.notFound("el Paciente no existe");

		else if(p.getEpisodios()!=null)
		{
			Query q=JPA.em().createQuery("select ep from Paciente p join p.episodios ep where p.id=:id and ep.fecha between :fi and :ff");
			q.setParameter("fi", fechaIn);
			q.setParameter("ff", fechaFin);
			q.setParameter("id", k);
			resp=q.getResultList();
		}

		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		return ok(Episodios.render("Episodios por Fecha", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp, p));
	}

	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result verEpisodiosPaciente() throws Exception
	{
		@SuppressWarnings("unused")
		List<Episodio> resp=null;

		DynamicForm f = play.data.Form.form().bindFromRequest();
		String idp = f.get("id");
		
//		//Verifica integridad
//				String hmacRec = f.get("hmac");
//				String[] params = {idp};
//				boolean integ = Secured.verificarIntegridad(params, hmacRec);
//				if(!integ)
//				{
//					return Results.notFound("La información ha sido alterada.");
//				}

		int donId = Integer.parseInt(idp);

		Paciente p=JPA.em().find(Paciente.class, donId);
		if(p!=null)
			resp=p.getEpisodios();

		else
			throw new Exception("Paciente no encontrado");

		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		return ok(Episodios.render("Episodios", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp, p));

		//util para verificar inserciones
		//return Results.ok("Debe ser X. Resultado: "+Integer.toString(resp.size()));
	}



	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result verEpisodioFull( )
	{
		DynamicForm f = play.data.Form.form().bindFromRequest();
		String fe = f.get("id");
		
//		//Verifica integridad
//		String hmacRec = f.get("hmac");
//		String[] params = {fe};
//		boolean integ = Secured.verificarIntegridad(params, hmacRec);
//		if(!integ)
//		{
//			return Results.notFound("La información ha sido alterada.");
//		}

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

		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		return ok(DetailEpisodio.render("Episodio Detallado", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp));

	}

	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Paciente darPaciente(String correo)
	{
		Query q=JPA.em().createQuery("FROM PACIENTE P WHERE P.USUARIO=:c ");
		q.setParameter("c", correo);
		return (Paciente)q.getResultList().get(0);
	}
	
	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin")})
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result asignarDoctor()
	{
		JsonNode nodo = Controller.request().body().asJson();
		int pacienteId =Integer.parseInt(nodo.findPath("pacienteId").asText()); 
		String doctorId=nodo.findPath("doctorId").asText(); 
		
		Paciente n= JPA.em().find(Paciente.class, pacienteId); 
		Doctor d= JPA.em().find(Doctor.class, doctorId); 

		if(n==null)
			return Results.notFound("El paciente no exite");
		
		else if(d==null)
			return Results.notFound("El doctor no existe");
		
		else
		{
			d.agregarPaciente(n);
			//n.asignarDoctor(d);
		}
		return Results.ok();		
	}
	
	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result darPacienteMovil(String correo)
	{
		Query q=JPA.em().createQuery("FROM PACIENTE P WHERE P.USUARIO=:c ");
		q.setParameter("c", correo);
		return ok(Json.toJson((Paciente)q.getResultList().get(0)));
	}
	
	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result verEpisodiosPacienteFechaMovil()
	{
		DynamicForm df = play.data.Form.form().bindFromRequest();
		//String idp = df.get("id");
		//String fechaIn = df.get("fechaIni");
		//String fechaFin = df.get("fechaFin");
		
		JsonNode nodo = Controller.request().body().asJson();
		Logger.info("entro al ver episodios por fecha");
		int idp =Integer.parseInt(nodo.findPath("id").asText()); 
		String fechaIn=nodo.findPath("fechaIni").asText(); 
		String fechaFin=nodo.findPath("fechaFin").asText(); 
		//String pass=nodo.findPath("password").asText(); 
		
		//Verifica integridad
		/**String hmacRec = df.get("hmac");
		String[] params = {idp,fechaIn,fechaFin};
		boolean integ = Secured.verificarIntegridad(params, hmacRec);
		if(!integ)
		{
			return Results.notFound("La información ha sido alterada.");
		}**/

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

		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		//return ok(Episodios.render("Episodios por Fecha", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp, ""+idp));
		//TODO Si Recibe Listas? Probarlo
		
		return ok(Json.toJson(resp));
	}
	
	/*
	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result verEpisodiosPacienteFechaMovilJsonList()
	{
		DynamicForm df = play.data.Form.form().bindFromRequest();
			
		JsonNode nodo = Controller.request().body().asJson();
		Logger.info("entro al ver episodios por fecha");
		int idp =Integer.parseInt(nodo.findPath("id").asText()); 
		String fechaIn=nodo.findPath("fechaIni").asText(); 
		String fechaFin=nodo.findPath("fechaFin").asText(); 
		//String pass=nodo.findPath("password").asText(); 
		
		/
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
		
		JSONObject respList = new JSONObject();
	    JSONArray jsonArray = new JSONArray();

	    for (int i = 0; i < resp.size(); i++)
	    {
	      JSONObject formDetailsJson = new JSONObject();
	      Episodio e = resp.get(i);
	     
	      jsonArray.put(e);
	    }
	    respList.put("episodios", jsonArray);
	    //return responseDetailsJson;

		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		//return ok(Episodios.render("Episodios por Fecha", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp, ""+idp));
		//TODO Si Recibe Listas? Probarlo
		
		return ok(Json.toJson(respList));
	}*/
	
	/**
	 * Solo devuelve el Doctor que esta en la sesión, para que el busque los epidosios de su paciente
	 * @return
	 * @throws Exception
	 */
	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result verEpisodiosPacienteMovil() throws Exception
	{
		@SuppressWarnings("unused")
		List<Episodio> resp=null;

		//DynamicForm f = play.data.Form.form().bindFromRequest();
		JsonNode nodo = Controller.request().body().asJson();

		//String idp = f.get("id");
		String idp=nodo.findPath("id").asText(); 

		
		//Verifica integridad
		/*
		String hmacRec = f.get("hmac");
		String[] params = {idp};
		boolean integ = Secured.verificarIntegridad(params, hmacRec);
		if(!integ)
		{
			return Results.notFound("La información ha sido alterada.");
		}*/

		int donId = Integer.parseInt(idp);

		Paciente p=JPA.em().find(Paciente.class, donId);
		if(p!=null)
			resp=p.getEpisodios();

		else
			throw new Exception("Paciente no encontrado");

		/**Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
		{
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));
			return ok(Json.toJson(d));
		}
		else
			return forbidden("No hay ningun doctor loggeado.");
		*/

		//return ok(Episodios.render("Episodios", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp, idp));
		

		return DoctorController.darDoctorLoggeado();

	}
	
	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result verEpisodioFullMovil( )
	{
		//DynamicForm f = play.data.Form.form().bindFromRequest();
		//String fe = f.get("id");
		
		JsonNode nodo = Controller.request().body().asJson();
		String fe=nodo.findPath("id").asText(); 
		
		//Verifica integridad
		/**String hmacRec = f.get("hmac");
		String[] params = {fe};
		boolean integ = Secured.verificarIntegridad(params, hmacRec);
		if(!integ)
		{
			return Results.notFound("La información ha sido alterada.");
		}**/

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

		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		//return ok(DetailEpisodio.render("Episodio Detallado", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp));
		return ok(Json.toJson(resp));
	}
	
	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("paciente")})
	@play.db.jpa.Transactional
	public static Result darPacienteLoggeado()
	{
		Paciente p = null;
		if(Secured.isLoggedIn(ctx()))
		{
			p=JPA.em().find(Paciente.class, Secured.getUser(ctx()));
			return ok(Json.toJson(p));
		}

		else
			return forbidden("No hay ningun paciente loggeado.");
	}

}
