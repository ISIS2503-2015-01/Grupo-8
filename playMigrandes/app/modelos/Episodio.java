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
@Entity
public class Episodio
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
  

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    /**
     * Medicamentos que estaba tomando
     */
    @OneToMany(fetch=FetchType.LAZY)
    @ElementCollection
    private List<Medicamento> medicamentos;

    /**
     *Escala de dolor del 1 al 10
     */
    @Column(name="intensidad",nullable = false)
    private int intensidad;
    
    /**
    * Nota de voz grabada por el paciente
    */
    @Column(name="grabacion")
    private String grabacion;
        
    
    //@OneToOne
    //private Actividad catalizador;
    
    @ManyToOne
    private Paciente paciente;
    
    @Column(name="fecha",nullable = false)
    private String fecha;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="ubicacion")
    private String ubicacion;
    
   

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    public Episodio()
    {
    	
    }
    
    /**
     * Constructor de un episodio de migraña para el caso promedio
     * @param fecha en que ocurrio el episodio
     * @param intesidad escala del dolor, numero entre 1 y 10
     * @param paciente, paciente quien crea el episodio
     * @param notadevoz string con la ruta del registro de voz     
     * */
    public Episodio(String nfecha, int dolor, Paciente p, String notaVoz, String ubi, String descr  )
    {
    	this.medicamentos = new ArrayList<Medicamento>();
        fecha=nfecha;
        paciente=p;
        intensidad=dolor;
        grabacion=notaVoz;
        ubicacion=ubi;
        descripcion=descr;
    }

    /**
     * Constructor de un episodio de migraña para el caso de la nota de voz con dolor maximo
     * @param fecha en que ocurrio el episodio
     * @param paciente, paciente quien crea el episodio
     * @param notadevoz string con la ruta del registro de voz     
     * */
    public Episodio(String f,Paciente p, String notaVoz)
    {
        this.medicamentos = new ArrayList<Medicamento>();
        fecha=f;
        paciente=p;
        intensidad=10;
        grabacion=notaVoz;
    }
    
   

    


    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    
    public int getId()
    {
    	return id;
    }
    
    
    public String getFecha() {
        return fecha;
    }
    
    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    
   
    
   
    public void agregarMedicamento(Medicamento m)
    {
    	medicamentos.add(m);
    }
    
   
}
