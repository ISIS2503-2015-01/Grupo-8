// @SOURCE:C:/Users/template/workspace/playMigrandes/conf/routes
// @HASH:4b341ca4a0b05ebc1982fcc62d102f53e85c6a4a
// @DATE:Fri Apr 24 11:28:29 COT 2015


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
        

// @LINE:8
private[this] lazy val controllers_Application_login1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_login1_invoker = createInvoker(
controllers.Application.login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Nil,"GET", """""", Routes.prefix + """login"""))
        

// @LINE:9
private[this] lazy val controllers_Application_postLogin2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_postLogin2_invoker = createInvoker(
controllers.Application.postLogin(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "postLogin", Nil,"POST", """""", Routes.prefix + """login"""))
        

// @LINE:10
private[this] lazy val controllers_Application_profile3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile"))))
private[this] lazy val controllers_Application_profile3_invoker = createInvoker(
controllers.Application.profile(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "profile", Nil,"GET", """""", Routes.prefix + """profile"""))
        

// @LINE:11
private[this] lazy val controllers_Application_logout4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_Application_logout4_invoker = createInvoker(
controllers.Application.logout(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:14
private[this] lazy val controllers_Assets_at5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at5_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:19
private[this] lazy val controllers_DoctorController_create6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("doctor"))))
private[this] lazy val controllers_DoctorController_create6_invoker = createInvoker(
controllers.DoctorController.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "create", Nil,"POST", """Crear Doctor""", Routes.prefix + """doctor"""))
        

// @LINE:22
private[this] lazy val controllers_DoctorController_darDoctores7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("doctor"))))
private[this] lazy val controllers_DoctorController_darDoctores7_invoker = createInvoker(
controllers.DoctorController.darDoctores(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "darDoctores", Nil,"GET", """Ver todos los doctores""", Routes.prefix + """doctor"""))
        

// @LINE:33
private[this] lazy val controllers_PacienteController_create8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/new"))))
private[this] lazy val controllers_PacienteController_create8_invoker = createInvoker(
controllers.PacienteController.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "create", Nil,"POST", """Crear Paciente""", Routes.prefix + """paciente/new"""))
        

// @LINE:36
private[this] lazy val controllers_PacienteController_getAll9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente"))))
private[this] lazy val controllers_PacienteController_getAll9_invoker = createInvoker(
controllers.PacienteController.getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "getAll", Nil,"GET", """Dar todos los pacientes""", Routes.prefix + """paciente"""))
        

// @LINE:42
private[this] lazy val controllers_PacienteController_delete10_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PacienteController_delete10_invoker = createInvoker(
controllers.PacienteController.delete(fakeValue[Integer]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "delete", Seq(classOf[Integer]),"DELETE", """Eliminar Paciente""", Routes.prefix + """paciente/$id<[^/]+>"""))
        

// @LINE:49
private[this] lazy val controllers_PacienteController_verEpisodiosPaciente11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/getAllEpisodios/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PacienteController_verEpisodiosPaciente11_invoker = createInvoker(
controllers.PacienteController.verEpisodiosPaciente(fakeValue[Integer]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPaciente", Seq(classOf[Integer]),"GET", """Ver todos los episodios de un paciente""", Routes.prefix + """paciente/getAllEpisodios/$id<[^/]+>"""))
        

// @LINE:53
private[this] lazy val controllers_PacienteController_verEpisodiosPacienteFecha12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/getEpisodios/"),DynamicPart("idp", """[^/]+""",true),StaticPart("/"),DynamicPart("fechaIn", """[^/]+""",true),StaticPart("/"),DynamicPart("fechaFin", """[^/]+""",true))))
private[this] lazy val controllers_PacienteController_verEpisodiosPacienteFecha12_invoker = createInvoker(
controllers.PacienteController.verEpisodiosPacienteFecha(fakeValue[Integer], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodiosPacienteFecha", Seq(classOf[Integer], classOf[String], classOf[String]),"GET", """Ver episodios en fecha""", Routes.prefix + """paciente/getEpisodios/$idp<[^/]+>/$fechaIn<[^/]+>/$fechaFin<[^/]+>"""))
        

// @LINE:56
private[this] lazy val controllers_PacienteController_verEpisodioFull13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paciente/episodioCompleto/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PacienteController_verEpisodioFull13_invoker = createInvoker(
controllers.PacienteController.verEpisodioFull(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PacienteController", "verEpisodioFull", Seq(classOf[String]),"GET", """Ver revisar un episodio completo""", Routes.prefix + """paciente/episodioCompleto/$id<[^/]+>"""))
        

// @LINE:61
private[this] lazy val controllers_MedicamentoController_create14_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("medicamento/new"))))
private[this] lazy val controllers_MedicamentoController_create14_invoker = createInvoker(
controllers.MedicamentoController.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.MedicamentoController", "create", Nil,"POST", """Crear medicamento""", Routes.prefix + """medicamento/new"""))
        

// @LINE:64
private[this] lazy val controllers_MedicamentoController_getAll15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("medicamento"))))
private[this] lazy val controllers_MedicamentoController_getAll15_invoker = createInvoker(
controllers.MedicamentoController.getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.MedicamentoController", "getAll", Nil,"GET", """Dar todos los medicamentos""", Routes.prefix + """medicamento"""))
        

// @LINE:69
private[this] lazy val controllers_EpisodioController_create16_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("episodio/new"))))
private[this] lazy val controllers_EpisodioController_create16_invoker = createInvoker(
controllers.EpisodioController.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.EpisodioController", "create", Nil,"POST", """Crear Episodio""", Routes.prefix + """episodio/new"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.postLogin()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile""","""controllers.Application.profile()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """doctor""","""controllers.DoctorController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """doctor""","""controllers.DoctorController.darDoctores()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/new""","""controllers.PacienteController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente""","""controllers.PacienteController.getAll()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/$id<[^/]+>""","""controllers.PacienteController.delete(id:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/getAllEpisodios/$id<[^/]+>""","""controllers.PacienteController.verEpisodiosPaciente(id:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/getEpisodios/$idp<[^/]+>/$fechaIn<[^/]+>/$fechaFin<[^/]+>""","""controllers.PacienteController.verEpisodiosPacienteFecha(idp:Integer, fechaIn:String, fechaFin:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paciente/episodioCompleto/$id<[^/]+>""","""controllers.PacienteController.verEpisodioFull(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """medicamento/new""","""controllers.MedicamentoController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """medicamento""","""controllers.MedicamentoController.getAll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """episodio/new""","""controllers.EpisodioController.create()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:8
case controllers_Application_login1_route(params) => {
   call { 
        controllers_Application_login1_invoker.call(controllers.Application.login())
   }
}
        

// @LINE:9
case controllers_Application_postLogin2_route(params) => {
   call { 
        controllers_Application_postLogin2_invoker.call(controllers.Application.postLogin())
   }
}
        

// @LINE:10
case controllers_Application_profile3_route(params) => {
   call { 
        controllers_Application_profile3_invoker.call(controllers.Application.profile())
   }
}
        

// @LINE:11
case controllers_Application_logout4_route(params) => {
   call { 
        controllers_Application_logout4_invoker.call(controllers.Application.logout())
   }
}
        

// @LINE:14
case controllers_Assets_at5_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at5_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:19
case controllers_DoctorController_create6_route(params) => {
   call { 
        controllers_DoctorController_create6_invoker.call(controllers.DoctorController.create())
   }
}
        

// @LINE:22
case controllers_DoctorController_darDoctores7_route(params) => {
   call { 
        controllers_DoctorController_darDoctores7_invoker.call(controllers.DoctorController.darDoctores())
   }
}
        

// @LINE:33
case controllers_PacienteController_create8_route(params) => {
   call { 
        controllers_PacienteController_create8_invoker.call(controllers.PacienteController.create())
   }
}
        

// @LINE:36
case controllers_PacienteController_getAll9_route(params) => {
   call { 
        controllers_PacienteController_getAll9_invoker.call(controllers.PacienteController.getAll())
   }
}
        

// @LINE:42
case controllers_PacienteController_delete10_route(params) => {
   call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_PacienteController_delete10_invoker.call(controllers.PacienteController.delete(id))
   }
}
        

// @LINE:49
case controllers_PacienteController_verEpisodiosPaciente11_route(params) => {
   call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_PacienteController_verEpisodiosPaciente11_invoker.call(controllers.PacienteController.verEpisodiosPaciente(id))
   }
}
        

// @LINE:53
case controllers_PacienteController_verEpisodiosPacienteFecha12_route(params) => {
   call(params.fromPath[Integer]("idp", None), params.fromPath[String]("fechaIn", None), params.fromPath[String]("fechaFin", None)) { (idp, fechaIn, fechaFin) =>
        controllers_PacienteController_verEpisodiosPacienteFecha12_invoker.call(controllers.PacienteController.verEpisodiosPacienteFecha(idp, fechaIn, fechaFin))
   }
}
        

// @LINE:56
case controllers_PacienteController_verEpisodioFull13_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PacienteController_verEpisodioFull13_invoker.call(controllers.PacienteController.verEpisodioFull(id))
   }
}
        

// @LINE:61
case controllers_MedicamentoController_create14_route(params) => {
   call { 
        controllers_MedicamentoController_create14_invoker.call(controllers.MedicamentoController.create())
   }
}
        

// @LINE:64
case controllers_MedicamentoController_getAll15_route(params) => {
   call { 
        controllers_MedicamentoController_getAll15_invoker.call(controllers.MedicamentoController.getAll())
   }
}
        

// @LINE:69
case controllers_EpisodioController_create16_route(params) => {
   call { 
        controllers_EpisodioController_create16_invoker.call(controllers.EpisodioController.create())
   }
}
        
}

}
     