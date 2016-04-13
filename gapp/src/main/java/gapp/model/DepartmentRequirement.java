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
@Table(name = "department_requirements")
public class DepartmentRequirement implements Serializable
{

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;

	@Column(name = "field_name", nullable = false)
	private String strField;

	@ManyToOne(optional = false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private DataType dataType;

	@Column(name = "required", nullable = false)
	private boolean required;
	
	@Column(name="deleted", nullable = false)
	private boolean deleted;
	
	@ManyToOne(optional = false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Department department;
	
	@OneToMany(mappedBy="deptReq", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<DepartmentReqValue> appDeptReq;


	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public List<DepartmentReqValue> getAppDeptReq()
	{
		return appDeptReq;
	}

	public void setAppDeptReq(List<DepartmentReqValue> appDeptReq)
	{
		this.appDeptReq = appDeptReq;
	}

	public String getStrField()
	{
		return strField;
	}

	public void setStrField(String strField)
	{
		this.strField = strField;
	}

	public DataType getDataType()
	{
		return dataType;
	}

	public void setDataType(DataType dataType)
	{
		this.dataType = dataType;
	}

	public boolean isRequired()
	{
		return required;
	}

	public void setRequired(boolean required)
	{
		this.required = required;
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
}
