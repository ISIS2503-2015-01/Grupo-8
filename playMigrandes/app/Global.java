import modelos.Doctor;
import modelos.SecurityRole;
import modelos.SecurityRole.Builder;
import play.Application;
import play.GlobalSettings;
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

				Doctor d=new Doctor("admin", "admin", "admin");
				Builder b=new Builder();
				b.roleName("admin");
				SecurityRole s=b.build();
				s.id=(long) 1;
				if(JPA.em().find(SecurityRole.class, (long) 1) == null)
				{
					JPA.em().persist(s);
					d.agregarRol(s);
					JPA.em().persist(d);
				}

			}
		});

	}

}
