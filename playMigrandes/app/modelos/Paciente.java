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

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;


import javax.validation.constraints.NotNull;


/**
 * Clase que modela un paciente dentro del sistema.
 * @author Juan Sebastián Castro
 */

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Paciente implements Serializable
{

    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	/**
     * Usuario del paciente.
     */
	@NotNull //A pesar de q el Play ya crea el id, es necesario el _id para Mongo
  
    private String usuario;
	
    /**
     * Número de identificación del paciente
     */
	
	  @Id
	    @GeneratedValue
	    @Field(name="_id")
	private long id;

    /**
     * Nombres del paciente.
     */
	@NotNull
	@Basic
    private String nombres;

 

    /**
     * Lista de ítems de actividades del paciente.
     */
	@ElementCollection
	@OneToMany(fetch=FetchType.LAZY)
    private List<Actividad> actividades;
    
    
    /**
     * Lista de ítems de episodios del paciente.
     */
    @OneToMany(fetch=FetchType.LAZY)
    @ElementCollection
    private List<Episodio> episodios;
      
    /**
     * Telefono del paciente
     */
    @Basic
    private String telefono;

    /**
     * Perfil de paciente.
     */
    @Basic
    private String perfil;

    /**
     * Foto del paciente.
     */
    @Basic
    private String foto;

    @ManyToOne(fetch = FetchType.LAZY )
    private Doctor medico;
    

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    

	/**
     * Constructor sin argumentos
     */
    public Paciente()
    {
        actividades = new ArrayList<Actividad>();
    }

    /**
     * Constructor con argumentos de la clase. 
     * @param nombres Nombre(s) del paciente
     * @param usuario Username del paciente
     * @param perfil Perfil del paciente
     * @param foto Nombre de la foto del paciente
     * @param telefono telefono del paciente
     */
    public Paciente(String nombres, String usuario, String perfil, String foto, String telefono)
    {
        this.nombres = nombres;
        this.usuario = usuario;
        this.actividades = new ArrayList<Actividad>();
        this.episodios = new ArrayList<Episodio>();
        this.telefono = telefono;
        this.perfil = perfil;
        this.foto = foto;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    
    public List<Episodio> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(ArrayList<Episodio> episodios2) {
		this.episodios = episodios2;
	}
	
    /**
     * Devuelve el número único de identificación del paciente
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

   
    public void setItemActividad(Actividad actividad)
    {
        this.actividades.add(actividad);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
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
    public Doctor getMedico() {
		return medico;
	}

	public void setMedico(Doctor medico) {
		this.medico = medico;
	}
 
    
    
}