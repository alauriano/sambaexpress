package ca.sambaexpress.dao;

import ca.sambaexpress.entity.Command;

public class CommandDao extends BaseDao<Command> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandDao() {
		super(Command.class);
	}

}
