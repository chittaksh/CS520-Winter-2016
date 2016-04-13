package gapp.model.dao;

import java.util.List;
import gapp.model.ApplicationLog;;

public interface ApplicationLogDao
{
	ApplicationLog getApplicationLog(Integer Id);
	
	List<ApplicationLog> getApplicationLog();
	
	ApplicationLog setApplicationLog(ApplicationLog applicationLog);
}
