package modelos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class EpisodioKey 
{
	@Column(name="usuario",nullable = false)
	Paciente user;
	
	@Column(name="fecha",nullable = false)
	String fecha;
	
	public EpisodioKey(Paciente p,String f)
	{
		user=p;
		fecha=f;
	}

	public Paciente getUser() {
		return user;
	}

	public void setUser(Paciente user) {
		this.user = user;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
