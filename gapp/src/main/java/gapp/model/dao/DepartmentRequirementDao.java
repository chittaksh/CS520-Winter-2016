package gapp.model.dao;

import java.util.List;
import gapp.model.DepartmentRequirement;

public interface DepartmentRequirementDao
{
	DepartmentRequirement getDepartmentRequirement(Integer id);
	
	List<DepartmentRequirement> getAllDepartmentRequirements();
	
	List<DepartmentRequirement> getActiveDepartmentRequirements();
	
	List<DepartmentRequirement> getDeletedDepartmentRequirements();
	
	DepartmentRequirement saveDepartmentRequirements(DepartmentRequirement departReq);
	
	boolean checkDepartmentRequirement(String strName);
}
