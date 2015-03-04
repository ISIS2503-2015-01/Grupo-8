// @SOURCE:C:/act/PlayMigrandes/conf/routes
// @HASH:98f64e8217d144f487329be0341348621e5197e7
// @DATE:Mon Mar 02 16:05:09 COT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:41
// @LINE:37
// @LINE:25
// @LINE:13
// @LINE:9
// @LINE:6
package controllers {

// @LINE:13
class ReverseDoctorController {


// @LINE:13
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "doctor")
}
                        

}
                          

// @LINE:41
// @LINE:37
// @LINE:25
class ReversePacienteController {


// @LINE:25
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "paciente/new")
}
                        

// @LINE:41
// @LINE:37
def verEpisodiosPaciente(id:Long): Call = {
   (id: @unchecked) match {
// @LINE:37
case (id)  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "paciente/getEpisodio" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
                                         
   }
}
                                                

}
                          

// @LINE:9
class ReverseAssets {


// @LINE:9
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  


// @LINE:41
// @LINE:37
// @LINE:25
// @LINE:13
// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:13
class ReverseDoctorController {


// @LINE:13
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DoctorController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "doctor"})
      }
   """
)
                        

}
              

// @LINE:41
// @LINE:37
// @LINE:25
class ReversePacienteController {


// @LINE:25
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/new"})
      }
   """
)
                        

// @LINE:41
// @LINE:37
def verEpisodiosPaciente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.verEpisodiosPaciente",
   """
      function(id) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/getEpisodio" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/getDoloresPaciente" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idp", id)])})
      }
      }
   """
)
                        

}
              

// @LINE:9
class ReverseAssets {


// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:6
class ReverseApplication {


// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:41
// @LINE:37
// @LINE:25
// @LINE:13
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:13
class ReverseDoctorController {


// @LINE:13
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DoctorController.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "create", Seq(), "POST", """--------------------------------DOCTOR----------------------------------------------------------------------------
Crear Doctor""", _prefix + """doctor""")
)
                      

}
                          

// @LINE:41
// @LINE:37
// @LINE:25
class ReversePacienteController {


// @LINE:25
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "create", Seq(), "POST", """Crear Paciente""", _prefix + """paciente/new""")
)
                      

// @LINE:37
def verEpisodiosPaciente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.verEpisodiosPaciente(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPaciente", Seq(classOf[Long]), "GET", """Ver todos los episodios de un paciente""", _prefix + """paciente/getEpisodio""")
)
                      

}
                          

// @LINE:9
class ReverseAssets {


// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:6
class ReverseApplication {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    