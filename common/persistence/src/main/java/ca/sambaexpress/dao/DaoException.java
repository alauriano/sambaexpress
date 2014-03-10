package ca.sambaexpress.dao;
/**
 * 
 * @author abdulsatar
 *
 */
public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException(String description) {
		super(description);
	}

	public DaoException(Throwable th) {
		super(th);
	}

	public DaoException(String description, Throwable th) {
		super(description, th);
	}
}
