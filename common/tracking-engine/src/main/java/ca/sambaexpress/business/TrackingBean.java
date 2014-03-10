package ca.sambaexpress.business;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang.Validate;

import ca.sambaexpress.dao.DaoException;
import ca.sambaexpress.dao.DaoFactory;
import ca.sambaexpress.entity.City;
import ca.sambaexpress.entity.Command;
import ca.sambaexpress.entity.Continent;
import ca.sambaexpress.entity.Country;
import ca.sambaexpress.entity.Currency;
import ca.sambaexpress.entity.Dimension;
import ca.sambaexpress.entity.Pricing;
import ca.sambaexpress.entity.Role;
import ca.sambaexpress.entity.Status;
import ca.sambaexpress.entity.SuperVisor;
import ca.sambaexpress.entity.Transport;
import ca.sambaexpress.entity.User;
import ca.sambaexpress.entity.WeightUnit;

@Stateless
public class TrackingBean {
	//private Logger LOG = LoggerFactory.getLogger(TrackingBean.class);

	public List<Pricing> getPricings(final int cityFromId , final int cityToId, final float weight, final String weightUnit_code ) throws DaoException {
		// TODO implement me
			return DaoFactory.createPricingDao().getPricing(cityFromId, cityToId, weight,weightUnit_code);
	}
	
	public List<Pricing> getPricings() throws DaoException {
		return DaoFactory.createPricingDao().list();
}
	
	public void savePricing(Pricing pricing) throws DaoException {
		Validate.notNull(pricing, "city is null");
		DaoFactory.createPricingDao().persist(pricing);
	}
	
	public void updatePricing(Pricing pricing) throws DaoException {
		Validate.notNull(pricing, "pricing is null");
		DaoFactory.createPricingDao().update(pricing);
	}
	
	public void deletePricing(Pricing pricing) throws DaoException {
		Validate.notNull(pricing, "pricing is null");
		DaoFactory.createPricingDao().delete(pricing);
	}

	public List<City> getCitiesBy(String countryId) throws DaoException {
		
		return DaoFactory.createCityDao().getCityBy(countryId);
	}
	
	public List<City> getCities() throws DaoException {
		return DaoFactory.createCityDao().list();
	}

	public List<Country> getCountries() throws DaoException {
		return DaoFactory.createCountryDao().list();
	}

	public void saveCity(City city) throws DaoException {
		Validate.notNull(city, "city is null");
		DaoFactory.createCityDao().persist(city);
	}

	public void updateCity(City city) throws DaoException {
		Validate.notNull(city, "city is null");
		DaoFactory.createCityDao().update(city);
	}

	public void deleteCity(City city) throws DaoException {
		Validate.notNull(city, "city is null");
		DaoFactory.createCityDao().delete(city);
	}

	public void saveCurrency(Currency currency) throws DaoException {
		Validate.notNull(currency, "currency is null");
		DaoFactory.createCurrencyDao().persist(currency);
	}

	public void updateCurrency(Currency currency) throws DaoException {
		Validate.notNull(currency, "currency is null");
		DaoFactory.createCurrencyDao().update(currency);
	}

	public void deleteCurrency(Currency currency) throws DaoException {
		Validate.notNull(currency, "currency is null");
		DaoFactory.createCurrencyDao().delete(currency);
	}

	public void saveTransport(Transport transport) throws DaoException {
		Validate.notNull(transport, "transport is null");
		DaoFactory.createTransportDao().persist(transport);
	}

	public void updateTransport(Transport transport) throws DaoException {
		Validate.notNull(transport, "transport is null");
		DaoFactory.createTransportDao().update(transport);
	}

	public void deleteTransport(Transport transport) throws DaoException {
		Validate.notNull(transport, "transport is null");
		DaoFactory.createTransportDao().delete(transport);
	}

	public void saveWeightUnit(WeightUnit weightUnit) throws DaoException {
		Validate.notNull(weightUnit, "weightUnit is null");
		DaoFactory.createWeightUnitDao().persist(weightUnit);
	}

	public void updateWeightUnit(WeightUnit weightUnit) throws DaoException {
		Validate.notNull(weightUnit, "weightUnit is null");
		DaoFactory.createWeightUnitDao().update(weightUnit);
	}

	public void deleteWeightUnit(WeightUnit weightUnit) throws DaoException {
		Validate.notNull(weightUnit, "weightUnit is null");
		DaoFactory.createWeightUnitDao().delete(weightUnit);
	}

	public void updateCountry(Country country) throws DaoException {
		Validate.notNull(country, "country is null");
		DaoFactory.createCountryDao().update(country);
	}

	public void deleteCountry(Country country) throws DaoException {
		Validate.notNull(country, "country is null");
		DaoFactory.createCountryDao().delete(country);
	}

	public void saveCountry(Country country) throws DaoException {
		Validate.notNull(country, "country is null");
		DaoFactory.createCountryDao().persist(country);
	}

	public List<Currency> getCurrencies() throws DaoException {
		return DaoFactory.createCurrencyDao().list();
	}

	public List<WeightUnit> getWeightUnits() throws DaoException {
		return DaoFactory.createWeightUnitDao().list();
	}

	public List<Transport> getTransports() throws DaoException {
		return DaoFactory.createTransportDao().list();
	}

	public List<Status> getStatus() throws DaoException {
		return DaoFactory.createStatusDao().list();
	}

	public List<SuperVisor> getSuperVisors() throws DaoException {
		return DaoFactory.createSupervisorDao().list();
	}

	public List<Command> getCommands() throws DaoException {
		return DaoFactory.createCommandDao().list();
	}
	
	public List<Continent> getContinents() throws DaoException {
		return DaoFactory.createContinentDao().list();
	}
	
	public void deleteContinent(Continent continent) throws DaoException {
		 DaoFactory.createContinentDao().delete(continent);;
	}

	public void updateContinent(Continent continent) throws DaoException {
		 DaoFactory.createContinentDao().update(continent);;
	}
	
	public void deleteDimension(Dimension dimension) throws DaoException {
		  DaoFactory.createDimensionDao().delete(dimension);
	}
	
	public void updateDimension(Dimension dimension) throws DaoException {
		  DaoFactory.createDimensionDao().update(dimension);
	}
	
	public List<Dimension> getDimensions() throws DaoException{
		return DaoFactory.createDimensionDao().list();
	}
	
	public void saveDimension(Dimension dimension) throws DaoException {
		DaoFactory.createDimensionDao().persist(dimension);
	}
	
	public List<Role> getRoles() throws DaoException {
		return DaoFactory.createRoleDao().list();
	}
	
	public void deleteRole(Role role) throws DaoException {
		 DaoFactory.createRoleDao().delete(role);
	}
	
	public void updateRole(Role role) throws DaoException {
		 DaoFactory.createRoleDao().update(role);
	}
	
	public List<Country> getCountries(String continentCode) throws DaoException {
		Validate.notNull(continentCode);
		return DaoFactory.createCountryDao().list(continentCode);
	}
	
	public List<User> getUsers() throws DaoException{
		return DaoFactory.createUserDao().list();
	}
	
	public void saveUser(User user) throws DaoException{
		DaoFactory.createUserDao().persist(user);
	}
	
	public void updateUser(User user) throws DaoException { 
		DaoFactory.createUserDao().update(user);
	}
	
	public void deletUser(User user) throws DaoException{
		DaoFactory.createUserDao().delete(user);
	}
}
