package controllers;


import java.util.List;

import javax.persistence.Query;

import modelos.Doctor;
import modelos.Paciente;
import modelos.SecurityRole;
import modelos.SecurityRole.Builder;

import com.fasterxml.jackson.databind.JsonNode;

import play.*;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import views.html.*;
import views.formdata.LoginFormData;

public class Application extends Controller {


	/**
	 * Provides the Index page.
	 * @return The Index page. 
	 */
	@play.db.jpa.Transactional
	public static Result index() 
	{
		Doctor d=null;

		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		return ok(index.render("Home", false, Secured.getUserInfo(ctx(),d)));
	}

	/**
	 * Provides the Login page (only to unauthenticated users). 
	 * @return The Login page. 
	 */
	@play.db.jpa.Transactional
	public static Result login() 
	{
		Doctor d=null;

		if(Secured.isLoggedIn(ctx()))
		{
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		}

		Form<LoginFormData> formData = Form.form(LoginFormData.class);
		return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(),d), formData));
	}

	/**
	 * Processes a login form submission from an unauthenticated user. 
	 * First we bind the HTTP POST data to an instance of LoginFormData.
	 * The binding process will invoke the LoginFormData.validate() method.
	 * If errors are found, re-render the page, displaying the error data. 
	 * If errors not found, render the page with the good data. 
	 * @return The index page with the results of validation. 
	 */
	@play.db.jpa.Transactional
	public static Result postLogin() {
		Doctor d=null;

		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		// Get the submitted form data from the request object, and run validation.
		Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

		if (formData.hasErrors()) {
			flash("error", "Login credentials not valid.");
			return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(),d), formData));
		}
		else {

			// email/password OK, so now we set the session variable and only go to authenticated pages.
			session().clear();
			session("email", formData.get().email);
			return redirect(routes.Application.profile());
		}
	}



	@play.db.jpa.Transactional
	public static Result postLoginP() {
		Paciente d=null;
		
		JsonNode nodo = Controller.request().body().asJson();
		String email = nodo.findPath("login").asText();
		String password = nodo.findPath("password").asText();
		Logger.info("current user :"+email);
		Query query = JPA.em().createQuery("select p from Paciente p where p.email='"+email+"'" );
		
		if(!query.getResultList().isEmpty())
			d=(Paciente)query.getSingleResult();

		if(d==null)
		{
			return notFound("usuario no encontradp");
		}

		else
		{
			if (d.getPassword().equals(password)) 
			{
				session().clear();
				session("email",email);
				Logger.info("Estas logueado :"+email);
				return ok(Json.toJson(d));
			}
			return badRequest();		
		}
	}

	@Security.Authenticated(SecuredP.class)
	public static Result logoutP()
	{
		Logger.info("Finalizo");
		session().clear();


		return ok("Sesion Finalizada");
	}

	/**
	 * Logs out (only for authenticated users) and returns them to the Index page. 
	 * @return A redirect to the Index page. 
	 */
	@Security.Authenticated(Secured.class)
	public static Result logout() {
		session().clear();
		return redirect(routes.Application.index());
	}

	/**
	 * Provides the Profile page (only to authenticated users).
	 * @return The Profile page. 
	 */
	@play.db.jpa.Transactional
	@Security.Authenticated(Secured.class)
	public static Result profile() {
		Doctor d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));
		return ok(Profile.render("Profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(),d)));
	}

}
