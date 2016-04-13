package gapp.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.DataType;
import gapp.model.dao.DataTypeDao;

@Repository
public class DataTypeDaoImpl implements DataTypeDao
{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public DataType getDataType(Integer id)
	{
		return entityManager.find(DataType.class, id);
	}

	@Override
	public List<DataType> getAllDataTypes()
	{
		return entityManager.createQuery("from DataType order by id", DataType.class).getResultList();
	}

	@Override
	public DataType setDataTypes(DataType dataType)
	{
		return entityManager.merge(dataType);
	}

	@Override
	public List<DataType> getActiveDataTypes()
	{
		return entityManager.createQuery("from DataType where deleted = false order by id", DataType.class).getResultList();
	}

	@Override
	@Transactional
	public List<DataType> getDeletedDataTypes()
	{
		return entityManager.createQuery("from DataType where deleted = true order by id", DataType.class).getResultList();
	}
	
}
