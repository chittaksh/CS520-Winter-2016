package gapp.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gapp.model.DepartmentRequirement;
import gapp.model.dao.DepartmentRequirementDao;

@Repository
public class DepartmentRequirementDaoImpl implements DepartmentRequirementDao
{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public DepartmentRequirement getDepartmentRequirement(Integer id)
	{
		return entityManager.find(DepartmentRequirement.class, id);
	}

	@Override
	public List<DepartmentRequirement> getAllDepartmentRequirements()
	{
		return entityManager
				.createQuery("from DepartmentRequirement order by id",
						DepartmentRequirement.class)
				.getResultList();
	}

	@Override
	@Transactional
	public DepartmentRequirement saveDepartmentRequirements(
			DepartmentRequirement departReq)
	{
		return entityManager.merge(departReq);
	}

	@Override
	public boolean checkDepartmentRequirement(String strName)
	{
		List<DepartmentRequirement> users = entityManager
				.createQuery(
						"from DepartmentRequirement where strField = :strName order by id",
						DepartmentRequirement.class)
				.setParameter("strName", strName.toLowerCase()).getResultList();

		if (users.size() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<DepartmentRequirement> getActiveDepartmentRequirements()
	{
		return entityManager.createQuery( "from DepartmentRequirement where deleted = false order by Id", DepartmentRequirement.class).getResultList();
	}

	@Override
	public List<DepartmentRequirement> getDeletedDepartmentRequirements()
	{
		return entityManager.createQuery("from DepartmentRequirement where deleted = true order by Id", DepartmentRequirement.class).getResultList();
	}
}
