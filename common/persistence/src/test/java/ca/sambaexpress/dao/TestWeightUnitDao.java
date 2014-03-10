package ca.sambaexpress.dao;

import junit.framework.TestCase;
import ca.sambaexpress.entity.WeightUnit;

public class TestWeightUnitDao extends TestCase {
	
	WeightUnitDao weightUnitDao = null;

	protected void setUp() throws Exception {
		weightUnitDao = DaoFactory.createWeightUnitDao();
	}

	public void testPersist() {
		try {
			weightUnitDao.persist(new WeightUnit("KGS"));
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}

	public void testDelete() {
		try {
			weightUnitDao.delete(new WeightUnit("KGS"));
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}

	protected void tearDown() throws Exception {
		weightUnitDao = null;
	}

}
