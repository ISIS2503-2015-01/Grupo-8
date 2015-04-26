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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * Clase que modela un paciente dentro del sistema.
 * @author Juan Sebastián Urrego
 */


@Entity
@Table(name="PACIENTE")
public class Paciente
{

	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	
	@Column(name="mail")
	@NotNull
    private String email;
	
    /**
     * Número de identificación del paciente
     */
	@Id
	private int id;

    /**
     * Nombres del paciente.
     */
    @Column(name="nombres")
    private String nombres;
    
    @Column(name="password")
    @NotNull
	private String password;


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
    
    @ManyToMany
    public List<SecurityRole> roles;
    
    
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
    public Paciente( int i,String nnombres, String usr,String pass)
    {
        this.id = i;
        this.nombres=nnombres;
        this.email=usr;
        this.password=pass;
        this.episodios = new ArrayList<Episodio>();
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
    public long getIdentificacion()
    {
        return id;
    }

    /**
     * Modifica el número de identificación del cliente
     * @param id Nuevo número de identificación
     */
    public void setIdentificacion(int nid)
    {
        this.id = nid;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

	public void addEpisodio(Episodio e) {
		// TODO Auto-generated method stub
		episodios.add(e);
		
	}
 

    
}