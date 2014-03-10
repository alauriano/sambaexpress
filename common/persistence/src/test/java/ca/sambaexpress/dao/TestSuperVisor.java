package ca.sambaexpress.dao;

import junit.framework.TestCase;
import ca.sambaexpress.entity.City;
import ca.sambaexpress.entity.Country;
import ca.sambaexpress.entity.SuperVisor;

public class TestSuperVisor extends TestCase {
	SuperVisorDao superVisorDao = null;
	CityDao cityDao = null;
	CountryDao countryDao = null;

	protected void setUp() throws Exception {
		superVisorDao = DaoFactory.createSupervisorDao();
		cityDao = DaoFactory.createCityDao();
		countryDao = DaoFactory.createCountryDao(); 
	}

	/*public void testPersist() {
		
		try {
			SuperVisor superVisor = new SuperVisor();
			superVisor.setPassword("vnww;nvnwn");
			superVisor.setName("wvn;vbdw");
			superVisor.setEmail("adio.lauriano@gmail.com");
			superVisor.setFirstName("vnvb3hv3uiv");
			City city = new City();
			city.setCountry(new Country("SN","SENEGAL"));
			city.setDescription("Touba");
			superVisor.setCity(city);
			cityDao.persist(city);
			superVisorDao.persist(superVisor);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
		

	}

	public void testUpdate() {
		
		try {
			SuperVisor superVisor = new SuperVisor();
			superVisor.setPassword("dvdvsdvdsv");
			superVisor.setName("la");
			superVisor.setEmail("adio.lauriano@gmail.com");
			superVisor.setFirstName("me");
			City city = new City();
			city.setCountry(new Country("SN","SENEGAL"));
			city.setDescription("Touba");
			superVisor.setCity(city);
			superVisorDao.update(superVisor);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}

	}

	public void testDelete() {
		try {
			SuperVisor superVisor = new SuperVisor();
			superVisor.setEmail("adio.lauriano@gmail.com");
			superVisorDao.delete(superVisor);
			City city = new City();
			city.setCode(1L);
			cityDao.delete(city);
			countryDao.delete(new Country("SN",null));
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}*/

	protected void tearDown() throws Exception {
		superVisorDao = null;
		cityDao = null;
		countryDao = null;
	}

}
