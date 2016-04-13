package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AcademicBackground;
import gapp.model.File;
import gapp.model.dao.FileDao;

@Repository
public class FileDaoImpl implements FileDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public File getFile(Integer Id)
	{
		return entityManager.find(File.class, Id);
	}

	@Override
	public List<File> getFiles()
	{
		return entityManager.createQuery("from File order by id", File.class).getResultList();
	}

	@Override
	@Transactional
	public File setFile(File file)
	{
		return entityManager.merge(file);
	}

	@Override
	@Transactional
	public int deleteFileByAcademicRecord(AcademicBackground academicBackground)
	{
		return entityManager.createQuery("delete File where academic = :id ").setParameter("id", academicBackground).executeUpdate();
	}

}
