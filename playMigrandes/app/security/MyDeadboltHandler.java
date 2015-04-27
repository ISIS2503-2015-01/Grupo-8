package security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.lang3.mutable.MutableLong;

import modelos.Doctor;
import modelos.Paciente;
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

	public Subject getSubject(final Http.Context context)
	{
		final MutableLong rol = new MutableLong();
		final MutableLong subject=new MutableLong();

		if(context.session().get("email")!=null)
		{
			JPA.withTransaction(new play.libs.F.Callback0() {
				@Override
				public void invoke() throws Throwable 
				{
					String n=context.session().get("email");
					Logger.info("Sesion abierta: "+n);

					Subject s=null;

					Doctor isD=JPA.em().find(Doctor.class, n);

					Query query = JPA.em().createQuery("select p from Paciente p where p.email='"+n+"'" );
					Paciente isP=null;
					if(!query.getResultList().isEmpty())
						isP=(Paciente)query.getSingleResult();

					if(isD!=null)
					{
						s=isD;
						subject.add(1); // 1 Si es Doctor
					}
					else if(isP!=null)
					{
						s=isP;
						subject.add(2); // 2 Si es Paciente
					}



					List<? extends Role> l=s.getRoles();
					if(l.get(0)!=null)
					{
						if(l.get(0).getName().equals("admin"))
							rol.add(1);

						if(l.get(0).getName().equals("doctor"))
							rol.add(2);

						if(l.get(0).getName().equals("paciente"))
							rol.add(3);
					}

				}
			});

			long rolV=rol.getValue();
			long subV=subject.getValue();
			Builder b=new Builder();
			Doctor d=null;
			Paciente p=null;

			if(subV==1)
			{
				d=new Doctor("asd","asd","asd");
				if(rolV==1)
					b.roleName("admin");

				if(rolV==2)
					b.roleName("doctor");

				d.agregarRol(b.build());

				return d;
			}
			else
			{
				p=new Paciente(1,"a","a","a");
				b.roleName("paciente");
				p.agregarRol(b.build());

				return p;

			}
		}
		else
		{
			Logger.info("retornando null");
			return null;
		}
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
