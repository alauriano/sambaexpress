package ca.sambaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Table(name="User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String user_email;

	@Column(length=45,nullable=false)
	private String address;

	@Column(length=45,nullable=false)
	private String firstName;

	@Column(length=45,nullable=false)
	private String name;

	@Column(nullable=false, length=45)
	private String password;

	@Column(length=45,nullable=true)
	private String tel;

	@Column(length=45,nullable=false)
	private String zipCode;

	//bi-directional many-to-one association to Command
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private List<Command> commands;

	//bi-directional many-to-one association to City
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="city_id", nullable=false)
	private City city;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role",nullable=false)
	private Role role;

    public User() {
    }


	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}



	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
}