package it.estia.entity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.estia.entity.Policy;
import it.estia.entity.User;
import it.estia.entity.dao.PolicyDAO;
import it.estia.entity.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService
{
	@Autowired
	private PolicyDAO policyDao;
	
	@Override
	@Transactional
	public void addPolicy(Policy policyToAdd)
	{
		policyDao.addPolicy(policyToAdd);
	}

	@Override
	@Transactional
	public List<Policy> getPolicyList(User userRife) {
		
		return policyDao.getPolicyList(userRife);
	}

	@Override
	@Transactional
	public Policy getPolicy(int id)
	{
		
		return policyDao.getPolicy(id);
	}

}
