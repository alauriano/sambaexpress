package ca.sambaexpress.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sambaexpress.entity.Pricing;

public class PricingDao extends BaseDao<Pricing> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger LOG = LoggerFactory.getLogger(PricingDao.class);

	public PricingDao(Class<?> clazz) {
		super(Pricing.class);
	}

	public List<Pricing> getPricing(final int cityFromId, final int cityToId,
			final float weight, final String weightUnit_code)
			throws DaoException {
		LOG.debug(
				"get pricing for cityFromId : {}  , cityToId : {} and weight {}",
				cityFromId, cityToId, weight);

		return run(new Callable<List<Pricing>>() {

			@SuppressWarnings("unchecked")
			public List<Pricing> call(Session session) throws DaoException {
				//TODO implements me
				Criteria criteria = session.createCriteria(clazz,"pricing");
				//criteria.setCacheable(true);
				//criteria.setCacheMode(CacheMode.NORMAL);
				criteria.add(Restrictions.eq("pricing.cityFrom.city_id",cityFromId));
				criteria.add(Restrictions.eq("pricing.cityTo.city_id",cityToId));
				return criteria.list();
			}
		});

	}

}
