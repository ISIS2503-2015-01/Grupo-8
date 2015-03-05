package modelos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Principal implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull //A pesar de q el Play ya crea el id, es necesario el _id para Mongo
    @Id
    @GeneratedValue
    @Field(name="_id")
    private String id;
	
	@ElementCollection
	ArrayList<Paciente>pacientes;
	
	@ElementCollection
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
