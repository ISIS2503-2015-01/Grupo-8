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

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

import play.db.ebean.Model;

@Entity
//@MongoEntity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Actividad extends Model
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    
 

    /**
     * Nombre de la empresa que ceritifica la actividad laboral.
     */
	@Id 
	@GeneratedValue
	@Field(name="_id")
    private String nombre;

   
    /**
     * Descripción de laa actividad.
     */
	@Basic
    private String descripcion;

    /**
     * Fecha del evento
     */
	@Basic
    private Date fecha;

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
     * @param id Identificador único de la actividad
     * @param nombre Nombre de la empresa
     * @param descripcion Descripción de las funcionaes del cargo
     * @param fecha fecha en que reporto el evento
     */
    public Actividad( String nombre, String cargo, String descripcion, Date fecha)
    {
        this.setNombre(nombre);
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

  

    /**
     * Devuelve el año de terminación del vínculo laboral
     * @return ano Año de terminación del vínculo laboral
     */
    public Date getFehca()
    {
        return fecha;
    }

    /**
     * Modifica el año de terminación del vínculo laboral
     * @param ano Nuevo año de terminación de vínculo
     */
    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

   
   
    /**
     * Devuelve la descripción del evento del paciente
     * @return descripcion de la actividad realizada paciente
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * Modifica la descripción del del evento del paciente
     * @param descripcion Nueva descripción de la actividad realizada paciente
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
