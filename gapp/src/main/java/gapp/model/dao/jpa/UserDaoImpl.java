package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.User;
import gapp.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUser(Integer id)
	{

		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getAllUsers()
	{
		return entityManager.createQuery("from User order by id", User.class)
				.getResultList();
	}

	@Override
	public boolean checkEmail(String eMail)
	{
		List<User> users = entityManager
				.createQuery("from User where strEmail = :email order by id",
						User.class)
				.setParameter("email", eMail.toLowerCase()).getResultList();

		if (users.size() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public User getUserByEmail(String eMail)
	{
		return entityManager
				.createQuery("from User where strEmail = :email order by id",
						User.class)
				.setParameter("email", eMail.toLowerCase()).getSingleResult();
	}

	@Override
	@Transactional
	public User saveUser(User user)
	{
		return entityManager.merge(user);
	}

	@Override
	public List<User> getActiveUsers()
	{
		return entityManager.createQuery("from User where enabled = true order by id", User.class)
				.getResultList();
	}

	@Override
	public List<User> getDeletedUsers()
	{
		return entityManager.createQuery("from User where enabled = false order by id", User.class)
				.getResultList();
	}

}
