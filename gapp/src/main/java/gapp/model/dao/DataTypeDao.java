package gapp.model.dao;

import java.util.List;
import gapp.model.DataType;

public interface DataTypeDao
{
	DataType getDataType(Integer id);
	
	List<DataType> getAllDataTypes();
	
	List<DataType> getActiveDataTypes();
	
	List<DataType> getDeletedDataTypes();
	
	DataType setDataTypes(DataType dataType);
}
