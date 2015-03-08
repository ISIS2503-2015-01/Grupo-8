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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import play.db.ebean.Model;




import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * Clase que modela un paciente dentro del sistema.
 * @author Juan Sebastián Urrego
 */


@Entity
@Table(name="PACIENTE")
public class Paciente //extends Model
{

	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	/**
     * Usuario del paciente.
     */
	@Column(name="usuario")
    private String usuario;
	
    /**
     * Número de identificación del paciente
     */
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

    /**
     * Nombres del paciente.
     */
    @Column(name="nombres")
    private String nombres;

 

    /**
     * Lista de ítems de actividades del paciente.
     */
	//@ElementCollection
	//@OneToMany(fetch=FetchType.LAZY)
    //private List<Actividad> actividades;
    
    
    /**
     * Lista de ítems de episodios del paciente.
     */
    @OneToMany(fetch=FetchType.LAZY)
    @ElementCollection
    private List<Episodio> episodios;
      
    /**
     * Telefono del paciente
     */
    @Column(name="telefono")
    private String telefono;

    /**
     * Perfil de paciente.
     */
    @Column(name="perfil")
    private String perfil;

    /**
     * Foto del paciente.
     */
    @Column(name="foto")
    private String foto;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos
     */
    public Paciente()
    {
        //actividades = new ArrayList<Actividad>();
    }

    /**
     * Constructor con argumentos de la clase. 
     * @param id Identificador único del paciente
     * @param nombres Nombre(s) del paciente
     * @param usuario Username del paciente
     * @param salario Salario del paciente
     * @param comisionVentas Valor en comisión por ventas
     * @param perfil Perfil del paciente
     * @param foto Nombre de la foto del paciente
     * @param telefono telefono del paciente
     */
    public Paciente( int i,String nnombres, String usr, String nperfil, String nfoto, String ntelefono)
    {
        this.id = i;
        this.nombres = nnombres;
        this.usuario = usr;
        //this.actividades = new ArrayList<Actividad>();
        this.episodios = new ArrayList<Episodio>();
        this.telefono = ntelefono;
        this.perfil = nperfil;
        this.foto = nfoto;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    
    public List<Episodio> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(ArrayList<Episodio> episodios2) {
		//this.episodios = episodios2;
	}
	
    /**
     * Devuelve el número único de identificación del paciente
     * @return id Número de identificación
     */
    //public long getIdentificacion()
    //{
      //  retur;
    //}

    /**
     * Modifica el número de identificación del cliente
     * @param id Nuevo número de identificación
     */
    public void setIdentificacion(int nid)
    {
        this.id = nid;
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
        //this.actividades.add(actividad);
    }

    public List<Actividad> getActividades() {
        return null;
    }

    public void setActividades(List<Actividad> actividades) {
        //this.actividades = actividades;
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

	public void addEpisodio(Episodio e) {
		// TODO Auto-generated method stub
		episodios.add(e);
		
	}
 

    
}