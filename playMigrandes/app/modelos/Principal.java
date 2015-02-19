package modelos;

import java.util.ArrayList;

public class Principal 
{
	ArrayList<Paciente>pacientes;
	ArrayList<Doctor> doctores;
	
	public Principal() {
		
		this.pacientes = new ArrayList();
		this.doctores = new ArrayList();
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public ArrayList<Doctor> getDoctores() {
		return doctores;
	}

	public void setDoctores(ArrayList<Doctor> doctores) {
		this.doctores = doctores;
	}
	public void agregarDoc(Doctor nvo)
	{
		doctores.add(nvo);
	}
	
	
	
}
