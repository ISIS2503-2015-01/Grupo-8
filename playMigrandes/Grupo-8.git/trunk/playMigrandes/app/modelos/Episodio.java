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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que modela un evento de migrania del paciente
 * @author David Mayorga
 */
public class Episodio
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Fecha en la que sucedio la migrana
     */
    private Date fecha;

    /**
     * Ciudad en la que se vendió el producto
     */
    private List<Medicamento> medicamentos;

    /**
     * Dolor descrito por el paciente
     */
    private Dolor dolor;
    
    /**
    * Nota de voz grabada por el paciente
    */
    private NotaVoz grabacion;
    
    
    
    /**
     * Posible catalizador que pudo haber ocasionado la migraña
     * Puede disminuir el episodio haciendo lo contrario a la actividad en referencia.
     */
    private Actividad catalizador;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor sin argumentos
     */
    public Episodio()
    {
        this.medicamentos = new ArrayList<Medicamento>() {};
    }

    /**
     * Constructor de un episodio de migraña. Inicializa la lista de medicamentos vacia
     * y el catalizador en nulo.
     * @param fecha en que ocurrio el episodio
     * @param dolor descripción del dolor
     */
    public Episodio(Date fecha, List<Medicamento> medicamentos, Dolor dolor) {
        
        this.medicamentos = new ArrayList<Medicamento>();
        
        this.fecha = fecha;
        this.dolor = dolor;
        this.catalizador = null;
        grabacion = null;
    }

    


    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
     public void setItemMedicamentos(Medicamento medicamento)
    {
        this.medicamentos.add(medicamento);
    }

    public Dolor getDolor() {
        return dolor;
    }

    public void setDolor(Dolor dolor) {
        this.dolor = dolor;
    }

    public Actividad getCatalizador() {
        return catalizador;
    }

    public void setCatalizador(Actividad catalizador) {
        this.catalizador = catalizador;
    }

    public NotaVoz getGrabacion() {
        return grabacion;
    }

    public void setGrabacion(NotaVoz grabacion) {
        this.grabacion = grabacion;
    }

  

}
