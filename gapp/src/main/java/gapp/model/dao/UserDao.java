package gapp.model.dao;

import java.util.List;
import gapp.model.User;

public interface UserDao
{
	User getUser(Integer id);
	
	User getUserByEmail(String eMail);
	
	User saveUser(User user);
	
	List<User> getAllUsers();
	
	List<User> getActiveUsers();
	
	List<User> getDeletedUsers();
	
	boolean checkEmail(String eMail);
}
