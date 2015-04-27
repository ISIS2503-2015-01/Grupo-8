import modelos.Doctor;
import modelos.SecurityRole;
import modelos.SecurityRole.Builder;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;


public class Global extends GlobalSettings {

	/**
	 * Initialize the system with some sample contacts.
	 * @param app The application.
	 */
	@Transactional
	public void onStart(Application app) 
	{
		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable 
			{

				Logger.info("bien");
				if(JPA.em().find(SecurityRole.class, (long) 1) == null)
				{
					Logger.info("Roles Admin");
					Builder b=new Builder();
					b.roleName("admin");
					SecurityRole s=b.build();
					s.id=(long) 1;
					JPA.em().persist(s);
					
					Doctor d=new Doctor("admin", "admin", "admin");
					d.agregarRol(s);
					JPA.em().persist(d);
					Logger.info("Roles Admin Ready");
				}
				
				if(JPA.em().find(SecurityRole.class, (long) 2) == null)
				{
					Logger.info("Roles Doctor");
					Builder bb=new Builder();
					bb.roleName("doctor");
					SecurityRole ss=bb.build();
					ss.id=(long) 2;
					JPA.em().persist(ss);
					Logger.info("Roles Doctor Ready");
				}
				
				if(JPA.em().find(SecurityRole.class, (long) 3) == null)
				{
					Logger.info("Roles Paciente");
					
					Builder bb=new Builder();
					bb.roleName("paciente");
					SecurityRole ss=bb.build();
					ss.id=(long) 3;
					
					Logger.info("Roles Paciente Build");
					JPA.em().persist(ss);
					Logger.info("Roles Paciente Ready");
				}

			}
		});

	}

}
