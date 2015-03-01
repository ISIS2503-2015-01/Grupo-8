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

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase que modela una grabacion por parte del paciente 
 * @author David Mayroga
 */
public class NotaVoz
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
    /**
     * Identificador del item de actividad.
     */
    private long ida;

    /**
     * Nombre de la empresa que ceritifica la actividad laboral.
     */
    private String nombre;

   
    /**
     * Descripción de laa actividad.
     */
    private String descripcion;

    /**
     * Ruta de la nota de voz
     */
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
    public NotaVoz(long id, String nombre, String cargo, String descripcion, String archivo)
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el identificador único del paciente
     * @return id Identificador del paciente
     */
    public long getId()
    {
        return id;
    }

    /**
     * Modifica el identificador único del jugador
     * @param id Nuevo identificador del paciente
     */
    public void setId(long id)
    {
        this.id = id;
    }

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

   

 

}
