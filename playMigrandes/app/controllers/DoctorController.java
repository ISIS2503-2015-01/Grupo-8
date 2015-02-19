package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.*;
import modelos.Doctor;
import modelos.Episodio;
import modelos.Paciente;
import modelos.Principal;

public class DoctorController
{
	private static ArrayList<Doctor> doctores;
	private static ArrayList<Paciente> pacientes;


	public static Result create()
	{


		JsonNode nodo = Controller.request().body().asJson();


		Long id = Long.parseLong(nodo.findPath("id").asText());
		String nombres = nodo.findPath("nombres").asText();
		String telefono=nodo.findPath("telefono").asText();
		String usuario= nodo.findPath("usuario").asText();
		String perfil = nodo.findPath("perfil").asText();
		String foto= nodo.findPath("foto").asText();

		//se llena la lista de pacientes
		ArrayList<Paciente> pacientes= new ArrayList();
		while(pacientes.size()<11)
		{
			Random random = new Random();
			long idP = Math.abs(random.nextLong()*1000000000);
			Paciente nvo=new Paciente(idP, "Juan", "asf", "asfd", "asf", "asf");
			pacientes.add(nvo);
		}
		
	
		Doctor n = new Doctor( id, nombres, usuario,  pacientes,  perfil, foto);
		doctores.add(n);


	
	    return Results.created();
	
	}
	
	public static  Result delete(long id)
	{
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
	}	
	
	public static Result update(long id)
	{
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
		
	}
	
	public static ArrayList buscarPacientePorId(Long id,Long idp)
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
		
		ArrayList<Episodio> ant=buscarPacientePorId(docid,pacid);
		for(int i=0; i<ant.size();i++)
		{
			Episodio actl=ant.get(i);
			if(actl.getFecha().compareTo(fechaIn)>0 && actl.getFecha().compareTo(fechaFin)<0)
				resp.add(actl);
		}
		return resp;
	}
}


