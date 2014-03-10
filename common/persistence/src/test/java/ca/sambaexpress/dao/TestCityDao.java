package ca.sambaexpress.dao;

import java.util.List;

import junit.framework.TestCase;
import ca.sambaexpress.entity.City;
import ca.sambaexpress.entity.Country;

public class TestCityDao extends TestCase {

	CityDao cityDao = null;
	CountryDao countryDao = null;

	protected void setUp() throws Exception {
		cityDao = DaoFactory.createCityDao();
		countryDao = DaoFactory.createCountryDao();
	}

	/*public void testPersist() {
		City city = new City();
		city.setDescription("Dakar");
		city.setCountry(new Country("SN", null));
		try {
			countryDao.persist(new Country("SN", "SENEGAL"));
			cityDao.persist(city);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(false);

		}
	}

	public void testUpdate() {
		try {
			City city = new City();
			city.setDescription("Touba");
			city.setCountry(new Country("SN", null));
			city.setCode(1L);
			cityDao.update(city);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(false);

		}
	}

	public void testDelete() {
		City city = new City();
		city.setDescription("Touba");
		city.setCountry(new Country("SN", null));
		city.setCode(1L);
		try {
			cityDao.delete(city);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(false);
		}
	}

	public void testFindByExample() throws DaoException{
		City city = new City();
		city.setCountry(new Country("SN", null));
		List<City> cities = cityDao.findByExample(city);
		assertTrue(cities != null && cities.size() == 1);
		
	}*/
	protected void tearDown() throws Exception {
		cityDao = null;
		countryDao = null;
	}

}
