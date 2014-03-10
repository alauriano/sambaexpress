package ca.sambaexpress.dao;

import ca.sambaexpress.entity.User;

public class UserDao extends BaseDao<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDao() {
		super(User.class);
	}

}
