// @SOURCE:C:/Users/template/workspace/playMigrandes/conf/routes
// @HASH:ccf93b46676b435c480bdbfe8fc746827ce2f725
// @DATE:Thu Feb 19 11:14:33 COT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:15
// @LINE:13
// @LINE:9
// @LINE:6
package controllers {

// @LINE:15
// @LINE:13
class ReverseDoctorController {


// @LINE:15
def buscarPacientePorId(id:Long, idp:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "getDoloresPaciente" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[Long]].unbind("idp", idp)))))
}
                        

// @LINE:13
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "doctores" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
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
                  


// @LINE:15
// @LINE:13
// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:15
// @LINE:13
class ReverseDoctorController {


// @LINE:15
def buscarPacientePorId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DoctorController.buscarPacientePorId",
   """
      function(id,idp) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getDoloresPaciente" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idp", idp)])})
      }
   """
)
                        

// @LINE:13
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DoctorController.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "doctores" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
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
        


// @LINE:15
// @LINE:13
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:15
// @LINE:13
class ReverseDoctorController {


// @LINE:15
def buscarPacientePorId(id:Long, idp:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DoctorController.buscarPacientePorId(id, idp), HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "buscarPacientePorId", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """getDoloresPaciente""")
)
                      

// @LINE:13
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DoctorController.delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """doctores""")
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
        
    