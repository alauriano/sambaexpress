package ca.sambaexpress.ui.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sambaexpress.business.TrackingBean;
import ca.sambaexpress.dao.DaoException;
import ca.sambaexpress.entity.Country;
import ca.sambaexpress.ui.CountryBean;

@RequestScoped
@ManagedBean
public class CountryBeanAction implements Serializable {

	private Logger LOG = LoggerFactory.getLogger(CountryBeanAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String COUNTRY_CODE_HEADER = "CODE";

	private static final String COUNTRY_DESCRIPTION_HEADER = "DESCRIPTION";

	private String codeHeader;

	private String descriptionHeader;

	@ManagedProperty(value = "#{countryBean}")
	private CountryBean countryBean;

	@EJB
	private TrackingBean trackingBean;

	private int selectedRow;

	private int page = 1;

	private List<CountryBean> allCountries;

	public String getCodeHeader() {
		codeHeader = COUNTRY_CODE_HEADER;
		return codeHeader;
	}

	public void setCodeHeader(String codeHeader) {
		this.codeHeader = codeHeader;
	}

	public String getDescriptionHeader() {
		descriptionHeader = COUNTRY_DESCRIPTION_HEADER;
		return descriptionHeader;
	}

	public void setDescriptionHeader(String descriptionHeader) {
		this.descriptionHeader = descriptionHeader;
	}

	public void addCountry() {
		Validate.notNull(countryBean, "countryBean instance is null");
		Validate.notNull(trackingBean,
				"Error when getting EJB trackingBean reference");
		try {
			trackingBean.saveCountry(new Country(countryBean.getCode(),
					countryBean.getDescription()));
		} catch (DaoException daoe) {
			LOG.error("Unable to persist country in DB", daoe);
		}
	}

	public void modifyCountry() {
		Validate.notNull(trackingBean,
				"Error when getting EJB trackingBean reference");
		Validate.notNull(countryBean, "unable to get modified ");
		try {
			trackingBean.updateCountry(new Country(countryBean.getCode(),
					countryBean.getDescription()));
		} catch (DaoException daoe) {
			LOG.error("Unable to delete country in DB", daoe);
		}
	}

	public void deleteCountry() {
		Validate.notNull(trackingBean,
				"Error when getting EJB trackingBean reference");
		try {
			int selectedRow = getSelectedRow();
			CountryBean deletedCountry = allCountries.get(selectedRow);
			trackingBean.deleteCountry(new Country(deletedCountry.getCode(),
					deletedCountry.getDescription()));
			allCountries.remove(selectedRow);
		} catch (DaoException daoe) {
			LOG.error("Unable to delete country in DB", daoe);
		}
	}

	public CountryBean getCountryBean() {
		return countryBean;
	}

	public void setCountryBean(CountryBean countryBean) {
		this.countryBean = countryBean;
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<CountryBean> getAllCountries() {

		Validate.notNull(trackingBean,
				"Error when getting EJB trackingBean reference");
		try {
			List<Country> countries = trackingBean.getCountries();
			
			if (countries != null && !countries.isEmpty()) {
				allCountries = new ArrayList<CountryBean>();
				for (Country country : countries) {
					if (country != null) {
						allCountries.add(new CountryBean(country.getCode(),
								country.getDescription()));
					}
				}
			}
		} catch (DaoException daoe) {
			LOG.error("Unable to get all countries from DB", daoe);
		}
		return allCountries;
	}

	public void setAllCountries(List<CountryBean> allCountries) {
		this.allCountries = allCountries;
	}

	public void updateCountry(AjaxBehaviorEvent vce) {
		String componentId = vce.getComponent().getId();
		String newValue = "";
		if ("countryCode".equalsIgnoreCase(componentId)) {
			countryBean.setCode(newValue);
		} else if ("countryDescription".equalsIgnoreCase(componentId)) {
			countryBean.setDescription(newValue);
		}

	}
}
