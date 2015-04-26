
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
import modelos.Doctor
/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Boolean,Doctor,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(page: String, isLoggedIn: Boolean, userInfo: Doctor):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.55*/("""

"""),_display_(/*4.2*/main(page, isLoggedIn, userInfo)/*4.34*/ {_display_(Seq[Any](format.raw/*4.36*/("""

 """),format.raw/*6.2*/("""<div class="container">
     <div class="row">
       <div class="col-sm-10 col-sm-offset-1">
       <h2>Bienvenido a Migrandes</h2>
       <p> Buen sitio para poner una imagen</p>
       </div>
     </div>
   </div>   

""")))}))}
  }

  def render(page:String,isLoggedIn:Boolean,userInfo:Doctor): play.twirl.api.HtmlFormat.Appendable = apply(page,isLoggedIn,userInfo)

  def f:((String,Boolean,Doctor) => play.twirl.api.HtmlFormat.Appendable) = (page,isLoggedIn,userInfo) => apply(page,isLoggedIn,userInfo)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Apr 22 20:37:44 COT 2015
                  SOURCE: C:/Users/template/workspace/playMigrandes/app/views/index.scala.html
                  HASH: c885a0b9b70b05a856f7b865e1703f6269873c87
                  MATRIX: 759->24|900->77|928->80|968->112|1007->114|1036->117
                  LINES: 26->2|29->2|31->4|31->4|31->4|33->6
                  -- GENERATED --
              */
          