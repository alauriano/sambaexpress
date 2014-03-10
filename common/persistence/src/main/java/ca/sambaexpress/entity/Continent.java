package ca.sambaexpress.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Continent")
public class Continent extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public Continent(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Continent() {
		super();
	}

	@Id
	@Column(unique=true, nullable=false,length=2)
	private String code;
	
	@Column(unique=true, nullable=true,length=255)
	private String name;
	
	@OneToMany(mappedBy="continent")
	private Set<Country> countries ;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Country> getCountries() {
		return countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "Continent [code=" + code + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Continent other = (Continent) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
