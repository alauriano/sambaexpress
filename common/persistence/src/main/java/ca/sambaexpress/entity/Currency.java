package ca.sambaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Currency database table.
 * 
 */
@Entity
@Table(name="Currency")
public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;

	public Currency(String currency_code, String description) {
		this.currency_code = currency_code;
		this.description = description;
	}

	@Id
	@Column(unique=true, nullable=false, length=3)
	private String currency_code;

	@Column(nullable=false, length=45)
	private String description;

	//bi-directional many-to-one association to Pricing
	@OneToMany(mappedBy="currency",cascade={CascadeType.ALL})
	private List<Pricing> pricings;

    public Currency() {
    }

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}



	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Pricing> getPricings() {
		return this.pricings;
	}

	public void setPricings(List<Pricing> pricings) {
		this.pricings = pricings;
	}
	
}