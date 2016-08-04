package it.estia.entity.dao;

import java.util.List;

import it.estia.entity.User;


public interface UserDAO
{
	/**
	 * Get all the user registered from the db
	 * @return
	 */
	public List<User> getUserList();
	
	/**
	 * Get User by username
	 * @param username
	 * @return
	 */
	public User getUser(String username);
	
	/**
	 * Add user to DB
	 * @param userToAdd
	 */
	public void addUser(User userToAdd);
	
	/**
	 * Edit all fields of userToUpdate
	 * @param userToUpdate
	 * @return
	 */
	public User updateUser(User userToUpdate);

}
