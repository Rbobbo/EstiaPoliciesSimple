package it.estia.entity.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DaoAbstract
{
	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(DaoAbstract.class);
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSessionLocal()
	{
		try
		{
			logger.info("Try to returned current session");
			return this.sessionFactory.getCurrentSession();
		}
		catch ( HibernateException he ) 
		{
			logger.info("Opened new Session");
			return this.sessionFactory.openSession();
		}
	}
	

}
