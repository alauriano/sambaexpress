package ca.sambaexpress.business.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="quotationResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuotationRBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuotationRBean() {
		
	}
	private String fromCountryName;
	
	private String fromCityName;
	
	private String toCountryName;
	
	private String toCityName;

	private List<DimensionBean> dimensions ;



	public String getFromCountryName() {
		return fromCountryName;
	}

	public void setFromCountryName(String fromCountryName) {
		this.fromCountryName = fromCountryName;
	}

	public String getFromCityName() {
		return fromCityName;
	}

	public void setFromCityName(String fromCityName) {
		this.fromCityName = fromCityName;
	}

	public String getToCountryName() {
		return toCountryName;
	}

	public void setToCountryName(String toCountryName) {
		this.toCountryName = toCountryName;
	}

	public String getToCityName() {
		return toCityName;
	}

	public void setToCityName(String toCityName) {
		this.toCityName = toCityName;
	}

	public List<DimensionBean> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<DimensionBean> dimensions) {
		this.dimensions = dimensions;
	}
	
	public void addDimensions(DimensionBean dimensionBean) {
		if(dimensions == null){
			dimensions = new ArrayList<DimensionBean>();
		}
		dimensions.add(dimensionBean);
		
	}
}
