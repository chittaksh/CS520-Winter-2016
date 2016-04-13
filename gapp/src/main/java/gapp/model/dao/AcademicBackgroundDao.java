package gapp.model.dao;

import java.util.List;
import gapp.model.AcademicBackground;

public interface AcademicBackgroundDao
{
	AcademicBackground getAcademicBackground(Integer id);
	
	List<AcademicBackground> getAcademicBackgrounds();
	
	AcademicBackground setAcademicBackground(AcademicBackground academicBackground);
	
	void deleteAcademicBackground(AcademicBackground academicBackground);
}
