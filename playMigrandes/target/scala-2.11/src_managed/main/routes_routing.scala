// @SOURCE:C:/Programas/activator/playMigrandes/conf/routes
// @HASH:ccf93b46676b435c480bdbfe8fc746827ce2f725
// @DATE:Wed Feb 18 19:47:31 COT 2015


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
private[this] lazy val controllers_DoctorController_delete2_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("doctores"))))
private[this] lazy val controllers_DoctorController_delete2_invoker = createInvoker(
controllers.DoctorController.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """doctores"""))
        

// @LINE:15
private[this] lazy val controllers_DoctorController_buscarPacientePorId3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getDoloresPaciente"))))
private[this] lazy val controllers_DoctorController_buscarPacientePorId3_invoker = createInvoker(
controllers.DoctorController.buscarPacientePorId(fakeValue[Long], fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DoctorController", "buscarPacientePorId", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """getDoloresPaciente"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """doctores""","""controllers.DoctorController.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getDoloresPaciente""","""controllers.DoctorController.buscarPacientePorId(id:Long, idp:Long)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_DoctorController_delete2_route(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        controllers_DoctorController_delete2_invoker.call(controllers.DoctorController.delete(id))
   }
}
        

// @LINE:15
case controllers_DoctorController_buscarPacientePorId3_route(params) => {
   call(params.fromQuery[Long]("id", None), params.fromQuery[Long]("idp", None)) { (id, idp) =>
        controllers_DoctorController_buscarPacientePorId3_invoker.call(controllers.DoctorController.buscarPacientePorId(id, idp))
   }
}
        
}

}
     