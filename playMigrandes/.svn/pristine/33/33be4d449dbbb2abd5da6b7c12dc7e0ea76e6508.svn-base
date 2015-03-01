// @SOURCE:C:/Users/template/Desktop/Grupo-8-master/playMigrandes/conf/routes
// @HASH:98f64e8217d144f487329be0341348621e5197e7
// @DATE:Fri Feb 27 11:18:56 COT 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:13
private[this] lazy val controllers_DoctorController_create2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("doctor"))))
private[this] lazy val controllers_DoctorController_create2_invoker = createInvoker(
controllers.DoctorController.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "create", Nil,"POST", """--------------------------------DOCTOR----------------------------------------------------------------------------
Crear Doctor""", Routes.prefix + """doctor"""))
        

// @LINE:25
private[this] lazy val controllers_PacienteController_create3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/new"))))
private[this] lazy val controllers_PacienteController_create3_invoker = createInvoker(
controllers.PacienteController.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "create", Nil,"POST", """Crear Paciente""", Routes.prefix + """paciente/new"""))
        

// @LINE:37
private[this] lazy val controllers_PacienteController_verEpisodiosPaciente4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/getEpisodio"))))
private[this] lazy val controllers_PacienteController_verEpisodiosPaciente4_invoker = createInvoker(
controllers.PacienteController.verEpisodiosPaciente(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPaciente", Seq(classOf[Long]),"GET", """Ver todos los episodios de un paciente""", Routes.prefix + """paciente/getEpisodio"""))
        

// @LINE:41
private[this] lazy val controllers_PacienteController_verEpisodiosPaciente5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/getDoloresPaciente"))))
private[this] lazy val controllers_PacienteController_verEpisodiosPaciente5_invoker = createInvoker(
controllers.PacienteController.verEpisodiosPaciente(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPaciente", Seq(classOf[Long]),"GET", """Ver episodio""", Routes.prefix + """paciente/getDoloresPaciente"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """doctor""","""controllers.DoctorController.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/new""","""controllers.PacienteController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/getEpisodio""","""controllers.PacienteController.verEpisodiosPaciente(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/getDoloresPaciente""","""controllers.PacienteController.verEpisodiosPaciente(idp:Long)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:9
case controllers_Assets_at1_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:13
case controllers_DoctorController_create2_route(params) => {
   call { 
        controllers_DoctorController_create2_invoker.call(controllers.DoctorController.create())
   }
}
        

// @LINE:25
case controllers_PacienteController_create3_route(params) => {
   call { 
        controllers_PacienteController_create3_invoker.call(controllers.PacienteController.create())
   }
}
        

// @LINE:37
case controllers_PacienteController_verEpisodiosPaciente4_route(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        controllers_PacienteController_verEpisodiosPaciente4_invoker.call(controllers.PacienteController.verEpisodiosPaciente(id))
   }
}
        

// @LINE:41
case controllers_PacienteController_verEpisodiosPaciente5_route(params) => {
   call(params.fromQuery[Long]("idp", None)) { (idp) =>
        controllers_PacienteController_verEpisodiosPaciente5_invoker.call(controllers.PacienteController.verEpisodiosPaciente(idp))
   }
}
        
}

}
     