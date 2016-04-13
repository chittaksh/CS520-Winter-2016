package gapp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "dept_req_values")
public class DepartmentReqValue implements Serializable
{
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;
	
	@Column(name = "strValue")
	private String strValue;
	
	@OneToMany(mappedBy="deptReqFile", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<File> fileUpload;

	@ManyToOne(optional = false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Application application;

	@ManyToOne(optional = false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private DepartmentRequirement deptReq;

	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public String getStrValue()
	{
		return strValue;
	}

	public void setStrValue(String strValue)
	{
		this.strValue = strValue;
	}

	public List<File> getFileUpload()
	{
		return fileUpload;
	}

	public void setFileUpload(List<File> fileUpload)
	{
		this.fileUpload = fileUpload;
	}

	public Application getApplication()
	{
		return application;
	}

	public void setApplication(Application application)
	{
		this.application = application;
	}

	public DepartmentRequirement getDeptReq()
	{
		return deptReq;
	}

	public void setDeptReq(DepartmentRequirement deptReq)
	{
		this.deptReq = deptReq;
	}
}
