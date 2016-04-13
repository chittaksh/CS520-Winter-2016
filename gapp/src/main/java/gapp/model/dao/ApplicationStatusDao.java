package gapp.model.dao;

import java.util.List;
import gapp.model.ApplicationStatus;

public interface ApplicationStatusDao
{
	ApplicationStatus getApplicationStatus(Integer Id);
	
	List<ApplicationStatus> getApplicationStatus();
	
	ApplicationStatus setApplicationStatus(ApplicationStatus applicationStatus);
}
