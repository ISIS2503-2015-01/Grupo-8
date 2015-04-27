package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import be.objectify.deadbolt.core.models.Role;

@Entity
public class SecurityRole implements Role
{
    @Id
    public Long id;

    @Column(nullable = false,
            unique = true)
    
    public String roleName;

    public SecurityRole()
    {
        // no-op
    }

    private SecurityRole(Builder builder)
    {
        roleName = builder.roleName;
    }

    @Override
    public String getName()
    {
        return roleName;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long i)
    {
    	this.id=i;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        if (!super.equals(o))
        {
            return false;
        }

        SecurityRole that = (SecurityRole) o;

        return !(roleName != null ? !roleName.equals(that.roleName) : that.roleName != null);

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
    
    /**
     * Clase para crear un nuevo Rol. 
     * 1. Inicializar con construcot con el nombre del rol
     * 2. Lo crea con securityRol.build()
     * @author David Ricardo
     */

    public static final class Builder
    {
        private String roleName;

        public Builder roleName(String roleName)
        {
            this.roleName = roleName;
            return this;
        }

        public SecurityRole build()
        {
            return new SecurityRole(this);
        }
    }

}
