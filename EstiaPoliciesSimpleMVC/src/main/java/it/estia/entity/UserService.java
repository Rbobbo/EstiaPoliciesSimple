package it.estia.entity;

import java.util.List;

public interface UserService
{
	public List<User> getUserList();
	
	public void addUser(User user);
	
	public User getUser(String username);

}
