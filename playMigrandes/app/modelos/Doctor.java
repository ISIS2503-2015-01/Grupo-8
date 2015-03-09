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

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

//import play.db.ebean.Model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@NoSql(dataFormat=DataFormatType.MAPPED)
@Entity
public class Doctor //extends Model
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	
	 /**
     * Usuario del doctor.
     */

	@Id
    private String usuario;
   
	/**
     * Número de identificación del doctor
     */
	@Column(name="fecha")
    private long id;

    /**
     * Nombres del doctor.
     */
	@NotNull
	@Column(name="nombres")
    private String nombres;

    /**
     * Lista de ítems de pacientes del doctor.
     */
	@OneToMany(fetch = FetchType.LAZY) //carga cada atributo a medida que se lo pida. No todo de una (Eager)
    @ElementCollection
    private List<Paciente> pacientes;
   
    
    /**
     * Telefono del doctor
     */
	@Column(name="telefono")
    private String telefono;

    
    /**
     * Foto del doctor.
     */
	@Column(name="foto")
    private String foto;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos
     */
    public Doctor()
    {
        pacientes = new ArrayList<Paciente>();
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
    public Doctor(long id, String nombres, String usuario, String foto)
    {
        this.id = id;
        this.nombres = nombres;
        this.usuario = usuario;
        this.pacientes = new ArrayList();
        this.telefono = telefono;
        this.foto = foto;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el número único de identificación del doctor
     * @return id Número de identificación
     */
    public long getIdentificacion()
    {
        return id;
    }

    /**
     * Modifica el número de identificación del cliente
     * @param id Nuevo número de identificación
     */
    public void setIdentificacion(long id)
    {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
 
    
    
}