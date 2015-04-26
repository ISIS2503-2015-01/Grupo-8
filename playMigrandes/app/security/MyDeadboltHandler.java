package security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.mutable.MutableLong;

import modelos.Doctor;
import modelos.SecurityRole;
import modelos.SecurityRole.Builder;
import play.Logger;
import play.db.jpa.JPA;
import play.libs.F;
import play.libs.F.Promise;
import play.mvc.Http;
import play.mvc.Http.Context;
import play.mvc.Result;
import be.objectify.deadbolt.core.models.Role;
import be.objectify.deadbolt.core.models.Subject;
import be.objectify.deadbolt.java.AbstractDeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;

public class MyDeadboltHandler extends AbstractDeadboltHandler
{
	private final DynamicResourceHandler dynamicHandler;

    public MyDeadboltHandler()
    {
        Map<String, DynamicResourceHandler> delegates = new HashMap<String, DynamicResourceHandler>();
        delegates.put("niceName",
                      new NiceNameDynamicResourceHandler());
        this.dynamicHandler = new CompositeDynamicResourceHandler(delegates);
    }

    //@play.db.jpa.Transactional
    public Subject getSubject(final Http.Context context)
    {
    	final MutableLong a = new MutableLong();
    	
    	JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable 
			{
				String n=context.session().get("email");
		    	Logger.info("Sesion abierta: "+n);
		    	Subject d=JPA.em().find(Doctor.class, n);
		    	List<? extends Role> l=d.getRoles();
		    	if(l.get(0)!=null)
		    	{
		    		if(l.get(0).getName().equals("admin"))
		    			a.add(1);
		    		if(l.get(0).getName().equals("doctor"))
		    			a.add(2);
		    		if(l.get(0).getName().equals("paciente"))
		    			a.add(3);
		    	}
		    		
			}
		});
    	
    	long v=a.getValue();
    	Doctor d=new Doctor("asd","asd","asd");Builder b=new Builder();
    	
    	if(v==1)
    		b.roleName("admin");
    	
    	if(v==2)
    		b.roleName("doctor");
    	
    	d.agregarRol(b.build());
    	
    	return d;
    		
    		
    	
    }

    @Override
    public F.Promise<Result> beforeAuthCheck(Http.Context context)
    {
        return F.Promise.pure(null);
    }

    @Override
    public DynamicResourceHandler getDynamicResourceHandler(Http.Context context)
    {
        return dynamicHandler;
    }

}
