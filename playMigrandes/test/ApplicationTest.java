import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

   @Test
    public void callIndex() {
   
	   Long idp=(long) 646546;
        Result result = controllers.PacienteController.verEpisodiosPaciente(idp);
        //assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("Json");
        //assertThat(charset(result)).isEqualTo("utf-8");
        assertThat(contentAsString(result)).contains("Paciente no encontrado");
    }
}



