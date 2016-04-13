package gapp.model.dao;

import java.util.List;
import gapp.model.Role;

public interface RoleDao
{
	Role getRole(Integer id);
	
	List<Role> getAllRoles();
	
	List<Role> getActiveRoles();
	
	List<Role> getDeletedRoles();
	
	Role setRole(Role role);
}
