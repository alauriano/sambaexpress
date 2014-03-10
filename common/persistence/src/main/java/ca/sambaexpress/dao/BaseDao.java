package ca.sambaexpress.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDao<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger LOG = LoggerFactory.getLogger(BaseDao.class);
	protected Class<?> clazz;

	public BaseDao(Class<?> clazz) {
		this.clazz = clazz;
	}

	protected <A> A run(Callable<A> callable) throws DaoException {
		A a = null;
		Transaction tx = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			a = callable.call(session);
			tx.commit();

		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			throw new DaoException("Persistence error", he);
		} finally {

		}

		return a;
	}

	public void persist(final T transientInstance) throws DaoException {
		LOG.debug("persisting instance");

		run(new Callable<T>() {

			public T call(Session session) throws DaoException {
				session.persist(transientInstance);
				return null;
			}
		});

	}

	public void update(final T transientInstance) throws DaoException {
		LOG.debug("persisting instance");

		run(new Callable<T>() {

			public T call(Session session) throws DaoException {
				session.update(transientInstance);
				return null;
			}
		});
	}

	/**
	 * save or updates
	 * 
	 * @param instance
	 * @throws DaoException
	 */
	public void attachDirty(final T instance) throws DaoException {
		LOG.debug("attachDirty instance");
		run(new Callable<T>() {

			public T call(Session session) throws DaoException {
				session.saveOrUpdate(instance);
				return null;
			}
		});
	}

	public void attachClean(final T instance) throws DaoException {
		LOG.debug("attaching clean  instance");

		run(new Callable<T>() {

			public T call(Session session) throws DaoException {
				session.buildLockRequest(LockOptions.NONE).lock(instance);
				return null;
			}
		});
	}

	public void delete(final T instance) throws DaoException {
		LOG.debug("deleting instance");

		run(new Callable<T>() {

			public T call(Session session) throws DaoException {
				session.delete(instance);
				return null;
			}
		});
	}

	public T merge(final T detachedInstance) throws DaoException {
		LOG.debug("merging instance");

		return run(new Callable<T>() {

			@SuppressWarnings("unchecked")
			public T call(Session session) throws DaoException {

				return (T) session.merge(detachedInstance);
			}
		});
	}

	public T findById(final Serializable id) throws DaoException {
		LOG.debug("getting instance with id: " + id);

		return run(new Callable<T>() {

			@SuppressWarnings("unchecked")
			public T call(Session session) throws DaoException {

				return (T) session.get(clazz, id);
			}
		});

	}
	

	public List<T> findByExample(final T instance) throws DaoException {
		LOG.debug("finding instance by example");

		return run(new Callable<List<T>>() {

			@SuppressWarnings("unchecked")
			public List<T> call(Session session) throws DaoException {
				Example example = Example.create(instance);
				return (List<T>) session.createCriteria(clazz).add(example)
						.list();
			}
		});

	}

	public List<T> list() throws DaoException {
		LOG.debug("finding instance ");

		return run(new Callable<List<T>>() {

			@SuppressWarnings("unchecked")
			public List<T> call(Session session) throws DaoException {
				Criteria criteria = session.createCriteria(clazz);
				//criteria.setCacheable(true);
				//criteria.setCacheMode(CacheMode.NORMAL);
				return criteria.list();
			}
		});
	}

}
