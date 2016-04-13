package gapp.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gapp.model.Program;
import gapp.model.dao.ProgramDao;

@Repository
public class ProgramDaoImpl implements ProgramDao
{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Program getProgram(Integer id)
	{
		return entityManager.find(Program.class, id);
	}

	@Override
	public List<Program> getAllPrograms()
	{
		return entityManager.createQuery("from Program order by id",Program.class).getResultList();
	}

	@Override
	@Transactional
	public Program saveProgram(Program prog)
	{
		return entityManager.merge(prog);
	}

	@Override
	public boolean checkProgram(String strName)
	{
		List<Program> users = entityManager
				.createQuery(
						"from Program where strProgramName = :strName order by id",
						Program.class)
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
	public List<Program> getActivePrograms()
	{
		return entityManager.createQuery("from Program where deleted = false order by id",Program.class).getResultList();
	}

	@Override
	public List<Program> getDeletedPrograms()
	{
		return entityManager.createQuery("from Program where deleted = true order by id",Program.class).getResultList();
	}

	@Override
	public Program getProgramByDepartmentAndName(Integer deptId, String strName)
	{
		return entityManager.createQuery("from Program where department.intId= :deptId and strProgramName= :strName",Program.class).setParameter("deptId", deptId).setParameter("strName", strName).getSingleResult();
	}
	
	
}
