package ca.sambaexpress.dao;

import junit.framework.TestCase;
import ca.sambaexpress.entity.Transport;

public class TestTransportDao extends TestCase {

	TransportDao transportDao = null;

	protected void setUp() throws Exception {
		transportDao = DaoFactory.createTransportDao();
	}

	public void testPersist() {
		try {
			transportDao.persist(new Transport("AIR"));
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}

	public void testDelete() {
		try {
			transportDao.delete(new Transport("AIR"));
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}

	protected void tearDown() throws Exception {
		transportDao = null;
	}
}
