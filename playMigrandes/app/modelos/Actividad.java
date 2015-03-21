/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Actividad.java
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingenieria de Sistemas y Computacion
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles los Alpes
 * Autor: Juan SebastiÃ¡n Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package modelos;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.*;

@Entity
public class Actividad //extends Model
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Nombre de la empresa que ceritifica la actividad laboral.
     */
	@Id 
    private String nombre;

   
    /**
     * Descripcion de laa actividad.
     */
	@Column(name="descripcion")
    private String descripcion;

    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase sin argumentos
     */
    public Actividad()
    {
    }

    /**
     * Constructor de la clase con argumentos
     * @param id Identificador Ãºnico de la actividad
     * @param nombre Nombre de la empresa
     * @param descripcion DescripciÃ³n de las funcionaes del cargo
     * @param fecha fecha en que reporto el evento
     */
    public Actividad( String nombre, String cargo, String descripcion, String fecha)
    {
        this.setNombre(nombre);
        this.descripcion = descripcion;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

  
   
   
    /**
     * Devuelve la descripciÃ³n del evento del paciente
     * @return descripcion de la actividad realizada paciente
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * Modifica la descripciÃ³n del del evento del paciente
     * @param descripcion Nueva descripciÃ³n de la actividad realizada paciente
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
