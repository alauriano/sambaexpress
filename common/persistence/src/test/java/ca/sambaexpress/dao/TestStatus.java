package ca.sambaexpress.dao;

import ca.sambaexpress.entity.Status;
import junit.framework.TestCase;

public class TestStatus extends TestCase {

	StatusDao statusDao = null;

	protected void setUp() throws Exception {
		statusDao = DaoFactory.createStatusDao();
	}

	public void testPersist() {
		try {
			statusDao.persist(new Status("OK"));
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}

	public void testDelete() {
		try {
			statusDao.delete(new Status("OK"));
			assertTrue(true);
		} catch (DaoException e) {
			assertFalse(true);
		}
	}

	protected void tearDown() throws Exception {
		statusDao = null;
	}

}
