package ca.sambaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SuperVisor database table.
 * 
 */
@Entity
@Table(name="SuperVisor")
public class SuperVisor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String superVisor_email;

	@Column(length=45)
	private String firstName;

	@Column(length=45)
	private String name;

	@Column(nullable=false, length=45)
	private String password;

	@Column(length=45)
	private String tel;

	//bi-directional many-to-one association to Command
	@OneToMany(mappedBy="superVisor")
	private List<Command> commands;

	//bi-directional many-to-one association to City
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="city_id", nullable=false,updatable=false)
	private City city;

	//bi-directional many-to-one association to DistributionPoint
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="distribution_id", nullable=true)
	private DistributionPoint distributionPoint;

    public SuperVisor() {
    }

	public String getSuperVisor_email() {
		return superVisor_email;
	}


	public void setSuperVisor_email(String superVisor_email) {
		this.superVisor_email = superVisor_email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
	
	public DistributionPoint getDistributionPoint() {
		return this.distributionPoint;
	}

	public void setDistributionPoint(DistributionPoint distributionPoint) {
		this.distributionPoint = distributionPoint;
	}
	
}