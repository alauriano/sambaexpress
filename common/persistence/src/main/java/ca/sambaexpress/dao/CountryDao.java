package ca.sambaexpress.dao;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sambaexpress.entity.Country;

public class CountryDao extends BaseDao<Country> {
	
	private Logger LOG = LoggerFactory.getLogger(CountryDao.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CountryDao() {
		super(Country.class);
	}
	
	public List<Country> list(final String continentCode) throws DaoException {
		Validate.notNull(continentCode);
		
		LOG.debug("get countries based on continent code {} ",continentCode);

		return run(new Callable<List<Country>>() {

			@SuppressWarnings("unchecked")
			public List<Country> call(Session session) throws DaoException {
				Criteria criteria = session.createCriteria(clazz,"country");
				criteria.createAlias("country.continent", "continent");
				//criteria.setCacheable(true);
				//criteria.setCacheMode(CacheMode.NORMAL);
				criteria.add(Restrictions.eq("continent.code", continentCode));
				return criteria.list();
			}
		});
		
	}

}
