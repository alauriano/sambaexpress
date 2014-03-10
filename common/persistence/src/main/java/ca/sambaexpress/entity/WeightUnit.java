package ca.sambaexpress.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the WeightUnit database table.
 * 
 */
@Entity
@Table(name="WeightUnit")
public class WeightUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public WeightUnit(String weightUnit_code) {
		this.weightUnit_code = weightUnit_code;
	}
	
    public WeightUnit() {
    }


	@Id
	@Column(unique=true, nullable=false, length=45)
	private String weightUnit_code;


	public String getWeightUnit_code() {
		return weightUnit_code;
	}


	public void setWeightUnit_code(String weightUnit_code) {
		this.weightUnit_code = weightUnit_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((weightUnit_code == null) ? 0 : weightUnit_code.hashCode());
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
		WeightUnit other = (WeightUnit) obj;
		if (weightUnit_code == null) {
			if (other.weightUnit_code != null)
				return false;
		} else if (!weightUnit_code.equals(other.weightUnit_code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WeightUnit [weightUnit_code=" + weightUnit_code + "]";
	}
	
	

	
}