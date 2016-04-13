package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "gender")
public class Gender implements Serializable
{

	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;

	@Column(name = "gender_name", nullable = false)
	private String strGender;
	
	@Column(name="deleted",nullable = false)
	private boolean deleted;
	
	@OneToMany(mappedBy="gender", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Application> application;

	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public String getStrGender()
	{
		return strGender;
	}

	public void setStrGender(String strGender)
	{
		this.strGender = strGender;
	}

	public List<Application> getApplication()
	{
		return application;
	}

	public void setApplication(List<Application> application)
	{
		this.application = application;
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
