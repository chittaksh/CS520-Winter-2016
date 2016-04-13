package gapp.model.dao;

import java.util.List;
import gapp.model.Department;

public interface DepartmentDao
{	
	Department getDepartment(Integer id);
	
	List<Department> getAllDepartments();
	
	List<Department> getActiveDepartments();
	
	List<Department> getDeletedDepartments();
	
	Department saveDepartment(Department dept);
	
	boolean checkDepartment(String strName);
}
