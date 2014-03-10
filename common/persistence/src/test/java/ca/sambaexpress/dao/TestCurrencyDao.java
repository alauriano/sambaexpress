package ca.sambaexpress.dao;

import ca.sambaexpress.entity.Currency;
import junit.framework.TestCase;

public class TestCurrencyDao extends TestCase {

	CurrencyDao currencyDao = null;

	protected void setUp() throws Exception {
		currencyDao = DaoFactory.createCurrencyDao();
	}

	/*public void testPersist(){
		Currency currency = new Currency();
		currency.setCode("EUR");
		currency.setDescription("EURO");
		try {
			currencyDao.persist(currency);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}

	public void testUpdate() {
		Currency currency = new Currency();
		currency.setCode("EUR");
		currency.setDescription("EUROS");
		try {
			currencyDao.update(currency);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}

	public void testDelete() {
		Currency currency = new Currency();
		currency.setCode("EUR");
		try {
			currencyDao.delete(currency);
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}*/

	protected void tearDown() throws Exception {
		currencyDao = null;
	}

}
