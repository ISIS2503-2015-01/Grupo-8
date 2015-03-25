// @SOURCE:C:/Users/template/workspace/playMigrandes/conf/routes
// @HASH:0e1a8755ade15ce7a3f38afca8fc556e8c88eb13
// @DATE:Tue Mar 24 19:25:33 COT 2015


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
        

// @LINE:27
private[this] lazy val controllers_EpisodiosController_create3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("episodio/new"))))
private[this] lazy val controllers_EpisodiosController_create3_invoker = createInvoker(
controllers.EpisodiosController.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.EpisodiosController", "create", Nil,"POST", """""", Routes.prefix + """episodio/new"""))
        

// @LINE:30
private[this] lazy val controllers_PacienteController_create4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/new"))))
private[this] lazy val controllers_PacienteController_create4_invoker = createInvoker(
controllers.PacienteController.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "create", Nil,"POST", """Crear Paciente""", Routes.prefix + """paciente/new"""))
        

// @LINE:36
private[this] lazy val controllers_PacienteController_delete5_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PacienteController_delete5_invoker = createInvoker(
controllers.PacienteController.delete(fakeValue[Integer]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "delete", Seq(classOf[Integer]),"DELETE", """Eliminar Paciente""", Routes.prefix + """paciente/$id<[^/]+>"""))
        

// @LINE:43
private[this] lazy val controllers_PacienteController_verEpisodiosPaciente6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/getAllEpisodios/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PacienteController_verEpisodiosPaciente6_invoker = createInvoker(
controllers.PacienteController.verEpisodiosPaciente(fakeValue[Integer]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPaciente", Seq(classOf[Integer]),"GET", """Ver todos los episodios de un paciente""", Routes.prefix + """paciente/getAllEpisodios/$id<[^/]+>"""))
        

// @LINE:47
private[this] lazy val controllers_PacienteController_verEpisodiosPacienteFecha7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/getEpisodios/"),DynamicPart("idp", """[^/]+""",true),StaticPart("/"),DynamicPart("fechaIn", """[^/]+""",true),StaticPart("/"),DynamicPart("fechaFin", """[^/]+""",true))))
private[this] lazy val controllers_PacienteController_verEpisodiosPacienteFecha7_invoker = createInvoker(
controllers.PacienteController.verEpisodiosPacienteFecha(fakeValue[Integer], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPacienteFecha", Seq(classOf[Integer], classOf[String], classOf[String]),"GET", """Ver episodios en fecha""", Routes.prefix + """paciente/getEpisodios/$idp<[^/]+>/$fechaIn<[^/]+>/$fechaFin<[^/]+>"""))
        

// @LINE:50
private[this] lazy val controllers_PacienteController_verEpisodioFull8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/episodioCompleto/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PacienteController_verEpisodioFull8_invoker = createInvoker(
controllers.PacienteController.verEpisodioFull(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodioFull", Seq(classOf[String]),"GET", """Ver revisar un episodio completo""", Routes.prefix + """paciente/episodioCompleto/$id<[^/]+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """doctor""","""controllers.DoctorController.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """episodio/new""","""controllers.EpisodiosController.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/new""","""controllers.PacienteController.create()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/$id<[^/]+>""","""controllers.PacienteController.delete(id:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/getAllEpisodios/$id<[^/]+>""","""controllers.PacienteController.verEpisodiosPaciente(id:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/getEpisodios/$idp<[^/]+>/$fechaIn<[^/]+>/$fechaFin<[^/]+>""","""controllers.PacienteController.verEpisodiosPacienteFecha(idp:Integer, fechaIn:String, fechaFin:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/episodioCompleto/$id<[^/]+>""","""controllers.PacienteController.verEpisodioFull(id:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:27
case controllers_EpisodiosController_create3_route(params) => {
   call { 
        controllers_EpisodiosController_create3_invoker.call(controllers.EpisodiosController.create())
   }
}
        

// @LINE:30
case controllers_PacienteController_create4_route(params) => {
   call { 
        controllers_PacienteController_create4_invoker.call(controllers.PacienteController.create())
   }
}
        

// @LINE:36
case controllers_PacienteController_delete5_route(params) => {
   call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_PacienteController_delete5_invoker.call(controllers.PacienteController.delete(id))
   }
}
        

// @LINE:43
case controllers_PacienteController_verEpisodiosPaciente6_route(params) => {
   call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_PacienteController_verEpisodiosPaciente6_invoker.call(controllers.PacienteController.verEpisodiosPaciente(id))
   }
}
        

// @LINE:47
case controllers_PacienteController_verEpisodiosPacienteFecha7_route(params) => {
   call(params.fromPath[Integer]("idp", None), params.fromPath[String]("fechaIn", None), params.fromPath[String]("fechaFin", None)) { (idp, fechaIn, fechaFin) =>
        controllers_PacienteController_verEpisodiosPacienteFecha7_invoker.call(controllers.PacienteController.verEpisodiosPacienteFecha(idp, fechaIn, fechaFin))
   }
}
        

// @LINE:50
case controllers_PacienteController_verEpisodioFull8_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PacienteController_verEpisodioFull8_invoker.call(controllers.PacienteController.verEpisodioFull(id))
   }
}
        
}

}
     