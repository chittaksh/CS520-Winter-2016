package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.dao.ApplicationDao;

@Repository
public class ApplicationDaoImpl implements ApplicationDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Application> getApplicationByDepartmentAndTerm(String dept, String term){
		return entityManager.createQuery("from Application a where a.department.strDepartment = :dept AND a.term.strTerm = :term order by id" , Application.class).setParameter("dept", dept).setParameter("term", term).getResultList();
	}

	@Override
	public List<Application> getApplicationByUsername(String username)
	{
		return entityManager.createQuery("from Application a where a.user.strEmail = :username order by id", Application.class).setParameter("username", username).getResultList();
	}

	@Override
	public Application getApplication(Integer id)
	{
		return entityManager.find(Application.class, id);
	}

	@Override
	@Transactional
	public Application setApplication(Application application)
	{
		return entityManager.merge(application);
	}
}
