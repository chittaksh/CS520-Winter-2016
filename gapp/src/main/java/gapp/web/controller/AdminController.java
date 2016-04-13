package gapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import gapp.model.Department;
import gapp.model.DepartmentRequirement;
import gapp.model.Program;
import gapp.model.dao.DataTypeDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.DepartmentRequirementDao;
import gapp.model.dao.ProgramDao;

@Controller
@SessionAttributes(value = { "user", "department" })
@RequestMapping("admin/")
public class AdminController
{

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private DepartmentRequirementDao departmentRequirementsDao;

	@Autowired
	private ProgramDao programDao;

	@Autowired
	private DataTypeDao dataTypeDao;

	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public String home(ModelMap models)
	{
		return "admin/home";
	}

	@RequestMapping(value = "departments.html", method = RequestMethod.GET)
	public String departments(ModelMap models)
	{
		models.put("departments", departmentDao.getActiveDepartments());
		return "admin/departments";
	}

	@RequestMapping(value = "editDepartment.html", method = RequestMethod.GET)
	public String editDepartment(ModelMap models,
			@RequestParam(required = false) Integer id)
	{
		if (id != null)
		{
			models.put("department", departmentDao.getDepartment(id));
		}
		else
		{
			models.put("department", new Department());
		}
		return "admin/editDepartment";
	}

	@RequestMapping(value = "editDepartment.html", method = RequestMethod.POST)
	public String editDepartment(ModelMap models,
			@RequestParam(required = false) Integer id,
			@ModelAttribute Department department)
	{
		String redirectUrl;
		if (id != null)
		{
			if (!departmentDao.checkDepartment(department.getStrDepartment()))
			{
				departmentDao.saveDepartment(department);
				models.put("department", departmentDao.getDepartment(id));
				redirectUrl = "redirect:departments.html";
			}
			else
			{
				models.put("errorMessage", "Record Already Exists.");
				redirectUrl = "redirect:editDepartment.html?id="
						+ department.getIntId();
			}
		}
		else
		{
			if (!departmentDao.checkDepartment(department.getStrDepartment()))
			{
				redirectUrl = "redirect:editDepartment.html?id="
						+ departmentDao.saveDepartment(department).getIntId();
			}
			else
			{
				models.put("errorMessage", "Record Already Exists.");
				redirectUrl = "redirect:editDepartment.html?id="
						+ department.getIntId();
			}
		}
		return redirectUrl;
	}

	@RequestMapping(value = "deleteDetails.html", method = RequestMethod.GET)
	public String deleteDepartmentDetails(ModelMap models,
			@RequestParam String from, @RequestParam Integer id,
			@ModelAttribute Department department)
	{

		switch (from)
		{
		case "requirements":
			DepartmentRequirement deptReq = departmentRequirementsDao
					.getDepartmentRequirement(id);
			deptReq.setDeleted(!deptReq.isDeleted());
			departmentRequirementsDao.saveDepartmentRequirements(deptReq);
			break;

		case "program":
			Program prog = programDao.getProgram(id);
			prog.setDeleted(!prog.isDeleted());
			programDao.saveProgram(prog);
			break;

		case "department":
			Department depart = departmentDao.getDepartment(id);
			depart.setDeleted(!depart.isDeleted());
			departmentDao.saveDepartment(depart);
			break;
		}
		models.put("department", new Department());
		return "redirect:editDepartment.html?id=" + department.getIntId();
	}

	@RequestMapping(value = "editProgram.html", method = RequestMethod.GET)
	public String editDepartmentDetails(ModelMap models,
			@RequestParam Integer id,
			@RequestParam(required = false) Integer progId)
	{
		String strURL = "admin/editProgram";
		if (progId == null)
		{
			models.put("department", departmentDao.getDepartment(id));
			models.put("prog", new Program());
		}
		else
		{
			models.put("department", departmentDao.getDepartment(id));
			models.put("prog", programDao.getProgram(progId));
		}

		return strURL;
	}

	@RequestMapping(value = "editProgram.html", method = RequestMethod.POST)
	public String editDepartmentDetails(ModelMap models,
			@RequestParam Integer id,
			@RequestParam(required = false) Integer progId,
			@ModelAttribute("prog") Program prog, BindingResult result)
	{
		if (!programDao.checkProgram(prog.getStrProgramName()))
		{
			prog.setDepartment(departmentDao.getDepartment(id));
			progId = programDao.saveProgram(prog).getIntId();
		}
		else
		{
			models.put("errorMessage", "Record Already Exists.");
		}
		models.put("department", departmentDao.getDepartment(id));
		models.put("prog", new Program());

		return "admin/editProgram";
	}

	@RequestMapping(value = "editRequirement.html", method = RequestMethod.GET)
	public String editDepartmentRequirements(ModelMap models,
			@RequestParam Integer id,
			@RequestParam(required = false) Integer typeId)
	{
		if (typeId == null)
		{
			models.put("department", departmentDao.getDepartment(id));
			models.put("fileTypes", dataTypeDao.getActiveDataTypes());
			models.put("deptReq", new DepartmentRequirement());
		}
		else
		{
			models.put("department", departmentDao.getDepartment(id));
			models.put("fileTypes", dataTypeDao.getActiveDataTypes());
			models.put("deptReq",
					departmentRequirementsDao.getDepartmentRequirement(typeId));
		}

		return "admin/editRequirement";
	}

	@RequestMapping(value = "editRequirement.html", method = RequestMethod.POST)
	public String editDepartmentRequirements(ModelMap models,
			@RequestParam Integer id,
			@RequestParam(required = false) Integer deptReqId,
			@ModelAttribute("deptReq") DepartmentRequirement deptReq,
			BindingResult result)
	{
		if (!departmentRequirementsDao
				.checkDepartmentRequirement(deptReq.getStrField()))
		{
			deptReq.setDepartment(departmentDao.getDepartment(id));
			deptReq.setDataType(
					dataTypeDao.getDataType(deptReq.getDataType().getIntId()));
			deptReqId = departmentRequirementsDao
					.saveDepartmentRequirements(deptReq).getIntId();
		}
		else
		{
			models.put("errorMessage", "Record Already Exists.");
		}
		models.put("department", departmentDao.getDepartment(id));
		models.put("deptReq", new DepartmentRequirement());
		models.put("fileTypes", dataTypeDao.getActiveDataTypes());
		return "admin/editRequirement";
	}

}
