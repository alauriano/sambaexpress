package ca.sambaexpress.dao;

import ca.sambaexpress.entity.Country;
import junit.framework.TestCase;

public class TestCountryDao extends TestCase {

	CountryDao countryDao = null;

	protected void setUp() throws Exception {
		countryDao = DaoFactory.createCountryDao();
	}

	/*public void testPersist() {
		Country country = new Country("SN", "SENEGAL");
		try {
			countryDao.persist(country);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(false);
		}
	}

	public void testUpdate() {
		Country country = new Country("SN", "SÉNÉGAL");
		try {
			countryDao.attachDirty(country);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(false);
		}
	}

	public void testDelete() {
		Country country = new Country("SN", "SÉNÉGAL");

		try {
			countryDao.delete(country);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(false);
		}
	}
	*/
	protected void tearDown() throws Exception {
		countryDao = null;
	}

}
