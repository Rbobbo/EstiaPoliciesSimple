package it.estia.entity.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import it.estia.entity.User;
import it.estia.entity.dao.DaoAbstract;
import it.estia.entity.dao.UserDAO;

@Transactional
public class UserDAOImpl extends DaoAbstract implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList()
	{
		logger.info("Entered in getUserList without parameters");
		List<User> userList = new ArrayList<>();
		Session session = getSessionLocal(); 
				
		userList = session.createQuery("from User").list();
		logger.info("Return getUserList {}", userList);
		return userList;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User getUser(String username)
	{
		logger.info("Entered in getUser {}",username);
		
		List<User> usersFound;
		usersFound = getSessionLocal().createQuery("from User where logincode=?")
				.setParameter(0, username).list();

		User result = null;
		if (usersFound.size() > 0)
		{
			result = usersFound.get(0);
		}
		
		logger.info("Return getUser {}", result);
		return result;
	}
	
	@Override
	public void addUser(User userToAdd)
	{
		logger.info("Entered in addUser {}",userToAdd);
		Session session = getSessionLocal();
		
		session.persist(userToAdd);
		logger.info("Return addUser {}", userToAdd);
	}

	@Override
	public User updateUser(User userToUpdate)
	{
		logger.info("Entered in updateUser {}",userToUpdate);
		Session session = getSessionLocal();

		session.update(userToUpdate);
		
		logger.info("Return updateUser {}", userToUpdate);
		return userToUpdate;
	}
	
	

}
