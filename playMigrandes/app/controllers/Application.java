package controllers;

import persistence.PersistenceManager;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() 
    {
    	
    	//TODO conectar a la persistence
    	/**
    	     	PersistenceManager.getInstance().getEntityManagerFactory();

    	 */
    	
        return ok("ola ke ase");
    }
}
