package ca.sambaexpress.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the Command database table.
 * 
 */
@Entity
@Table(name="Command")
public class Command implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false,length=11)
	private int  id;

	@Column(length=45)
	private String cityFrom;

	@Column(length=45)
	private String cityTo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date commandDate;

	@Column(length=45)
	private String countryFrom;

	@Column(length=45)
	private String countryTo;

    @Lob()
	private byte[] fileContent;

	@Column(length=45)
	private String fileName;

	@Column(length=45)
	private String price;

	@Column(length=45)
	private String transportId;

	@Column(length=45)
	private String weight;

	//uni-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="currency_code", nullable=false)
	private Currency currency;

	//bi-directional many-to-one association to DistributionPoint
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="distributionPoint_id", nullable=false)
	private DistributionPoint distributionPoint;

	//bi-directional many-to-one association to Status
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status_code", nullable=false)
	private Status status;

	//bi-directional many-to-one association to SuperVisor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="superVisor_email", nullable=false)
	private SuperVisor superVisor;

	//bi-directional many-to-one association to Transport
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transport_type", nullable=false)
	private Transport transport;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_email", nullable=false)
	private User user;

	//bi-directional many-to-one association to WeightUnit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="weightUnit_code", nullable=false)
	private WeightUnit weightUnit;

    public Command() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityFrom() {
		return this.cityFrom;
	}

	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}

	public String getCityTo() {
		return this.cityTo;
	}

	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}

	public Date getCommandDate() {
		return this.commandDate;
	}

	public void setCommandDate(Date commandDate) {
		this.commandDate = commandDate;
	}

	public String getCountryFrom() {
		return this.countryFrom;
	}

	public void setCountryFrom(String countryFrom) {
		this.countryFrom = countryFrom;
	}

	public String getCountryTo() {
		return this.countryTo;
	}

	public void setCountryTo(String countryTo) {
		this.countryTo = countryTo;
	}

	public byte[] getFileContent() {
		return this.fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTransportId() {
		return this.transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public DistributionPoint getDistributionPoint() {
		return this.distributionPoint;
	}

	public void setDistributionPoint(DistributionPoint distributionPoint) {
		this.distributionPoint = distributionPoint;
	}
	
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public SuperVisor getSuperVisor() {
		return this.superVisor;
	}

	public void setSuperVisor(SuperVisor superVisor) {
		this.superVisor = superVisor;
	}
	
	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public WeightUnit getWeightUnit() {
		return this.weightUnit;
	}

	public void setWeightUnit(WeightUnit weightUnit) {
		this.weightUnit = weightUnit;
	}
	
}