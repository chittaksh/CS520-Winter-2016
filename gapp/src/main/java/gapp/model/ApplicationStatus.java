package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "app_status")
public class ApplicationStatus implements Serializable
{

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;

	@Column(name = "status_name", nullable = false)
	private String strAppStatus;
	
	@Column(name="deleted", nullable = false)
	private boolean deleted;
	
	@OneToMany(mappedBy="applicationStatus",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<ApplicationLog> applicationLog;

	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public String getStrAppStatus()
	{
		return strAppStatus;
	}

	public void setStrAppStatus(String strAppStatus)
	{
		this.strAppStatus = strAppStatus;
	}

	public List<ApplicationLog> getApplicationLog()
	{
		return applicationLog;
	}

	public void setApplicationLog(List<ApplicationLog> applicationLog)
	{
		this.applicationLog = applicationLog;
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
