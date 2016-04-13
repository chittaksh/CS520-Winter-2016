package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.ApplicationStatus;
import gapp.model.dao.ApplicationStatusDao;

@Repository
public class ApplicationStatusDaoImpl implements ApplicationStatusDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ApplicationStatus getApplicationStatus(Integer Id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ApplicationStatus> getApplicationStatus()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ApplicationStatus setApplicationStatus(
			ApplicationStatus applicationStatus)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
