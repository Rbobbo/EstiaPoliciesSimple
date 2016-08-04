package it.estia.entity.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import it.estia.entity.Policy;
import it.estia.entity.User;
import it.estia.entity.dao.DaoAbstract;
import it.estia.entity.dao.PolicyDAO;

@Transactional
public class PolicyDAOImpl extends DaoAbstract implements PolicyDAO
{
	private static final Logger logger = LoggerFactory.getLogger(PolicyDAOImpl.class);
	
	@Override
	public Policy addPolicy(Policy policyToAdd)
	{
		logger.info("Entered in addPolicy {}",policyToAdd);
		getSessionLocal().persist(policyToAdd);
		
		logger.info("Return addPolicy {}", policyToAdd);
		return policyToAdd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Policy> getPolicyList(User userRife)
	{
		logger.info("Entered in getPolicyList {}",userRife);
		
		List<Policy> result = new ArrayList<>();
		int userid = userRife.getId();
		result = getSessionLocal().createQuery("from Policy where userid = ?")
				.setParameter(0, userid).list();

		logger.info("Return getPolicyList {}", result);
		return result;
	}

	@Override
	public Policy getPolicy(int id)
	{
		logger.info("Entered in getPolicy {}",id);
		
		Policy result = new Policy();
		result = (Policy) getSessionLocal().createQuery("from Policy where id = ?").
						setParameter(0, id).uniqueResult();
		
		logger.info("Return getPolicy {}", result);
		return result;
	}

}
