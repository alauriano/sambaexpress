package ca.sambaexpress.dao;

import ca.sambaexpress.entity.Currency;

public class CurrencyDao extends BaseDao<Currency> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrencyDao() {
		super(Currency.class);
	}

}
