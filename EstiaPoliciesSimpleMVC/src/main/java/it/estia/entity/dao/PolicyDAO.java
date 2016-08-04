package it.estia.entity.dao;

import java.util.List;

import it.estia.entity.Policy;
import it.estia.entity.User;

public interface PolicyDAO
{
	
	/**
	 * Add policy to db
	 * @param policyToAdd
	 * @return
	 */
	public Policy addPolicy(Policy policyToAdd);
	
	/**
	 * Get list of policy by the user
	 * @param userRife
	 * @return
	 */
	public List<Policy> getPolicyList(User userRife);
	
	/**
	 * Get a specific policy from db
	 * @param id
	 * @return
	 */
	public Policy getPolicy(int id);

}
