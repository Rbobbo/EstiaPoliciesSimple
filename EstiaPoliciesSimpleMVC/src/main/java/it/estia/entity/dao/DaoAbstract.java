package it.estia.entity.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DaoAbstract
{
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSessionLocal()
	{
		try
		{
			return this.sessionFactory.getCurrentSession();
		}
		catch ( HibernateException he ) 
		{
			return this.sessionFactory.openSession();
		}
	}

}
