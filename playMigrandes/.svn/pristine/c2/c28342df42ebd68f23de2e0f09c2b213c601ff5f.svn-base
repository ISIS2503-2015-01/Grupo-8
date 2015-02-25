package modelos;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Paciente.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Número de identificación del doctor
     */
    private long id;

    /**
     * Nombres del doctor.
     */
    private String nombres;

    /**
     * Lista de ítems de pacientes del doctor.
     */
    private List<Paciente> pacientes;

    /**
     * Usuario del doctor.
     */
    private String usuario;
    
    /**
     * Telefono del doctor
     */
    private String telefono;

    /**
     * Perfil de doctor.
     */
    private String perfil;

    /**
     * Foto del doctor.
     */
    private String foto;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos
     */
    public Doctor()
    {
        pacientes = new ArrayList<Paciente>();
    }

    /**
     * Constructor con argumentos de la clase
     * @param id Identificador único del doctor
     * @param nombres Nombre(s) del doctor
     * @param usuario Username del doctor
     * @param experiencia Lista con la experiencia laboral del doctor
     * @param salario Salario del doctor
     * @param comisionVentas Valor en comisión por ventas
     * @param perfil Perfil del doctor
     * @param foto Nombre de la foto del doctor
     */
    public Doctor(long id, String nombres, String usuario, List<Paciente> pacientes, String perfil, String foto)
    {
        this.id = id;
        this.nombres = nombres;
        this.usuario = usuario;
        this.pacientes = pacientes;
        this.telefono = telefono;
        this.perfil = perfil;
        this.foto = foto;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el número único de identificación del doctor
     * @return id Número de identificación
     */
    public long getIdentificacion()
    {
        return id;
    }

    /**
     * Modifica el número de identificación del cliente
     * @param id Nuevo número de identificación
     */
    public void setIdentificacion(long id)
    {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

   
    public void setItemPaciente(Paciente paciente)
    {
        this.pacientes.add(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
 
    
    
}