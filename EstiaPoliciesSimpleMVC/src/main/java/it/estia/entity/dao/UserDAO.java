package it.estia.entity.dao;

import java.util.List;

import it.estia.entity.User;


public interface UserDAO
{
	public List<User> getUserList();
	
	public User getUser(String username);
	
	public void addUser(User userToAdd);

}
