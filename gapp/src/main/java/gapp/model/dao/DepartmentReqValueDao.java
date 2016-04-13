package gapp.model.dao;

import java.util.List;
import gapp.model.DepartmentReqValue;


public interface DepartmentReqValueDao
{
	DepartmentReqValue getDepartmentReqValue(Integer id);
	
	List<DepartmentReqValue> getDepartmentReqValue();
	
	DepartmentReqValue setDepartmentReqValue(DepartmentReqValue departmentReqValue);
}
