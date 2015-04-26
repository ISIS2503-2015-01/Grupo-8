package controllers;

import java.util.List;

import javax.persistence.Query;

import modelos.Medicamento;
import modelos.Paciente;

import com.fasterxml.jackson.databind.JsonNode;

import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() 
    {
    	  return ok(index.render("ola ke ase"));
    	  
    }
    
    @Transactional
	@BodyParser.Of(BodyParser.Json.class)
    public static Result login()
    {
//    	Paciente n=null;
//    	JsonNode nodo = Controller.request().body().asJson();
//    	String user=nodo.findPath("usuario").asText(); 
//    	String password=nodo.findPath("password").asText();
//    	
//    	
//    	Query q=JPA.em().createQuery("from Paciente p where p.usuario=:usr");
//    	q.setParameter("usr", user);
//    	
//    	List<Paciente> l=q.getResultList();
//    	
//		if(l.size()==0)
//			return badRequest("El usuario no se encuentra registrado");
//		
//		else
//		{
//			n=l.get(0);
//			if(n.getPassword().equals(password))
//				session(n.getUsuario());
//	
//			else
//				return badRequest("Password incorrecto");
//		}
		
//		 return Results.created(Json.toJson(n));
    
    	return redirect(controllers.routes.PacienteController.getAll());
    }
    
}
