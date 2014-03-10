package ca.sambaexpress.business.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class QuotationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int fromCountryId;
	
	private int fromCityId;
	
	private int toCountryId;
	
	private int toCityId;
	
	private String mail;
	
	private String name;
	
	
	private List<DimensionBean> dimensions;

	public int getFromCountryId() {
		return fromCountryId;
	}

	public void setFromCountryId(int fromCountryId) {
		this.fromCountryId = fromCountryId;
	}

	public int getFromCityId() {
		return fromCityId;
	}

	public void setFromCityId(int fromCityId) {
		this.fromCityId = fromCityId;
	}

	public int getToCountryId() {
		return toCountryId;
	}

	public void setToCountryId(int toCountryId) {
		this.toCountryId = toCountryId;
	}

	public int getToCityId() {
		return toCityId;
	}

	public void setToCityId(int toCityId) {
		this.toCityId = toCityId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DimensionBean> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<DimensionBean> dimensions) {
		this.dimensions = dimensions;
	}
}
