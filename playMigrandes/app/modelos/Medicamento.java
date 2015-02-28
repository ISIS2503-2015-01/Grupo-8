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

import javax.persistence.Id;

/**
 * Clase que representa la información sobre el dolor de una migraña
 * @author Juan Sebastián Urrego
 */
public class Medicamento
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------


    /**
     * Nombre comercial del medicamento.
     */
	@Id
    private String nombre;
    
    /**
     * Componente quimico del medicamento.
     */
    private String componente;
    
    /**
     * Descripcion del medicamento por si algún no doctor lo lee.
     */
    private String descripcion;

    /**
     * Tipo del medicamento sobre como se ingiere.
     */
    private String presentacion;


    /**
     * Cantidad de medicamento tomado (en mg)
     */
    private String posologia;

    

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
     * @param componente componente quimico
     * @param descripcion Uso del medicamento en el mayor caso de su uso
     * @param presentacion tipo de medicamento usado
     * @param posologia cantidad en mgs del medicamento ingerido
     */
    public Medicamento(String nombre, String componente, String descripcion, String presentacion, String posologia) {
        this.nombre = nombre;
        this.componente = componente;
        this.descripcion = descripcion;
        this.presentacion = presentacion;
        this.posologia = posologia;
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

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    
    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------



}
