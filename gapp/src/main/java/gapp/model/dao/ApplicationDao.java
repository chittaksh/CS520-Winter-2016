package gapp.model.dao;

import java.util.List;
import gapp.model.Application;

public interface ApplicationDao
{	
	Application getApplication(Integer id);
	
	List<Application> getApplicationByDepartmentAndTerm(String dept, String term);
	
	List<Application> getApplicationByUsername(String username);
	
	Application setApplication(Application application);
}
