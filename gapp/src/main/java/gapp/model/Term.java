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
@Table(name = "term")
public class Term implements Serializable
{

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;

	@Column(name = "quarter", nullable = false)
	private String strTerm;
	
	@Column(name= "deleted", nullable = false)
	private boolean deleted;
	
	@OneToMany(mappedBy="term", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Application> application;

	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public String getStrTerm()
	{
		return strTerm;
	}

	public void setStrTerm(String strTerm)
	{
		this.strTerm = strTerm;
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