// @SOURCE:C:/Users/template/workspace/playMigrandes/conf/routes
// @HASH:bdbe5868a21e7be5b2bbbfa0f095a7371d34d1e9
// @DATE:Sat Mar 07 13:13:45 COT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:47
// @LINE:43
// @LINE:34
// @LINE:28
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
                          

// @LINE:47
// @LINE:43
// @LINE:34
// @LINE:28
class ReversePacienteController {


// @LINE:34
def delete(id:Integer): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "paciente/" + implicitly[PathBindable[Integer]].unbind("id", id))
}
                        

// @LINE:28
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "paciente/new")
}
                        

// @LINE:43
def verEpisodiosPaciente(id:Integer): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "paciente/getAllEpisodios/" + implicitly[PathBindable[Integer]].unbind("id", id))
}
                        

// @LINE:47
def verEpisodiosPacienteFecha(idp:Integer, fechaIn:String, fechaFin:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "paciente/getEpisodios/" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("idp", idp)), Some(implicitly[QueryStringBindable[String]].unbind("fechaIn", fechaIn)), Some(implicitly[QueryStringBindable[String]].unbind("fechaFin", fechaFin)))))
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
                  


// @LINE:47
// @LINE:43
// @LINE:34
// @LINE:28
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
              

// @LINE:47
// @LINE:43
// @LINE:34
// @LINE:28
class ReversePacienteController {


// @LINE:34
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:28
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/new"})
      }
   """
)
                        

// @LINE:43
def verEpisodiosPaciente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.verEpisodiosPaciente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/getAllEpisodios/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:47
def verEpisodiosPacienteFecha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.verEpisodiosPacienteFecha",
   """
      function(idp,fechaIn,fechaFin) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/getEpisodios/" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("idp", idp), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fechaIn", fechaIn), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fechaFin", fechaFin)])})
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
        


// @LINE:47
// @LINE:43
// @LINE:34
// @LINE:28
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
                          

// @LINE:47
// @LINE:43
// @LINE:34
// @LINE:28
class ReversePacienteController {


// @LINE:34
def delete(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "delete", Seq(classOf[Integer]), "DELETE", """Eliminar Paciente""", _prefix + """paciente/$id<[^/]+>""")
)
                      

// @LINE:28
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "create", Seq(), "POST", """Crear Paciente""", _prefix + """paciente/new""")
)
                      

// @LINE:43
def verEpisodiosPaciente(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.verEpisodiosPaciente(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPaciente", Seq(classOf[Integer]), "GET", """Ver todos los episodios de un paciente""", _prefix + """paciente/getAllEpisodios/$id<[^/]+>""")
)
                      

// @LINE:47
def verEpisodiosPacienteFecha(idp:Integer, fechaIn:String, fechaFin:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.verEpisodiosPacienteFecha(idp, fechaIn, fechaFin), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPacienteFecha", Seq(classOf[Integer], classOf[String], classOf[String]), "GET", """Ver episodios en fecha""", _prefix + """paciente/getEpisodios/""")
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
        
    