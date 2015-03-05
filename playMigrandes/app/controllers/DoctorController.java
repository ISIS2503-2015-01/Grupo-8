package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.nosql.annotations.NoSql;

import com.fasterxml.jackson.databind.JsonNode;

import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.*;
import modelos.Doctor;
import modelos.Episodio;
import modelos.Paciente;
import modelos.Principal;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;
 

@NoSql(dataFormat=DataFormatType.MAPPED)
@Entity
@XmlRootElement
public class DoctorController extends Controller
{
	//private static ArrayList<Doctor> doctores= new ArrayList<Doctor>();
	//private static ArrayList<Paciente> pacientes=new ArrayList<Paciente>();


    @BodyParser.Of(BodyParser.Json.class)
	public static Result create()
	{


		JsonNode nodo = Controller.request().body().asJson();
		
		Long id = Long.parseLong(nodo.findPath("id").asText());
		String nombres=nodo.findPath("nombres").asText();
		String usuario=nodo.findPath("login").asText();
		String perfil=nodo.findPath("perfil").asText();
		String foto=nodo.findPath("foto").asText();
		
		Doctor n=JPA.em().find(Doctor.class, id);
		if(n!=null)
			return Results.ok("Su tal Doctor ya existe");
		
		n=new Doctor(id, nombres, usuario, perfil, foto);
		JPA.em().persist(n);
		return Results.created();
		
		/*
		//se llena la lista de pacientes
		ArrayList<Paciente> pacientes= new ArrayList();
		
		while(pacientes.size()<11)
		{
			Random random = new Random();
			long idP = Math.abs(random.nextLong()*1000000000);
			Paciente nvo=new Paciente(idP, "Juan", "asf", "asfd", "asf", "asf");
			pacientes.add(nvo);
		}
		
		
		//pacientes.add(new Paciente(1, "Juan", "asf", "asfd", "asf", "asf"));
		//Doctor n = new Doctor( 2, "asd", "asf",  pacientes,  "sdfa", "asfasd");
		
		//Doctor n=new Doctor(id,nombres, usuario, pacientes, perfil,  foto);
		
		Doctor n=new Doctor(id,null, null, null, null,  null);
		*/
		//doctores.add(n);
	}

	public static  Result delete(long id)
	{
		Doctor n=JPA.em().find(Doctor.class, id);
		if(n==null)
			return Results.notFound("Su tal Doctor no existe");
		
		JPA.em().remove(n);
		return Results.ok();
		
		/*
		boolean eliminado=false;
		for(int i=0; i<doctores.size() && eliminado==false;i++)
		{
			Doctor act=doctores.get(i);
			if(act.getIdentificacion() == id)
			{
				doctores.remove(i);
				eliminado=true;
			}

		}
		return Results.ok();
		*/
	}	

	public static Result update(long id)
	{
		JsonNode nodo = Controller.request().body().asJson();


		Long idn = Long.parseLong(nodo.findPath("id").asText());
		String nombres = nodo.findPath("nombres").asText();
		String telefono=nodo.findPath("telefono").asText();
		String usuario= nodo.findPath("usuario").asText();
		String perfil = nodo.findPath("perfil").asText();
		String foto= nodo.findPath("foto").asText();
		
		Doctor n=JPA.em().find(Doctor.class, id);
		if(n==null)
			return Results.notFound();
		
		Doctor d=JPA.em().getReference(Doctor.class,n);
		d=JPA.em().getReference(Doctor.class,n);
		d.setFoto(foto);
		d.setIdentificacion(id);
		d.setNombres(nombres);
		d.setUsuario(usuario);
		return Results.ok();
		
		
		/*
		Doctor temp=null;
		boolean eliminado=false;

		for(int i=0; i<doctores.size() && eliminado==false;i++)
		{
			Doctor act=doctores.get(i);
			if(act.getIdentificacion() == id)
			{
				JsonNode nodo = Controller.request().body().asJson();


				Long idn = Long.parseLong(nodo.findPath("id").asText());
				String nombres = nodo.findPath("nombres").asText();
				String telefono=nodo.findPath("telefono").asText();
				String usuario= nodo.findPath("usuario").asText();
				String perfil = nodo.findPath("perfil").asText();
				String foto= nodo.findPath("foto").asText();

				act.setFoto(foto);
				act.setIdentificacion(id);
				act.setNombres(nombres);
				act.setTelefono(telefono);

				doctores.remove(i);
				doctores.add(i,act);
			}

		}

		return Results.created();
		*/

	}

	/*
	public static Result verEpisodiosPaciente(Long id,Long idp) throws  Exception 
	{
		
		
		ArrayList episodios=null;
		

		
		if( id==null | idp==null)
		{
			throw new Exception("parametros nulos");
			
		}
		else
		{
			//create();
			

			boolean encontradoD=false;
			for(int i=0; i<doctores.size() && encontradoD==false;i++)
			{
				Doctor act=doctores.get(i);
				if(act!=null && act.getIdentificacion() == id)
				{
					encontradoD=true;
					List<Paciente> paci= act.getPacientes();

					boolean encontrado2=false;
					for(int j=0;j<paci.size() && encontrado2==false;i++)
					{
						Paciente actp=paci.get(j);
						if(act!=null && actp.getIdentificacion() == idp)
						{
							episodios=(ArrayList<Episodio>) actp.getEpisodios();
						}
					}
				}

			}
			
			
		}
		
		return Results.ok(Json.toJson(episodios));
	}

	public static ArrayList verEpisodiosPacienteA(Long id,Long idp)
	{
		ArrayList<Episodio> episodios=new ArrayList();

		boolean encontradoD=false;
		for(int i=0; i<doctores.size() && encontradoD==false;i++)
		{
			Doctor act=doctores.get(i);
			if(act.getIdentificacion() == id)
			{
				encontradoD=true;
				List<Paciente> paci= act.getPacientes();

				boolean encontrado2=false;
				for(int j=0;j<paci.size() && encontrado2==false;i++)
				{
					Paciente actp=paci.get(j);
					if(actp.getIdentificacion() == idp)
					{
						episodios=(ArrayList<Episodio>) actp.getEpisodios();
					}
				}
			}

		}
		return episodios;
	}

	public static ArrayList revisarEpisodiosEntre(Date fechaIn, Date fechaFin, Long docid,Long pacid)
	{
		ArrayList resp=new ArrayList();

		ArrayList<Episodio> ant=verEpisodiosPacienteA(docid,pacid);
		for(int i=0; i<ant.size();i++)
		{
			Episodio actl=ant.get(i);
			if(actl.getFecha().compareTo(fechaIn)>0 && actl.getFecha().compareTo(fechaFin)<0)
				resp.add(actl);
		}
		return resp;
	}
	*/
}


