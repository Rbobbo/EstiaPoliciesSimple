package it.estia.entity.dao;

import java.util.List;

import it.estia.entity.Policy;
import it.estia.entity.User;

public interface PolicyDAO
{
	
	public Policy addPolicy(Policy policyToAdd);
	
	public List<Policy> getPolicyList(User userRife);
	
	public Policy getPolicy(int id);

}
