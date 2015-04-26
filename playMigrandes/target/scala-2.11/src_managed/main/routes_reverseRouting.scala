// @SOURCE:C:/Users/template/workspace/playMigrandes/conf/routes
// @HASH:4b341ca4a0b05ebc1982fcc62d102f53e85c6a4a
// @DATE:Fri Apr 24 11:28:29 COT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:69
// @LINE:64
// @LINE:61
// @LINE:56
// @LINE:53
// @LINE:49
// @LINE:42
// @LINE:36
// @LINE:33
// @LINE:22
// @LINE:19
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:69
class ReverseEpisodioController {


// @LINE:69
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "episodio/new")
}
                        

}
                          

// @LINE:14
class ReverseAssets {


// @LINE:14
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:64
// @LINE:61
class ReverseMedicamentoController {


// @LINE:64
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "medicamento")
}
                        

// @LINE:61
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "medicamento/new")
}
                        

}
                          

// @LINE:56
// @LINE:53
// @LINE:49
// @LINE:42
// @LINE:36
// @LINE:33
class ReversePacienteController {


// @LINE:33
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "paciente/new")
}
                        

// @LINE:56
def verEpisodioFull(id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "paciente/episodioCompleto/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:53
def verEpisodiosPacienteFecha(idp:Integer, fechaIn:String, fechaFin:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "paciente/getEpisodios/" + implicitly[PathBindable[Integer]].unbind("idp", idp) + "/" + implicitly[PathBindable[String]].unbind("fechaIn", dynamicString(fechaIn)) + "/" + implicitly[PathBindable[String]].unbind("fechaFin", dynamicString(fechaFin)))
}
                        

// @LINE:36
def getAll(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "paciente")
}
                        

// @LINE:49
def verEpisodiosPaciente(id:Integer): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "paciente/getAllEpisodios/" + implicitly[PathBindable[Integer]].unbind("id", id))
}
                        

// @LINE:42
def delete(id:Integer): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "paciente/" + implicitly[PathBindable[Integer]].unbind("id", id))
}
                        

}
                          

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {


// @LINE:10
def profile(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "profile")
}
                        

// @LINE:11
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:9
def postLogin(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                        

// @LINE:8
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          

// @LINE:22
// @LINE:19
class ReverseDoctorController {


// @LINE:19
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "doctor")
}
                        

// @LINE:22
def darDoctores(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "doctor")
}
                        

}
                          
}
                  


// @LINE:69
// @LINE:64
// @LINE:61
// @LINE:56
// @LINE:53
// @LINE:49
// @LINE:42
// @LINE:36
// @LINE:33
// @LINE:22
// @LINE:19
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:69
class ReverseEpisodioController {


// @LINE:69
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.EpisodioController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "episodio/new"})
      }
   """
)
                        

}
              

// @LINE:14
class ReverseAssets {


// @LINE:14
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:64
// @LINE:61
class ReverseMedicamentoController {


// @LINE:64
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MedicamentoController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "medicamento"})
      }
   """
)
                        

// @LINE:61
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MedicamentoController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "medicamento/new"})
      }
   """
)
                        

}
              

// @LINE:56
// @LINE:53
// @LINE:49
// @LINE:42
// @LINE:36
// @LINE:33
class ReversePacienteController {


// @LINE:33
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/new"})
      }
   """
)
                        

// @LINE:56
def verEpisodioFull : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.verEpisodioFull",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/episodioCompleto/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:53
def verEpisodiosPacienteFecha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.verEpisodiosPacienteFecha",
   """
      function(idp,fechaIn,fechaFin) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/getEpisodios/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("idp", idp) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("fechaIn", encodeURIComponent(fechaIn)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("fechaFin", encodeURIComponent(fechaFin))})
      }
   """
)
                        

// @LINE:36
def getAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.getAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente"})
      }
   """
)
                        

// @LINE:49
def verEpisodiosPaciente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.verEpisodiosPaciente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/getAllEpisodios/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:42
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PacienteController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "paciente/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

}
              

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {


// @LINE:10
def profile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.profile",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
      }
   """
)
                        

// @LINE:11
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:9
def postLogin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.postLogin",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:8
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              

// @LINE:22
// @LINE:19
class ReverseDoctorController {


// @LINE:19
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DoctorController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "doctor"})
      }
   """
)
                        

// @LINE:22
def darDoctores : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DoctorController.darDoctores",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "doctor"})
      }
   """
)
                        

}
              
}
        


// @LINE:69
// @LINE:64
// @LINE:61
// @LINE:56
// @LINE:53
// @LINE:49
// @LINE:42
// @LINE:36
// @LINE:33
// @LINE:22
// @LINE:19
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:69
class ReverseEpisodioController {


// @LINE:69
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.EpisodioController.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.EpisodioController", "create", Seq(), "POST", """Crear Episodio""", _prefix + """episodio/new""")
)
                      

}
                          

// @LINE:14
class ReverseAssets {


// @LINE:14
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:64
// @LINE:61
class ReverseMedicamentoController {


// @LINE:64
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MedicamentoController.getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.MedicamentoController", "getAll", Seq(), "GET", """Dar todos los medicamentos""", _prefix + """medicamento""")
)
                      

// @LINE:61
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MedicamentoController.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.MedicamentoController", "create", Seq(), "POST", """Crear medicamento""", _prefix + """medicamento/new""")
)
                      

}
                          

// @LINE:56
// @LINE:53
// @LINE:49
// @LINE:42
// @LINE:36
// @LINE:33
class ReversePacienteController {


// @LINE:33
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "create", Seq(), "POST", """Crear Paciente""", _prefix + """paciente/new""")
)
                      

// @LINE:56
def verEpisodioFull(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.verEpisodioFull(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodioFull", Seq(classOf[String]), "GET", """Ver revisar un episodio completo""", _prefix + """paciente/episodioCompleto/$id<[^/]+>""")
)
                      

// @LINE:53
def verEpisodiosPacienteFecha(idp:Integer, fechaIn:String, fechaFin:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.verEpisodiosPacienteFecha(idp, fechaIn, fechaFin), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPacienteFecha", Seq(classOf[Integer], classOf[String], classOf[String]), "GET", """Ver episodios en fecha""", _prefix + """paciente/getEpisodios/$idp<[^/]+>/$fechaIn<[^/]+>/$fechaFin<[^/]+>""")
)
                      

// @LINE:36
def getAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.getAll(), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "getAll", Seq(), "GET", """Dar todos los pacientes""", _prefix + """paciente""")
)
                      

// @LINE:49
def verEpisodiosPaciente(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.verEpisodiosPaciente(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPaciente", Seq(classOf[Integer]), "GET", """Ver todos los episodios de un paciente""", _prefix + """paciente/getAllEpisodios/$id<[^/]+>""")
)
                      

// @LINE:42
def delete(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PacienteController.delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "delete", Seq(classOf[Integer]), "DELETE", """Eliminar Paciente""", _prefix + """paciente/$id<[^/]+>""")
)
                      

}
                          

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {


// @LINE:10
def profile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.profile(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "profile", Seq(), "GET", """""", _prefix + """profile""")
)
                      

// @LINE:11
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:9
def postLogin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.postLogin(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "postLogin", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:8
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      

}
                          

// @LINE:22
// @LINE:19
class ReverseDoctorController {


// @LINE:19
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DoctorController.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "create", Seq(), "POST", """Crear Doctor""", _prefix + """doctor""")
)
                      

// @LINE:22
def darDoctores(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DoctorController.darDoctores(), HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "darDoctores", Seq(), "GET", """Ver todos los doctores""", _prefix + """doctor""")
)
                      

}
                          
}
        
    