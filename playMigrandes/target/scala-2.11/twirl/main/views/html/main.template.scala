
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Boolean,Doctor,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(page: String, isLoggedIn: Boolean, userInfo: Doctor )(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*3.71*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*8.17*/page),format.raw/*8.21*/(""" """),format.raw/*8.22*/("""(play-example-login)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        
        <!--  Load site-specific customizations after bootstrap. -->
        <link rel="stylesheet" media="screen" href=""""),_display_(/*13.54*/routes/*13.60*/.Assets.at("stylesheets/main.css")),format.raw/*13.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*14.59*/routes/*14.65*/.Assets.at("images/favicon.png")),format.raw/*14.97*/("""">
        
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
          <script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.2.0/respond.js"></script>
        <![endif]-->
    </head>
    <body>
    
     <!-- Responsive navbar -->
  <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <!--  Display three horizontal lines when navbar collapsed. -->
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">MIGRANDES</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-left">
          """),_display_(/*36.12*/if(isLoggedIn)/*36.26*/ {_display_(Seq[Any](format.raw/*36.28*/("""
            """),format.raw/*37.13*/("""<li class=""""),_display_(/*37.25*/("active".when(page == "Profile"))),format.raw/*37.59*/(""""><a href=""""),_display_(/*37.71*/routes/*37.77*/.Application.profile()),format.raw/*37.99*/("""">Perfil</a></li>
          """)))}),format.raw/*38.12*/("""
        """),format.raw/*39.9*/("""</ul>
        <ul class="nav navbar-nav navbar-right">
          """),_display_(/*41.12*/if(isLoggedIn)/*41.26*/ {_display_(Seq[Any](format.raw/*41.28*/("""
            """),format.raw/*42.13*/("""<li><p class="navbar-text">"""),_display_(/*42.41*/userInfo/*42.49*/.getEmail()),format.raw/*42.60*/("""</p></li>
            <li><a href=""""),_display_(/*43.27*/routes/*43.33*/.Application.logout()),format.raw/*43.54*/("""">Logout</a></li>
          """)))}/*44.13*/else/*44.18*/{_display_(Seq[Any](format.raw/*44.19*/("""
            """),format.raw/*45.13*/("""<li><a href=""""),_display_(/*45.27*/routes/*45.33*/.Application.login()),format.raw/*45.53*/("""">Login</a></li>
          """)))}),format.raw/*46.12*/("""

        """),format.raw/*48.9*/("""</ul>
      </div>
    </div>
  </div>
      """),_display_(/*52.8*/content),format.raw/*52.15*/("""
      """),format.raw/*53.7*/("""<!-- Load Bootstrap JavaScript components. HTMLUnit (used in testing) requires JQuery 1.8.3 or below). -->
      <script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
      <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
"""))}
  }

  def render(page:String,isLoggedIn:Boolean,userInfo:Doctor,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(page,isLoggedIn,userInfo)(content)

  def f:((String,Boolean,Doctor) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (page,isLoggedIn,userInfo) => (content) => apply(page,isLoggedIn,userInfo)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Apr 22 20:34:05 COT 2015
                  SOURCE: C:/Users/template/workspace/playMigrandes/app/views/main.scala.html
                  HASH: 30d3702c8a2c70866934bfcf0690fe25cbfbadc5
                  MATRIX: 763->25|920->94|947->95|1024->146|1048->150|1076->151|1450->498|1465->504|1520->538|1608->599|1623->605|1676->637|2723->1657|2746->1671|2786->1673|2827->1686|2866->1698|2921->1732|2960->1744|2975->1750|3018->1772|3078->1801|3114->1810|3207->1876|3230->1890|3270->1892|3311->1905|3366->1933|3383->1941|3415->1952|3478->1988|3493->1994|3535->2015|3583->2045|3596->2050|3635->2051|3676->2064|3717->2078|3732->2084|3773->2104|3832->2132|3869->2142|3941->2188|3969->2195|4003->2202
                  LINES: 26->3|29->3|30->4|34->8|34->8|34->8|39->13|39->13|39->13|40->14|40->14|40->14|62->36|62->36|62->36|63->37|63->37|63->37|63->37|63->37|63->37|64->38|65->39|67->41|67->41|67->41|68->42|68->42|68->42|68->42|69->43|69->43|69->43|70->44|70->44|70->44|71->45|71->45|71->45|71->45|72->46|74->48|78->52|78->52|79->53
                  -- GENERATED --
              */
          