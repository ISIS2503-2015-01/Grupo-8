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
import javax.persistence.Embeddable;
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
public class Paciente
{

	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	/**
     * Usuario del paciente.
     */
	@Id
    private String usuario;

    /**
     * Nombres del paciente.
     */
    @Column(name="nombres")
    @NotNull
    private String nombres;
    
    /**
     * Password del paciente
     */
    @Column(name="password")
    @NotNull
    private String password;
    
    /**
     * Lista de ítems de actividades del paciente.
     */
    //TODO falta el mapped By
	@ElementCollection
	@OneToMany(fetch=FetchType.LAZY,mappedBy="paciente")
    private List<Actividad> actividades;
    
    
    /**
     * Lista de ítems de episodios del paciente.
     */
    @OneToMany(fetch=FetchType.LAZY, mappedBy="paciente")
    @ElementCollection
    private List<Episodio> episodios;
    
    @OneToMany
    @ElementCollection
    private List<Medicamento> medicamentos;


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
    public Paciente(String nnombres, String usr,String pass)
    {
        this.nombres = nnombres;
        this.usuario = usr;
        this.password=pass;
        this.actividades = new ArrayList<Actividad>();
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

	public void addEpisodio(Episodio e) {
		// TODO Auto-generated method stub
		episodios.add(e);
		
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void addMedicamento(Medicamento m)
	{
		medicamentos.add(m);
	}
 

	
}