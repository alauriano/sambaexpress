package ca.sambaexpress.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Dimension")
public class Dimension extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(unique=true, nullable=false,length=255)
	private String dimension_name;
	
	@Column(nullable = true)
	private float minWeight;
	
	@Column(nullable = false)
	private float maxWeight;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "weightUnit_code", nullable = false)
	private WeightUnit weightUnit;

	public Dimension(float minWeight, float maxWeight, WeightUnit weightUnit) {
		super();
		this.minWeight = minWeight;
		this.maxWeight = maxWeight;
		this.weightUnit = weightUnit;
	}
	
	public Dimension() {
		super();

	}

	

	public String getDimension_name() {
		return dimension_name;
	}

	public void setDimension_name(String dimension_name) {
		this.dimension_name = dimension_name;
	}

	public float getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(float minWeight) {
		this.minWeight = minWeight;
	}

	public float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public WeightUnit getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(WeightUnit weightUnit) {
		this.weightUnit = weightUnit;
	}


}
