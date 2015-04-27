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

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
import be.objectify.deadbolt.core.models.Permission;
import be.objectify.deadbolt.core.models.Role;
import be.objectify.deadbolt.core.models.Subject;


/**
 * Clase que modela un paciente dentro del sistema.
 * @author Juan Sebastián Urrego
 */


@Entity
@Table(name="PACIENTE")
public class Paciente  implements Subject
{

	//-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	
	@Column(name="mail")
	@NotNull
    private String email;
	
    /**
     * Número de identificación del paciente. Alias cedula
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
    
    /**
     * Lista de ítems de medicamentos del paciente.
     */
    @OneToMany(fetch=FetchType.LAZY)
    @ElementCollection
    private List<Medicamento> medicamentos;
    
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
        actividades = new ArrayList<Actividad>();
        episodios = new ArrayList<Episodio>();
        medicamentos = new ArrayList<Medicamento>();
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

        actividades = new ArrayList<Actividad>();
        episodios = new ArrayList<Episodio>();
        medicamentos = new ArrayList<Medicamento>();
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
    public int getIdentificacion()
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
        return actividades;
    }
    
    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    
    public void addMedicamentos(Medicamento m) {
        medicamentos.add(m);
    }
    
    public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

	public void addEpisodio(Episodio e) {
		episodios.add(e);
		
	}
	
	public String getEmail(){
		return email;
	}

	@Override
	public String getIdentifier() {
		return email;
	}

	@Override
	public List<? extends Permission> getPermissions() {
		//TODO 
		return null;
	}

	@Override
	public List<? extends Role> getRoles() {
		return roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 

    
}