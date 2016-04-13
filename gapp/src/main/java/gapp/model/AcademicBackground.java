package gapp.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "academic_background")
public class AcademicBackground implements Serializable
{

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;

	@ManyToOne(optional = false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Application application;

	@Column(name = "college", nullable = false)
	private String strCollege;

	@Column(name = "university", nullable = false)
	private String strUniversity;

	@Column(name = "degree", nullable = false)
	private String strDegree;

	@Column(name = "started", nullable = false)
	private Date startedOn;

	@Column(name = "ended", nullable = false)
	private Date endDate;
	
	@Column(name="gpa")
	private double dbGpa;
	
	@OneToMany(mappedBy="academic", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<File> fileTranscript;

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

	public String getStrCollege()
	{
		return strCollege;
	}

	public void setStrCollege(String strCollege)
	{
		this.strCollege = strCollege;
	}

	public String getStrUniversity()
	{
		return strUniversity;
	}

	public void setStrUniversity(String strUniversity)
	{
		this.strUniversity = strUniversity;
	}

	public String getStrDegree()
	{
		return strDegree;
	}

	public void setStrDegree(String strDegree)
	{
		this.strDegree = strDegree;
	}

	public Date getStartedOn()
	{
		return startedOn;
	}

	public void setStartedOn(Date startedOn)
	{
		this.startedOn = startedOn;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public double getDbGpa()
	{
		return dbGpa;
	}

	public void setDbGpa(double dbGpa)
	{
		this.dbGpa = dbGpa;
	}

	public List<File> getFileTranscript()
	{
		return fileTranscript;
	}

	public void setFileTranscript(List<File> fileTranscript)
	{
		this.fileTranscript = fileTranscript;
	}
}
