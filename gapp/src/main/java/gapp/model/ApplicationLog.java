package gapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "application_log")
public class ApplicationLog implements Serializable
{
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;

	@OneToOne
	private Application application;
	
	@ManyToOne
	private ApplicationStatus applicationStatus;
	
	@ManyToOne
	private User user;
	
	@Column(name = "change_date", nullable = false)
	private Date date;

	@Column(name = "comment")
	private String comment;

	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public Application getApplication()
	{
		return application;
	}

	public void setApplication(Application application)
	{
		this.application = application;
	}

	public ApplicationStatus getApplicationStatus()
	{
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus)
	{
		this.applicationStatus = applicationStatus;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}
}
