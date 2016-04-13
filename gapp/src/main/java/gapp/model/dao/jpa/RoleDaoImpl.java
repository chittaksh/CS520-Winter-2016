package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Program;
import gapp.model.Role;
import gapp.model.dao.RoleDao;

@Repository
public class RoleDaoImpl implements RoleDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Role getRole(Integer id)
	{
		return entityManager.find(Role.class, id);
	}

	@Override
	public List<Role> getAllRoles()
	{
		return entityManager.createQuery("from Role order by id", Role.class).getResultList();
	}

	@Override
	public List<Role> getActiveRoles()
	{
		return entityManager.createQuery("from Role where deleted = false order by id", Role.class).getResultList();
	}

	@Override
	public List<Role> getDeletedRoles()
	{
		return entityManager.createQuery("from Role where deleted = true order by id", Role.class).getResultList();
	}

	@Override
	@Transactional
	public Role setRole(Role role)
	{
		return entityManager.merge(role);
	}

}
