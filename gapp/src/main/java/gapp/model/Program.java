package gapp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "programs")
public class Program implements Serializable
{

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;

	@Column(name = "program_name", nullable = false)
	private String strProgramName;
	
	@Column(name="deleted", nullable = false)
	private boolean deleted;

	@ManyToOne(optional = false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Department department;
	
	@OneToMany(mappedBy="programs", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Application> application;

	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public String getStrProgramName()
	{
		return strProgramName;
	}

	public void setStrProgramName(String strProgramName)
	{
		this.strProgramName = strProgramName;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}

	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public List<Application> getApplication()
	{
		return application;
	}

	public void setApplication(List<Application> application)
	{
		this.application = application;
	}
}
