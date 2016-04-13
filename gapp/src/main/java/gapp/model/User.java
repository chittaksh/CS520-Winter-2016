package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable
{

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer intId;

	@Column(name = "fname", nullable = false)
	private String strFName;

	@Column(name = "lname", nullable = false)
	private String strLName;

	@Column(name = "email", nullable = false, unique=true)
	private String strEmail;

	@Column(name = "password", nullable = false)
	private String strPassword;

	@ManyToOne(optional = false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Role role;
	
	@OneToMany(mappedBy="user", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Application> application;

	@Column(name = "enabled", nullable = false)
	private boolean enabled = true;

	public Integer getIntId()
	{
		return intId;
	}

	public void setIntId(Integer intId)
	{
		this.intId = intId;
	}

	public String getStrFName()
	{
		return strFName;
	}

	public void setStrFName(String strFName)
	{
		this.strFName = strFName;
	}

	public String getStrLName()
	{
		return strLName;
	}

	public void setStrLName(String strLName)
	{
		this.strLName = strLName;
	}

	public String getStrEmail()
	{
		return strEmail;
	}

	public void setStrEmail(String strEmail)
	{
		this.strEmail = strEmail;
	}

	public String getStrPassword()
	{
		return strPassword;
	}

	public void setStrPassword(String strPassword)
	{
		this.strPassword = strPassword;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public List<Application> getApplication()
	{
		return application;
	}

	public void setApplication(List<Application> application)
	{
		this.application = application;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
}