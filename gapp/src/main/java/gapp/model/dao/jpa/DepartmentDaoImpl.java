package gapp.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gapp.model.dao.DepartmentDao;
import gapp.model.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao
{
	@PersistenceContext
    private EntityManager entityManager;
    

	@Override
	public Department getDepartment(Integer id)
	{
		return entityManager.find(Department.class, id);
	}
	
    @Override
    public List<Department> getAllDepartments()
    {
        return entityManager.createQuery( "from Department order by id", Department.class )
            .getResultList();
    }

	@Override
	@Transactional
	public Department saveDepartment(Department dept)
	{
		return entityManager.merge(dept);
	}

	@Override
	public boolean checkDepartment(String strName)
	{
		/*List<Department> users = entityManager
				.createQuery(
						"from Departments where strDepartment = :strName order by id",
						Department.class)
				.setParameter("strName", strName.toLowerCase()).getResultList();

		if (users.size() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}*/
		
		return false;
	}

	@Override
	public List<Department> getActiveDepartments()
	{
		return entityManager.createQuery("from Department where deleted = false order by Id", Department.class).getResultList();
	}

	@Override
	public List<Department> getDeletedDepartments()
	{
		return entityManager.createQuery("from Department where deleted = true order by Id", Department.class).getResultList();
	}
}
