package ca.sambaexpress.entity;

import java.io.Serializable;
import java.util.List;

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
 * The persistent class for the DistributionPoint database table.
 * 
 */
@Entity
@Table(name="DistributionPoint")
public class DistributionPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false,length=11)
	private int distribution_id;

	@Column(length=45)
	private String address;

	@Column(length=45)
	private String tel;

	@Column(length=45)
	private String zipCode;

	//bi-directional many-to-one association to Command
	@OneToMany(mappedBy="distributionPoint")
	private List<Command> commands;

	//bi-directional many-to-one association to City
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="city_id", nullable=false)
	private City city;

	//bi-directional many-to-one association to SuperVisor
	@OneToMany(mappedBy="distributionPoint")
	private List<SuperVisor> superVisors;

    public DistributionPoint() {
    }

	public int getDistribution_id() {
		return distribution_id;
	}


	public void setDistribution_id(int distribution_id) {
		this.distribution_id = distribution_id;
	}



	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Command> getCommands() {
		return this.commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
	
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public List<SuperVisor> getSuperVisors() {
		return this.superVisors;
	}

	public void setSuperVisors(List<SuperVisor> superVisors) {
		this.superVisors = superVisors;
	}
	
}