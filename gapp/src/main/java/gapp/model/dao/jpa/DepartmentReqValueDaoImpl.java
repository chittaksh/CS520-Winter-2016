package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.DepartmentReqValue;
import gapp.model.DepartmentRequirement;
import gapp.model.dao.DepartmentReqValueDao;

@Repository
public class DepartmentReqValueDaoImpl implements DepartmentReqValueDao
{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public DepartmentReqValue getDepartmentReqValue(Integer id)
	{
		return entityManager.find(DepartmentReqValue.class, id);
	}

	@Override
	public List<DepartmentReqValue> getDepartmentReqValue()
	{
		return entityManager.createQuery("from DepartmentReqValue order by id" , DepartmentReqValue.class).getResultList();
	}

	@Override
	@Transactional
	public DepartmentReqValue setDepartmentReqValue(
			DepartmentReqValue departmentReqValue)
	{
		return entityManager.merge(departmentReqValue);
	}

}
