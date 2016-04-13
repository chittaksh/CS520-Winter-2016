package gapp.model.dao;

import java.util.List;
import gapp.model.Gender;

public interface GenderDao
{
	Gender getGender(Integer id);
	
	List<Gender> getAllGenders();
	
	List<Gender> getActiveGenders();
	
	List<Gender> getDeletedGenders();
	
	Gender setGender(Gender gender);
}
