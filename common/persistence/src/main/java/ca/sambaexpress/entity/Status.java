package ca.sambaexpress.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Status database table.
 * 
 */
@Entity
@Table(name = "Status")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 45)
	private String status_code;

	// bi-directional many-to-one association to Command
	@OneToMany(mappedBy = "status")
	private List<Command> commands;

	public Status(String status_code) {
		super();
		this.status_code = status_code;
	}

	public Status() {
	}

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public List<Command> getCommands() {
		return this.commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

}