package it.estia.entity.service;

import java.util.List;

import it.estia.entity.Policy;
import it.estia.entity.User;

public interface PolicyService
{
	public void addPolicy(Policy policyToAdd);
	
	public List<Policy> getPolicyList(User userRife);

}
