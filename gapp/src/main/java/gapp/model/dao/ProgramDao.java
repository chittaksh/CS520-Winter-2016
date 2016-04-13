package gapp.model.dao;

import java.util.List;
import gapp.model.Program;

public interface ProgramDao
{
	Program getProgram(Integer id);
	
	Program getProgramByDepartmentAndName(Integer deptId, String strName);
	
	List<Program> getAllPrograms();
	
	List<Program> getActivePrograms();
	
	List<Program> getDeletedPrograms();
	
	Program saveProgram(Program prog);
	
	boolean checkProgram(String strName);
}
