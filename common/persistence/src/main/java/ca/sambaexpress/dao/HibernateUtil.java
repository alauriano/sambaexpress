package ca.sambaexpress.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			sessionFactory = configuration
					.buildSessionFactory(serviceRegistryBuilder
							.buildServiceRegistry());
		} catch (HibernateException he) {
			throw new ExceptionInInitializerError(he);
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
