package gapp.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AcademicBackground;
import gapp.model.dao.AcademicBackgroundDao;

@Repository
public class AcademicBackgroundDaoImpl implements AcademicBackgroundDao
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public AcademicBackground getAcademicBackground(Integer Id)
	{
		return entityManager.find(AcademicBackground.class, Id);
	}

	@Override
	public List<AcademicBackground> getAcademicBackgrounds()
	{
		return entityManager.createQuery("from AcademicBackground order by id", AcademicBackground.class ).getResultList();
	}

	@Override
	@Transactional
	public AcademicBackground setAcademicBackground(
			AcademicBackground academicBackground)
	{
		return entityManager.merge(academicBackground);
	}

	@Override
	@Transactional
	public void deleteAcademicBackground(AcademicBackground academicBackground)
	{
		entityManager.remove(academicBackground);
	}

}
