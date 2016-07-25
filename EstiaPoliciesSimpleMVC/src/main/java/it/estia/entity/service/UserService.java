package it.estia.entity.service;

import java.util.List;

import it.estia.entity.User;

public interface UserService
{
	public List<User> getUserList();
	
	public void addUser(User user);
	
	public User getUser(String username);
	
	public User updateUser(User userEdit);

}
