package ca.sambaexpress.dao;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ca.sambaexpress.entity.City;

public class CityDao extends BaseDao<City> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityDao() {
		super(City.class);
	}

	public List<City> getCityBy(final String countryId) throws DaoException {
		Validate.notNull(countryId, "countryId is null");
		
		return run(new Callable<List<City>>() {

			@SuppressWarnings("unchecked")
			public List<City> call(Session session) throws DaoException {
				Criteria criteria = session.createCriteria(clazz,"city");
				criteria.createAlias("city.country", "country");
				//criteria.setCacheable(true);
				//criteria.setCacheMode(CacheMode.NORMAL);
				criteria.add(Restrictions.eq("country.country_id",Integer.valueOf(countryId)));
				return criteria.list();
			}
		});
	}
	
	public List<City> getCityBy(final int countryId) throws DaoException {
		Validate.notNull(countryId, "countryId is null");
		
		return run(new Callable<List<City>>() {

			@SuppressWarnings("unchecked")
			public List<City> call(Session session) throws DaoException {
				Criteria criteria = session.createCriteria(clazz,"city");
				criteria.createAlias("city.country", "country");
				criteria.add(Restrictions.eq("country.country_id",countryId));
				return criteria.list();
			}
		});
	}
}
