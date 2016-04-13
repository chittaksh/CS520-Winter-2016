package gapp.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Country;
import gapp.model.dao.CountryDao;

@Repository
public class CountryDaoImpl implements CountryDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Country getCountry(Integer id)
	{
		return entityManager.find(Country.class, id);
	}

	@Override
	public List<Country> getAllCountries()
	{
		return entityManager.createQuery("from Country order by strCountryName", Country.class).getResultList();
	}

	@Override
	public List<Country> getActiveCountries()
	{
		return entityManager.createQuery("from Country where deleted = false order by strCountryName", Country.class).getResultList();
	}

	@Override
	public List<Country> getDeletedCountries()
	{
		return entityManager.createQuery("from Country where deleted = true order by strCountryName", Country.class).getResultList();
	}

	@Override
	@Transactional
	public Country setCountry(Country country)
	{
		return entityManager.merge(country);
	}
}
