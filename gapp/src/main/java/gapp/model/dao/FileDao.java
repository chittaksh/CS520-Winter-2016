package gapp.model.dao;

import java.util.List;

import gapp.model.AcademicBackground;
import gapp.model.File;

public interface FileDao
{
	File getFile(Integer Id);
	
	List<File> getFiles();
	
	File setFile(File file);
	
	int deleteFileByAcademicRecord(AcademicBackground academicBackground);
}
