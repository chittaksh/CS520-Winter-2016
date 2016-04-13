package gapp.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;
import gapp.model.*;
import gapp.model.dao.*;

@Controller
@SessionAttributes("user")
@RequestMapping("student/")
public class StudentController
{
	@Autowired
	ApplicationDao applicationDao;

	@Autowired
	GenderDao genderDao;

	@Autowired
	DepartmentDao departmentDao;

	@Autowired
	TermDao termsDao;

	@Autowired
	CountryDao countryDao;

	@Autowired
	TermDao termDao;

	@Autowired
	ProgramDao programDao;

	@Autowired
	UserDao userdao;

	@Autowired
	FileDao fileDao;

	@Autowired
	DepartmentRequirementDao departReqDao;

	@Autowired
	AcademicBackgroundDao academicBackgroundDao;

	@Autowired
	DepartmentReqValueDao departmentReqValueDao;
	
	@Autowired
	ApplicationStatusDao applicationStatusDao;
	
	@Autowired
	ApplicationLogDao applicationLogDao;

	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public String home(ModelMap models)
	{
		User user = (User) models.get("user");

		List<Application> applicationList = applicationDao
				.getApplicationByUsername(user.getStrEmail());
		models.put("applicationList", applicationList);

		return "student/home";
	}

	@RequestMapping(value = "newApplicationOne.html", method = RequestMethod.GET)
	public String newApplicationOne(ModelMap models,
			@RequestParam(required = false) Integer appId)
	{
		Application application;

		if (appId == null)
		{
			application = new Application();
		}
		else
		{
			application = applicationDao.getApplication(appId);
			models.put("programss", programDao.getActivePrograms());
		}

		models.put("application", application);
		models.put("genders", genderDao.getActiveGenders());
		models.put("departments", departmentDao.getActiveDepartments());
		models.put("terms", termsDao.getActiveTerms());
		models.put("countries", countryDao.getActiveCountries());

		return "student/newApplicationOne";
	}

	@RequestMapping(value = "getPrograms.html", method = RequestMethod.GET)
	public String getPrograms(ModelMap models,
			@RequestParam("department") Integer department,
			HttpServletResponse response) throws IOException
	{
		models.put("application", models.get("application"));
		Department depart = departmentDao.getDepartment(department);
		String responseList;
		List<Program> prog = depart.getPrograms();
		List<String> strName = new ArrayList<String>();

		for (Program program : prog)
		{
			if (!program.isDeleted())
				strName.add(program.getStrProgramName());
		}

		response.setContentType("application/json");
		responseList = new Gson().toJson(strName);
		response.getWriter().write(responseList);

		return null;
	}

	@RequestMapping(value = "newApplicationOne.html", method = RequestMethod.POST)
	public String newApplicationOneSave(ModelMap models,
			@RequestParam(required = false) Integer appId,
			@ModelAttribute Application application)
	{
		User user = (User) models.get("user");
		Application app;

		if (application.getIntId() == 0)
		{
			app = application;
		}
		else
		{

			app = applicationDao.getApplication(application.getIntId());

			app.setStrStudentFname(application.getStrStudentFname());
			app.setStrStudentLname(application.getStrStudentLname());
			app.setStrEmail(application.getStrEmail());
			app.setDateDOB(application.getDateDOB());
			app.setStrCIN(application.getStrCIN());
			app.setStrPhone(application.getStrPhone());
			app.setStrToefl(application.getStrToefl());
		}
		
		app.setUser(userdao.getUser(user.getIntId()));
		app.setTerm(termDao.getTerm(application.getTerm().getIntId()));
		app.setGender(genderDao.getGender(application.getGender().getIntId()));
		app.setDepartment(
				departmentDao.getDepartment(application.getDepartment().getIntId()));
		app.setPrograms(programDao.getProgramByDepartmentAndName(
				application.getDepartment().getIntId(),
				application.getPrograms().getStrProgramName()));
		app.setCitizenship(
				countryDao.getCountry(application.getCitizenship().getIntId()));
		
		app = applicationDao.setApplication(app);
		
		ApplicationLog applicationLog = new ApplicationLog();
		applicationLog.setApplication(app);		
		applicationLog.setApplicationStatus(applicationStatusDao.getApplicationStatus(1));
		applicationLog.setDate(new Date());
		applicationLog.setUser(user);
		applicationLog.setComment("");
		
		applicationLogDao.setApplicationLog(applicationLog);

		return "redirect:newApplicationTwo.html?appId=" + app.getIntId();

	}

	@RequestMapping(value = "newApplicationTwo.html", method = RequestMethod.GET)
	public String newApplicationTwo(ModelMap models,
			@RequestParam Integer appId,
			@RequestParam(required = false) Integer intAdd)
	{
		// User user = (User)models.get("user");
		Application application = applicationDao.getApplication(appId);
		List<AcademicBackground> academicBackgroundList = application
				.getEduBackground();
		if (intAdd != null || academicBackgroundList.isEmpty())
		{
			academicBackgroundList.add(new AcademicBackground());
		}
		application.setEduBackground(academicBackgroundList);
		models.put("application", application);

		return "student/newApplicationTwo";
	}

	@RequestMapping(value = "/download.html", method = RequestMethod.GET)
	public String download(ModelMap model, HttpServletResponse response,
			@RequestParam int Id)
	{
		try
		{
			File file = fileDao.getFile(Id);
			response.setHeader("Content-Disposition",
					"inline;filename=\"" + file.getStrName() + "\"");
			OutputStream out = response.getOutputStream();

			FileCopyUtils.copy(file.getFileData(), out);
			out.flush();
			out.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "deleteDetails.html", method = RequestMethod.GET)
	public String deleteDepartmentDetails(ModelMap models,
			@RequestParam String from, @RequestParam Integer id, @RequestParam Integer appId)
	{
		switch (from)
		{
		case "education":
				AcademicBackground academicBackground = academicBackgroundDao.getAcademicBackground(id);
				fileDao.deleteFileByAcademicRecord(academicBackground);
				academicBackgroundDao.deleteAcademicBackground(academicBackground);
			break;

		}
		return "redirect:newApplicationTwo.html?appId=" + appId;
	}

	@RequestMapping(value = "newApplicationTwo.html", method = RequestMethod.POST)
	public String newApplicationTwo(ModelMap models,
			@RequestParam MultipartFile[] file,
			@ModelAttribute Application application,
			@RequestParam(required = false) Integer intAdd,
			@RequestParam Integer appId, @RequestParam String action)
					throws IOException
	{
		// User user = (User)models.get("user");
		Application appli = applicationDao.getApplication(appId);

		int index = 0;

		for (AcademicBackground academicBackground : application
				.getEduBackground())
		{
			academicBackground.setApplication(appli);
			academicBackground = academicBackgroundDao
					.setAcademicBackground(academicBackground);

			if (file[index].getSize() != 0)
			{
				File fil = new File();
				fil.setStrName(file[index].getOriginalFilename());
				fil.setStrType(file[index].getContentType());
				fil.setFileData(file[index].getBytes());
				fil.setUploadDate(new Date());
				fil.setStrComment(file[index].getOriginalFilename());
				fil.setAcademic(academicBackground);

				fileDao.setFile(fil);
			}
			index++;
		}

		application = applicationDao.getApplication(application.getIntId());

		if (!action.equalsIgnoreCase("Add New"))
		{
			return "redirect:newApplicationThree.html?appId=" + appId;
		}
		else
		{
			return "redirect:newApplicationTwo.html?appId=" + appId
					+ "&intAdd=1";
		}
	}

	@RequestMapping(value = "newApplicationThree.html", method = RequestMethod.GET)
	public String newApplicationThree(ModelMap models,
			@RequestParam Integer appId)
	{
		Application application = applicationDao.getApplication(appId);

		if (application.getDepartment().getRequirements().size() > 0)
		{
			if (application.getAppDeptReqValues().size() == 0)
			{
				List<DepartmentRequirement> fieldsRequired = application
						.getDepartment().getRequirements();
				List<DepartmentReqValue> DeptReqValues = application
						.getAppDeptReqValues();

				for (DepartmentRequirement field : fieldsRequired)
				{
					DepartmentReqValue temp = new DepartmentReqValue();
					temp.setDeptReq(field);
					temp.setApplication(application);
					DeptReqValues.add(temp);
				}
				application.setAppDeptReqValues(DeptReqValues);

				models.put("fields", fieldsRequired);
				models.put("appReqValues", DeptReqValues);
			}
			else
			{
				models.put("fields",
						application.getDepartment().getRequirements());
				models.put("appReqValues", application.getAppDeptReqValues());
			}

			models.put("application", application);

			return "student/newApplicationThree";
		}
		else
		{
			return "student/home";
		}
	}

	@RequestMapping(value = "newApplicationThree.html", method = RequestMethod.POST)
	public String newApplicationThree(ModelMap models, @RequestParam String action,
			@RequestParam Integer appId, @RequestParam MultipartFile[] file,
			@ModelAttribute Application application) throws IOException
	{
		Application appli = applicationDao.getApplication(appId);

		int index = 0;

		for (DepartmentReqValue deptReqValue : application
				.getAppDeptReqValues())
		{
			if (deptReqValue.getDeptReq().getDataType()
					.getStrDataType().equalsIgnoreCase("File"))
			{
				if (file[index].getSize() != 0)
				{
					deptReqValue.setApplication(appli);
					deptReqValue
							.setDeptReq(departReqDao.getDepartmentRequirement(
									deptReqValue.getDeptReq().getIntId()));
					deptReqValue = departmentReqValueDao.setDepartmentReqValue(deptReqValue);

					File fil = new File();
					fil.setStrName(file[index].getOriginalFilename());
					fil.setStrType(file[index].getContentType());
					fil.setFileData(file[index].getBytes());
					fil.setUploadDate(new Date());
					fil.setStrComment(file[index].getOriginalFilename());
					fil.setDeptReqFile(deptReqValue);

					fileDao.setFile(fil);
					index++;
				}
			}
			else
			{
				deptReqValue.setApplication(appli);
				deptReqValue.setDeptReq(departReqDao.getDepartmentRequirement(
						deptReqValue.getDeptReq().getIntId()));
				departmentReqValueDao.setDepartmentReqValue(deptReqValue);
			}
		}
		
		if(action.equalsIgnoreCase("Save")){

		return "redirect:home.html";
		}
		else{
			appli.setSubmitDate(new Date());
			applicationDao.setApplication(appli);
			return "redirect:home.html";
		}
	}
	
	@RequestMapping(value = "viewApplication.html", method = RequestMethod.GET)
	public String viewApplication(ModelMap models,
			@RequestParam Integer appId)
	{
		Application application = applicationDao.getApplication(appId);
		models.put("application", application);

		return "student/viewApplication";
	}

}
