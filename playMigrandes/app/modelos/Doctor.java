package modelos;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Paciente.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//Diego lo puso en comments
import modelos.SecurityRole.Builder;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

//import play.db.ebean.Model;







import be.objectify.deadbolt.core.models.Permission;
import be.objectify.deadbolt.core.models.Role;
import be.objectify.deadbolt.core.models.Subject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="DOCTOR")
public class Doctor implements Subject
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	
	 /**
     * Usuario del doctor.
     */
	@Id
    private String email;
   
	/**
     * Número de identificación del doctor
     */
	@Column(name="cedula")
    private long cedula;

    /**
     * Nombres del doctor.
     */
	@NotNull
	@Column(name="nombres")
    private String nombres;

    /**
     * Lista de ítems de pacientes del doctor.
     */
	@OneToMany(fetch = FetchType.LAZY) 
    @ElementCollection
    private List<Paciente> pacientes;

	
	@ManyToMany
    public List<SecurityRole> roles;

	
	@Column(name="password")
	private String password;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
     * Constructor sin argumentos
     */
    public Doctor()
    {
        pacientes = new ArrayList<Paciente>();
        roles=new ArrayList<SecurityRole>();
    }

    /**
     * Constructor con argumentos de la clase
     * @param id Identificador único del doctor
     * @param nombres Nombre(s) del doctor
     * @param usuario Username del doctor
     * @param experiencia Lista con la experiencia laboral del doctor
     * @param salario Salario del doctor
     * @param comisionVentas Valor en comisión por ventas
     * @param perfil Perfil del doctor
     * @param foto Nombre de la foto del doctor
     */
    public Doctor(String pass, String nombres, String correo)
    {
        this.password = pass;
        this.nombres = nombres;
        this.email = correo;
        this.pacientes = new ArrayList<Paciente>();
        roles=new ArrayList<SecurityRole>();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el número único de identificación del doctor
     * @return id Número de identificación
     */
    public long getCedula()
    {
        return cedula;
    }

    /**
     * Modifica el número de identificación del cliente
     * @param id Nuevo número de identificación
     */
    public void setCedula(long id)
    {
        this.cedula = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

   
    public void setItemPaciente(Paciente paciente)
    {
        this.pacientes.add(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public String getEmail()
    {
    	return email;
    }
    
    public void setEmail(String nemail)
    {
    	email=nemail;
    }

	@Override
	public String getIdentifier() {
		return email;
	}

	@Override
	public List<? extends Permission> getPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Role> getRoles() {
		return roles;
	}
	
	public void agregarRol(SecurityRole s)
	{
		roles.add(s);
	}
	
	
 
    
    
}