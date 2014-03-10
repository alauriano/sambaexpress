package ca.sambaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Transport database table.
 * 
 */
@Entity
@Table(name="Transport")
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	public Transport(String transport_type) {
		this.transport_type = transport_type;
	}

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String transport_type;

	//bi-directional many-to-one association to Command
	@OneToMany(mappedBy="transport")
	private List<Command> commands;

	//bi-directional many-to-one association to Pricing
	@OneToMany(mappedBy="transport")
	private List<Pricing> pricings;

    public Transport() {
    }

	public String getTransport_type() {
		return transport_type;
	}

	public void setTransport_type(String transport_type) {
		this.transport_type = transport_type;
	}



	public List<Command> getCommands() {
		return this.commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
	
	public List<Pricing> getPricings() {
		return this.pricings;
	}

	public void setPricings(List<Pricing> pricings) {
		this.pricings = pricings;
	}
	
}