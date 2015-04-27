/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ RegistroVenta.java
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingenieria de Sistemas y Computacion
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

//import play.db.ebean.Model;




import javax.validation.constraints.NotNull;

/**
 * Clase que modela un evento de migrania del paciente
 * @author David Mayorga
 */
//@Entity
//@NoSql(dataFormat=DataFormatType.MAPPED)
@Entity
public class Episodio //extends Model
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
  
	
	//@NotNull
	//@Id
	//@GeneratedValue
	//@Field(name="_id")
	
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	/**
     * Fecha en la que sucedio la migrana
     */
	//@Column(name="fecha")
	@Id
    private String fecha; //si va comparar, le toca convertirlo a fecha. En la BD es string

    /**
     * Medicamentos que estaba tomando
     */
    @OneToMany(fetch=FetchType.LAZY)
    @ElementCollection
    private List<Medicamento> medicamentos;

    /**
     * Dolor descrito por el paciente
     */
    
    @Column(name="dolor")
    private String dolor;
    
    /**
    * Nota de voz grabada por el paciente
    */
    //private NotaVoz grabacion;
    @Column(name="grabacion")
    private String grabacion;
      
    
    @Column(name="descripcion")
    private String descripcion;

    /**
     * Intensidad del dolor.
     */
	@Column(name="intensidad")
    private int intensidad;


    /**
     * Ubicacion de la migraña
     */
	@Column(name="ubicacion")
    private String ubicacion;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor sin argumentos
     */
    public Episodio()
    {
        //this.medicamentos = new ArrayList<Medicamento>() {};
    }

    /**
     * Constructor de un episodio de migraña. Inicializa la lista de medicamentos vacia
     * y el catalizador en nulo.
     * @param fecha en que ocurrio el episodio
     * @param dolor descripción del dolor
     */
    public Episodio(String fecha)//, List<Medicamento> medicamentos, Dolor dolor) {
    {
        
        this.medicamentos = new ArrayList<Medicamento>();
        this.fecha = fecha;
        //this.dolor = dolor;
        //this.catalizador = new ArrayList<Actividad>();
        //grabacion = null;
    }
    
    public Episodio(String fecha, List<Medicamento> medics, String nDescripcion, int nIntensidad, String nUbicacion) 
    {
        
        this.medicamentos = new ArrayList<Medicamento>();
        this.fecha = fecha;
        this.dolor = descripcion;
        medicamentos.addAll(medics);
        
        descripcion = nDescripcion;
        intensidad = nIntensidad;
        ubicacion = nUbicacion;
        
        //this.dolor = dolor;
        //this.catalizador = new ArrayList<Actividad>();
        //grabacion = null;
    }

    
    public Episodio(String fecha, String notaVoz) 
    {
        this.fecha = fecha;
        this.medicamentos = new ArrayList<Medicamento>();
        this.grabacion = notaVoz;
        //this.dolor = dolor;
        //this.catalizador = new ArrayList<Actividad>();
        //grabacion = null;
    }
    


    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /*
    public int getId()
    {
    	return id;
    }
    */
    
    public String getFecha() {
        return fecha;
    }
    
    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    
    public String getDescripcion(){
    	return descripcion;
    }
    
    public int getIntensidad(){
    	return intensidad;
    }
    
    public String getUbicacion(){
    	return ubicacion;
    }
    
    public void agregarMedicamento(Medicamento m)
    {
    	medicamentos.add(m);
    }
}
