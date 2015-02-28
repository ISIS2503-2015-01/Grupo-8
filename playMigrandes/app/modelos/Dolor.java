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

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase que representa la información sobre el dolor de una migraña
 * @author Juan Sebastián Urrego
 */
public class Dolor
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * Descripción del dolor.
     */
    private String descripcion;

    /**
     * Intensidad del dolor.
     */
    private int intensidad;


    /**
     * Ubicacion de la migraña
     */
    private String ubicacion;

    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public Dolor() 
    {

    }

    /**
     * @param descripcion del dolor. Agudo, Presion, 
     * @param intensidad del dolor. Es una escala enter 1 y 10
     * @param ubicacion Ubicacion del dolor. Frontal, ojos, cuello, toda la cabeza
     */
    public Dolor(String descripcion, int intensidad, String ubicacion) {
        this.descripcion = descripcion;
        this.intensidad = intensidad;
        this.ubicacion = ubicacion;
    }

    

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve la descripción del dolor
     * @return descripcion Descripción del dolor
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * Modifica la descripción del dolor
     * @param descripcion Nueva descripción del dolor
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    
    /**
     * Devuelve la intensidad del dolor
     * @return intensidad Intensidad del dolor
     */
    public int getIntensidad() {
        return intensidad;
    }

     /**
     * Modifica la intensidad del dolor
     * @param intensidad Nueva descripción del dolor
     */
    public void setIntensidad(int intensidad) {
        this.intensidad = intensidad;
    }

    
    /**
     * Devuelve la ubicacion del dolor
     * @return ubicacion Ubicacion del dolor
     */
    public String getUbicacion() {
        return ubicacion;
    }

     /**
     * Modifica la ubicacion del dolor
     * @param ubicacion Nueva ubicacion del dolor
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------


}
