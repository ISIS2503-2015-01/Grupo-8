
 
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


	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.List;


	



	/**
	 * Clase que modela un paciente dentro del sistema.
	 * @author Juan Sebastián Castro
	 */

		public class PacienteDTO 
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//-----------------------------------------------------------
	    // Atributos
	    //-----------------------------------------------------------

		/**
	     * Usuario del paciente.
	     */
		    private String usuario;
		
	    /**
	     * Número de identificación del paciente
	     */
		
		private long id;

	    /**
	     * Nombres del paciente.
	     */
	    private String nombres;

	 

	    /**
	     * Lista de ítems de actividades del paciente.
	     */
		    private List<Actividad> actividades;
	    
	    
	    /**
	     * Lista de ítems de episodios del paciente.
	     */
	    private List<Episodio> episodios;
	      
	    /**
	     * Telefono del paciente
	     */
	    private String telefono;

	    /**
	     * Perfil de paciente.
	     */
	    private String perfil;

	    /**
	     * Foto del paciente.
	     */
	    private String foto;

	    private Doctor medico;
	    

	    //-----------------------------------------------------------
	    // Constructor
	    //-----------------------------------------------------------

	    

		/**
	     * Constructor sin argumentos
	     */
	    public PacienteDTO()
	    {
	        actividades = new ArrayList<Actividad>();
	    }


	    //-----------------------------------------------------------
	    // Getters y setters
	    //-----------------------------------------------------------

	    
	    public List<Episodio> getEpisodios() {
			return episodios;
		}

		public void setEpisodios(ArrayList<Episodio> episodios2) {
			this.episodios = episodios2;
		}
		
	    /**
	     * Devuelve el número único de identificación del paciente
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

	   
	    public void setItemActividad(Actividad actividad)
	    {
	        this.actividades.add(actividad);
	    }

	    public List<Actividad> getActividades() {
	        return actividades;
	    }

	    public void setActividades(List<Actividad> actividades) {
	        this.actividades = actividades;
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
	    public Doctor getMedico() {
			return medico;
		}

		public void setMedico(Doctor medico) {
			this.medico = medico;
		}
	 
	    
	    
	
    
}