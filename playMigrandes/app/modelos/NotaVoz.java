/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Actividad.java
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingenieria de Sistemas y Computacion
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package modelos;

import java.util.Date;

import javax.persistence.*;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * Clase que modela una grabacion por parte del paciente 
 * @author David Mayroga
 */
@Entity
//@NoSql(dataFormat=DataFormatType.MAPPED)
public class NotaVoz
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------



    /**
     * Nombre del archivo
     */
    @Column(name="nombre")
    private String nombre;

   
    /**
     * Descripción de laa actividad.
     */
    @Column(name="descripcion")
    private String descripcion;

    /**
     * Ruta de la nota de voz
     */
    @Id
    private String archivo;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase sin argumentos
     */
    public NotaVoz()
    {
        
    }

    /**
     * Constructor de la clase con argumentos
     * @param id Identificador único de la nota de voz
     * @param nombre Nombre del archivo
     * @param descripcion Descripción de la nota de voz
     * @param archivo archivo donde quedo grabada la nota
     */
    public NotaVoz( String nombre, String cargo, String descripcion, String archivo)
    {
        this.setNombre(nombre);
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------


    /**
     * Devuelve la ruta de la nota de voz
     * @return ruta la ruta de la nota de voz
     */
    public String getArchivo()
    {
        return archivo;
    }

    /**
     * Modifica la ruta de la nota de voz
     * @param archivo Ruta de la nota de voz
     */
    public void setArchivo(String archivo)
    {
        this.archivo = archivo;
    }

   
   
    /**
     * Devuelve la descripción de la nota de voz
     * @return descripcion de la nota de voz
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * Modifica la descripción de la grabacion
     * @param descripcion Nueva descripción de la grabacion
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

   

 

}
