package ca.sambaexpress.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the Pricing database table.
 * 
 */
@Entity
@Table(name="Pricing")
public class Pricing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false,length=11)
	private int pricing_id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="continentCodeFrom", referencedColumnName="code",nullable=false,updatable=true)
	private Continent continentFrom;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="countryFromId", referencedColumnName="country_id",nullable=true,updatable=true)
	private Country countryFrom;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cityFromId", referencedColumnName="city_id",nullable=true,updatable=true)
	private City cityFrom;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="continentCodeTo", referencedColumnName="code",nullable=false,updatable=true)
	private Continent continentTo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="countryToId", referencedColumnName="country_id",nullable=true,updatable=true)
	private Country countryTo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cityToId", referencedColumnName="city_id",nullable=true,updatable=true)
	private City cityTo;
	
	
	@Column(length=45, nullable=false)
	private Double price;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="currency_code",nullable=false,updatable=true)
	private Currency currency;

	//bi-directional many-to-one association to Transport
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="transport_type", nullable=false,updatable=true)
	private Transport transport;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dimension_name", nullable = false)
	private Dimension dimension;



    public Pricing() {
    }

	public int getPricing_id() {
		return pricing_id;
	}

	public void setPricing_id(int pricing_id) {
		this.pricing_id = pricing_id;
	}

	public City getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(City cityFrom) {
		this.cityFrom = cityFrom;
	}

	public City getCityTo() {
		return cityTo;
	}

	public void setCityTo(City cityTo) {
		this.cityTo = cityTo;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Continent getContinentFrom() {
		return continentFrom;
	}

	public void setContinentFrom(Continent continentFrom) {
		this.continentFrom = continentFrom;
	}

	public Country getCountryFrom() {
		return countryFrom;
	}

	public void setCountryFrom(Country countryFrom) {
		this.countryFrom = countryFrom;
	}

	public Continent getContinentTo() {
		return continentTo;
	}

	public void setContinentTo(Continent continentTo) {
		this.continentTo = continentTo;
	}

	public Country getCountryTo() {
		return countryTo;
	}

	public void setCountryTo(Country countryTo) {
		this.countryTo = countryTo;
	}
	
	
	
}