package it.estia.entity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.estia.entity.User;
import it.estia.entity.dao.UserDAO;
import it.estia.entity.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> getUserList()
	{
		
		return userDAO.getUserList();
	}
	
	@Override
	@Transactional
	public void addUser(User user)
	{
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public User getUser(String username)
	{
		
		return userDAO.getUser(username);
	}

	@Override
	@Transactional
	public User updateUser(User userEdit)
	{
		
		return userDAO.updateUser(userEdit);
	}

}
