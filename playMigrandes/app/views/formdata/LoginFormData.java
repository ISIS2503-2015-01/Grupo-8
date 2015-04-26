package views.formdata;

import play.data.validation.ValidationError;
import play.db.jpa.JPA;

import java.util.ArrayList;
import java.util.List;

import modelos.Doctor;

public class LoginFormData 
{
	  /** The submitted email. */
	  public String email = "";
	  
	  /** The submitted password. */
	  public String password = "";

	  /** Required for form instantiation. */
	  public LoginFormData() 
	  {
	  }

	  /**
	   * Validates Form<LoginFormData>.
	   * Called automatically in the controller by bindFromRequest().
	   * Checks to see that email and password are valid credentials.
	   * @return Null if valid, or a List[ValidationError] if problems found.
	   */
	  public List<ValidationError> validate() {

	    List<ValidationError> errors = new ArrayList<>();
	    
	    Doctor d= JPA.em().find(Doctor.class, email);
	    
	    if (d==null || !d.getPassword().equals(password)) 
	    {
	      errors.add(new ValidationError("email", ""));
	      errors.add(new ValidationError("password", ""));      
	    }

	    return (errors.size() > 0) ? errors : null;
	  }


}
