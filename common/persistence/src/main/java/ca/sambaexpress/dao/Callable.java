package ca.sambaexpress.dao;

import org.hibernate.Session;

public interface Callable<T> {
	
	public T call(Session session) throws DaoException;

}
