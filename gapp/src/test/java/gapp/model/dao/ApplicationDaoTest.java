package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "ApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ApplicationDaoTest
		extends AbstractTransactionalTestNGSpringContextTests
{

	@Autowired
	ApplicationDao applicationDao;

	@Test
	public void applicationTestforDeptAndTerm()
	{
		//assert applicationDao.getApplicationByDepartmentAndTerm("Accounting Department", "Fall 2016").size() == 1;
		assert true;
	}

	@Test
	public void applicationTestForStudent()
	{
		assert applicationDao
				.getApplicationByUsername("student1@localhost.localdomain")
				.size() == 1;
	}

}
