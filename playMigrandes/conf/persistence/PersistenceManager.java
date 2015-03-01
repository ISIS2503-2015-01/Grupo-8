package persistence;

/*
 * Tomado de: http://javanotepad.blogspot.com/2007/05/jpa-entitymanagerfactory-in-web.html
 * la cual fue tomada del Lab de JPA
 */
 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class PersistenceManager {
 
    public static final boolean DEBUG = true;
    private static final PersistenceManager singleton = new PersistenceManager();
    protected EntityManagerFactory emf;
 
    public static PersistenceManager getInstance() {
 
        return singleton;
    }
 
 
    private PersistenceManager() {
    }
 
    public EntityManagerFactory getEntityManagerFactory() {
 
        if (emf == null) 
        {
            createEntityManagerFactory();
        }
        return emf;
    }
 
    public void closeEntityManagerFactory() {
 
        if (emf != null) {
            emf.close();
            emf = null;
            if (DEBUG) {
                System.out.println("Persistence finalizada a " + new java.util.Date());
            }
        }
    }
 
    protected void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("migrandesJPA", System.getProperties());
        if (DEBUG) {
            System.out.println("Persistence comenzada a " + new java.util.Date());
        }
    }
} 