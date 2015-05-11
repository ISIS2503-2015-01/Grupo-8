package controllers;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import modelos.Doctor;
import modelos.Paciente;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

public class Secured  extends Security.Authenticator
{
	/**
	   * Used by authentication annotation to determine if user is logged in.
	   * @param ctx The context.
	   * @return The email address of the logged in user, or null if not logged in.
	   */
	  @Override
	  public String getUsername(Context ctx) {
	    return ctx.session().get("email");
	  }

	  /**
	   * Instruct authenticator to automatically redirect to login page if unauthorized.
	   * @param context The context.
	   * @return The login page.
	   */
	  @Override
	  public Result onUnauthorized(Context context) {
	    return redirect(routes.Application.login()); 
	  }
	  
	  /**
	   * Return the email of the logged in user, or null if no logged in user.
	   * 
	   * @param ctx the context containing the session
	   * @return The email of the logged in user, or null if user is not logged in.
	   */
	  public static String getUser(Context ctx) {
	    return ctx.session().get("email");
	  }
	  
	  /**
	   * True if there is a logged in user, false otherwise.
	   * @param ctx The context.
	   * @return True if user is logged in.
	   */
	  public static boolean isLoggedIn(Context ctx) {
	    return (getUser(ctx) != null);
	  }
	  
	  /**
	   * Return the UserInfo of the logged in user, or null if no user is logged in.
	   * @param ctx The context.
	   * @return The UserInfo, or null.
	   */
	  @Transactional
	  public static Doctor getUserInfo(Context ctx,Doctor doc) {
		  
		  if(isLoggedIn(ctx))
		  {
			  return doc;
		  }
		  return  null;
	  }
	  
	  
	  /**
	   * Retorna el código hash de los parametros recibidos para realizar un requerimiento
	   * @param secret
	   * @return
	   */
	  	private static 	String calculateHMAC(String secret) {
			try {
				SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(),	"HmacSHA1");
				Mac mac = Mac.getInstance("HmacSHA1");
				mac.init(signingKey);
				byte[] rawHmac = mac.doFinal();
				String result = new String(Base64.getEncoder().encode(rawHmac));
				System.out.println("Codigo Hash: "+ result);

				return result;
			} catch (GeneralSecurityException e) {
				System.out.println("Unexpected error while creating hash: " + e.getMessage());
				throw new IllegalArgumentException();
			}
		}
		
		/**
		 * Recibe los parametros en un arreglo de strings, los concatena, genera el codigo de hash y lo compara con el recibido
		 * @param parametros
		 * @param hmRecibido
		 * @return true si la integridad se mantuvo, false si no.
		 */
		public static boolean verificarIntegridad(String[] parametros, String hmRecibido)
		{
			//TODO DESDE EL LADO WEB
			
			/*String aCodificar = "param1"+":"+"param2"+":"+"param3";
			
			String codigoSent = calculateHMAC(aCodificar);
			
			String paramsSent = aCodificar+":"+codigoSent;*/
			
			//paramsSent se agrega como parametro con nombre "hmac"
			
			
			//DE WEB A CONTROLLERS
			
			
			//EN CADA REQUERIMEINTO DE CONTROLLERS DEBERIA ESTAR
			/*
			JsonNode nodo = Controller.request().body().asJson();
			//Ojo toca en orden
			String param1=nodo.findPath("param1").asText();
			String param2=nodo.findPath("param2").asText();
			String param3=nodo.findPath("param3").asText();

			//Verifica integridad
			String hmacRec = nodo.findPath("hmac").asText();
			String[] params = {param1,param2,param3};
			boolean integ = Secured.verificarIntegridad(params, hmacRec);  
			if(!integ)
			{
			return Results.notFound("La información ha sido alterada.");
			}
			*/
			
			
		
			String paramsJuntos = "";
			
			for(int i = 0; i<parametros.length; i++)
			{
				if(i!=parametros.length-1)
					paramsJuntos += parametros[i]+":";
				else
					paramsJuntos += parametros[i];
			}
				
			//genere el codigo local
			String hmLocal = calculateHMAC(paramsJuntos);
			
			//compare
			if(!hmLocal.equals(hmRecibido))
			{
				System.out.println("ERROR - el codigo recibido "+hmRecibido+" y el generado "+hmLocal+" no coinciden");
				return false;
			}
			else
			{
				System.out.println("El codigo recibido "+hmRecibido+" y el generado "+hmLocal+" SI coinciden. La integridad se mantuvo.");
				return true;
			}	
		}
	  
}
