package gapp.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Gender;
import gapp.model.dao.GenderDao;

@Repository
public class GenderDaoImpl implements GenderDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Gender getGender(Integer id)
	{
		return entityManager.find(Gender.class, id);
	}

	@Override
	public List<Gender> getAllGenders()
	{
		return entityManager.createQuery("from Gender order by id", Gender.class).getResultList();
	}

	@Override
	public List<Gender> getActiveGenders()
	{
		return entityManager.createQuery("from Gender where deleted = false order by id", Gender.class).getResultList();
	}

	@Override
	public List<Gender> getDeletedGenders()
	{
		return entityManager.createQuery("from Gender where deleted = true order by id", Gender.class).getResultList();
	}

	@Override
	@Transactional
	public Gender setGender(Gender gender)
	{
		return entityManager.merge(gender);
	}

}
