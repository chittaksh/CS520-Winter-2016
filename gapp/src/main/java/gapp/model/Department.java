package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import gapp.model.Program;

@Entity
@Table(name = "department")
public class Department implements Serializable
{

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;

	@OneToMany(mappedBy="department", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Application> application;

	@Column(name = "department_name", nullable = false)
	private String strDepartment;
	
	@OneToMany(mappedBy = "department", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<DepartmentRequirement> requirements;

	@OneToMany(mappedBy = "department", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Program> programs;
	
	@Column(name="deleted", nullable = false)
	private boolean deleted;

	public int getIntId()
	{
		return intId;
	}

	public List<DepartmentRequirement> getRequirements()
	{
		return requirements;
	}

	public void setRequirements(List<DepartmentRequirement> requirements)
	{
		this.requirements = requirements;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public List<Application> getApplication()
	{
		return application;
	}

	public void setApplication(List<Application> application)
	{
		this.application = application;
	}

	public String getStrDepartment()
	{
		return strDepartment;
	}

	public void setStrDepartment(String strDepartment)
	{
		this.strDepartment = strDepartment;
	}

	public List<Program> getPrograms()
	{
		return programs;
	}

	public void setPrograms(List<Program> programs)
	{
		this.programs = programs;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}
}
