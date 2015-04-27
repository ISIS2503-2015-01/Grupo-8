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

	@SubjectNotPresent
	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{


		/** Usando Formas
		 * 
 		DynamicForm nodo = Form.form().bindFromRequest();

		int id =Integer.parseInt(nodo.findPath("id").asText());
		String nombres=nodo.findPath("nombres").asText();
		String usuario=nodo.findPath("usuario").asText();
		String pass=nodo.findPath("password").asText();
		 */

		JsonNode nodo = Controller.request().body().asJson();
		Logger.info("entro al create");
		int id =Integer.parseInt(nodo.findPath("id").asText()); 
		String nombres=nodo.findPath("nombres").asText(); 
		String usuario=nodo.findPath("usuario").asText(); 
		String pass=nodo.findPath("password").asText(); 
		
		Paciente n= JPA.em().find(Paciente.class, id); 

		if(n!=null)
			return Results.ok("El paciente ya existe");
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
	@Restrict({@Group("admin"),@Group("doctor")})
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

	@Security.Authenticated(SecuredP.class)
	@Restrict({@Group("admin"),@Group("doctor")})
	@play.db.jpa.Transactional
	public static Result verEpisodiosPacienteFecha()
	{
		DynamicForm df = play.data.Form.form().bindFromRequest();
		String idp = df.get("id");
		String fechaIn = df.get("fechaIni");
		String fechaFin = df.get("fechaFin");

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

		return ok(Episodios.render("Episodios por Fecha", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp, idp));
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

		int donId = Integer.parseInt(idp);

		Paciente p=JPA.em().find(Paciente.class, donId);
		if(p!=null)
			resp=p.getEpisodios();

		else
			throw new Exception("Paciente no encontrado");

		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		return ok(Episodios.render("Episodios", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), resp, idp));

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
}
