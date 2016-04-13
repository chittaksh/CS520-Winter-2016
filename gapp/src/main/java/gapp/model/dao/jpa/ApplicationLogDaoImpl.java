package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.ApplicationLog;
import gapp.model.dao.ApplicationLogDao;

@Repository
public class ApplicationLogDaoImpl implements ApplicationLogDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ApplicationLog getApplicationLog(Integer Id)
	{
		return entityManager.find(ApplicationLog.class, Id);
	}

	@Override
	public List<ApplicationLog> getApplicationLog()
	{
		return entityManager.createQuery("from ApplicationLog order by Id",ApplicationLog.class).getResultList();
	}

	@Override
	@Transactional
	public ApplicationLog setApplicationLog(ApplicationLog applicationLog)
	{
		return entityManager.merge(applicationLog);
	}

}
