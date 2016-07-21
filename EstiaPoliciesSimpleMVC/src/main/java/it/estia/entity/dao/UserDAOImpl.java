package it.estia.entity.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import it.estia.entity.User;

@Transactional
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList()
	{
		List<User> userList = new ArrayList<>();
		Session session = getSessionLocal(); 
				
		userList = session.createQuery("from User").list();
		return userList;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User getUser(String username)
	{
		List<User> usersFound;
		usersFound = getSessionLocal().createQuery("from User where logincode=?")
				.setParameter(0, username).list();

		if (usersFound.size() > 0)
		{
			return usersFound.get(0);
		}
		else
		{
			return null;
		}
		
	}
	
	@Override
	public void addUser(User userToAdd)
	{
		Session session = getSessionLocal();
		session.persist(userToAdd);
	}

	private Session getSessionLocal()
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
