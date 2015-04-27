/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Mueble.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package modelos;

import javax.persistence.*;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * Clase que representa la información sobre el dolor de una migraña
 * @author Juan Sebastián Urrego
 */
@Entity
//@Embeddable
//@NoSql(dataFormat=DataFormatType.MAPPED)
public class Medicamento
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

    /**
     * Nombre comercial del medicamento.
     */
	
	@Column(name="nombre")
    private String nombre;
    
    /**
     * Descripcion del medicamento por si algún no doctor lo lee.
     */
	@Column(name="descripcion")
    private String descripcion;

    

    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public Medicamento() 
    {

    }

   
    /**
     * Constructor con argumentos de la clase
     * @param nombre Nombre comercial
     * @param descripcion Uso del medicamento en el mayor caso de su uso
      */
    public Medicamento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
}
