package ca.sambaexpress.entity;

import java.util.List;

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
 * The persistent class for the City database table.
 * 
 */
@Entity
@Table(name = "City")
public class City extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	
	

	public City() {
		super();
	}
	
	

	public City(String city_description, String accentCity, String region,
			String population, String latitude, String longitude,
			Country country) {
		super();
		this.city_description = city_description;
		this.accentCity = accentCity;
		this.region = region;
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false,length=11)
	private int city_id;

	@Column(nullable = false, length = 45)
	private String city_description;
	
	@Column(nullable = true)
	private String accentCity;
	
	@Column(nullable = true)
	private String region;
	
	@Column(nullable = true)
	private String population;
	
	@Column(nullable = true)
	private String latitude;
	
	@Column(nullable = true)
	private String longitude;
	

	// bi-directional many-to-one association to Country
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

	// bi-directional many-to-one association to DistributionPoint
	@OneToMany(mappedBy = "city")
	private List<DistributionPoint> distributionPoints;

	// bi-directional many-to-one association to SuperVisor
	@OneToMany(mappedBy = "city")
	private List<SuperVisor> superVisors;

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "city")
	private List<User> users;

	// bi-directional many-to-one association to Pricing
	@OneToMany(mappedBy = "cityFrom", cascade = { CascadeType.ALL })
	private List<Pricing> pricingsCityFrom;

	// bi-directional many-to-one association to Pricing
	@OneToMany(mappedBy = "cityTo", cascade = { CascadeType.ALL })
	private List<Pricing> pricingsCityTo;

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity_description() {
		return city_description;
	}

	public void setCity_description(String city_description) {
		this.city_description = city_description;
	}

	public String getAccentCity() {
		return accentCity;
	}

	public void setAccentCity(String accentCity) {
		this.accentCity = accentCity;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<DistributionPoint> getDistributionPoints() {
		return distributionPoints;
	}

	public void setDistributionPoints(List<DistributionPoint> distributionPoints) {
		this.distributionPoints = distributionPoints;
	}

	public List<SuperVisor> getSuperVisors() {
		return superVisors;
	}

	public void setSuperVisors(List<SuperVisor> superVisors) {
		this.superVisors = superVisors;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Pricing> getPricingsCityFrom() {
		return pricingsCityFrom;
	}

	public void setPricingsCityFrom(List<Pricing> pricingsCityFrom) {
		this.pricingsCityFrom = pricingsCityFrom;
	}

	public List<Pricing> getPricingsCityTo() {
		return pricingsCityTo;
	}

	public void setPricingsCityTo(List<Pricing> pricingsCityTo) {
		this.pricingsCityTo = pricingsCityTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accentCity == null) ? 0 : accentCity.hashCode());
		result = prime
				* result
				+ ((city_description == null) ? 0 : city_description.hashCode());
		result = prime * result + city_id;
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result
				+ ((population == null) ? 0 : population.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
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
		City other = (City) obj;
		if (accentCity == null) {
			if (other.accentCity != null)
				return false;
		} else if (!accentCity.equals(other.accentCity))
			return false;
		if (city_description == null) {
			if (other.city_description != null)
				return false;
		} else if (!city_description.equals(other.city_description))
			return false;
		if (city_id != other.city_id)
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (population == null) {
			if (other.population != null)
				return false;
		} else if (!population.equals(other.population))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city_description="
				+ city_description + ", accentCity=" + accentCity + ", region="
				+ region + ", population=" + population + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
	
	


}