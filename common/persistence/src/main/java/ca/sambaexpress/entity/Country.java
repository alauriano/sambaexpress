package ca.sambaexpress.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the Country database table.
 * 
 */
@Entity
@Table(name="Country")
public class Country extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Country(int country_id, String code, String name, String full_name,
			String iso3, int number, int display_order) {
		super();
		this.country_id = country_id;
		this.code = code;
		this.name = name;
		this.full_name = full_name;
		this.iso3 = iso3;
		this.number = number;
		this.display_order = display_order;
	}

	public Country() {
		super();
	}

	@Id
	@Column(unique=true, nullable=false,length=11)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int country_id ;
	
	@Column(unique=true, nullable=false,length=2)
	//Two-letter country code (ISO 3166-1 alpha-2)
	private String code;
	
	@Column(unique=true, nullable=false,length=64)
	//English country name
	private String name;
	
	@Column(unique=true, nullable=false,length=128)
	//Full English country name
	private String full_name;
	
	@Column(unique=true, nullable=false,length=3)
	//Three-letter country code (ISO 3166-1 alpha-3)
	private String iso3;
	
	@Column(unique=true, nullable=false,length=3)
	//Three-digit country number (ISO 3166-1 numeric)
	private int number;
	
	@Column(unique=true, nullable=false,length=3)
	private int display_order = 900;
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="continentCode",referencedColumnName="code")
	private Continent continent;
	
	@OneToMany(mappedBy="country")
	private Set<City> cities;

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

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

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



	public int getDisplay_order() {
		return display_order;
	}

	public void setDisplay_order(int display_order) {
		this.display_order = display_order;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		
		result = prime * result + country_id;
		result = prime * result + display_order;
		result = prime * result
				+ ((full_name == null) ? 0 : full_name.hashCode());
		result = prime * result + ((iso3 == null) ? 0 : iso3.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
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
		Country other = (Country) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (country_id != other.country_id)
			return false;
		if (display_order != other.display_order)
			return false;
		if (full_name == null) {
			if (other.full_name != null)
				return false;
		} else if (!full_name.equals(other.full_name))
			return false;
		if (iso3 == null) {
			if (other.iso3 != null)
				return false;
		} else if (!iso3.equals(other.iso3))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", code=" + code
				+ ", name=" + name + ", full_name=" + full_name + ", iso3="
				+ iso3 + ", number=" + number + ", display_order=" + display_order + "]";
	}
	
	
	
	

}