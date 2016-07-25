package it.estia.entity.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.estia.entity.Policy;
import it.estia.entity.User;
import it.estia.entity.dao.DaoAbstract;
import it.estia.entity.dao.PolicyDAO;

@Transactional
public class PolicyDAOImpl extends DaoAbstract implements PolicyDAO
{
	
	@Override
	public Policy addPolicy(Policy policyToAdd)
	{
		getSessionLocal().persist(policyToAdd);
		return policyToAdd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Policy> getPolicyList(User userRife) {
		
		List<Policy> result = new ArrayList<>();
		int userid = userRife.getId();
		result = getSessionLocal().createQuery("from Policy where userid = ?")
				.setParameter(0, userid).list();

		return result;
	}

}
