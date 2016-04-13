package gapp.model.dao;

import java.util.List;
import gapp.model.Country;

public interface CountryDao
{
	Country getCountry(Integer id);
	
	List<Country> getAllCountries();
	
	List<Country> getActiveCountries();
	
	List<Country> getDeletedCountries();
	
	Country setCountry(Country country);
}
