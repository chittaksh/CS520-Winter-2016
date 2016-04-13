package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="application")
@Inheritance(strategy=InheritanceType.JOINED)
public class Application implements Serializable
{
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int intId;
	
	@Column(name="fname", nullable = false)
	private String strStudentFname;
	
	@Column(name="lname", nullable = false)
	private String strStudentLname;
	
	@Column(name="email", nullable=false)
	private String  strEmail;
	
	@ManyToOne(optional=false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Gender gender;

	@Column(name = "dob", nullable = false)
	private Date dateDOB;

	@Column(name = "cin", nullable = true)
	private String strCIN;

	@Column(name = "phone", nullable = false)
	private String strPhone;

	@ManyToOne(optional=false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Country citizenship;
	
	@Column(name="toefl", nullable=true)
	private int strToefl;
	
	@Column(name="submit_date", nullable = true)
	private Date submitDate;
	
	@ManyToOne(optional=false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private User user;
	
	@ManyToOne(optional = false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Department department;
	
	@ManyToOne(optional=false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Program programs;
	
	@ManyToOne(optional=false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Term term;
	
	@OneToMany(mappedBy="application", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<DepartmentReqValue> appDeptReqValues;
	
	@OneToMany(mappedBy="application",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<ApplicationLog> applicationLog;

	@OneToMany(mappedBy = "application", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<AcademicBackground> eduBackground;

	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public int getStrToefl()
	{
		return strToefl;
	}

	public void setStrToefl(int strToefl)
	{
		this.strToefl = strToefl;
	}

	public String getStrStudentFname()
	{
		return strStudentFname;
	}

	public void setStrStudentFname(String strStudentFname)
	{
		this.strStudentFname = strStudentFname;
	}

	public String getStrStudentLname()
	{
		return strStudentLname;
	}

	public void setStrStudentLname(String strStudentLname)
	{
		this.strStudentLname = strStudentLname;
	}

	public String getStrEmail()
	{
		return strEmail;
	}

	public void setStrEmail(String strEmail)
	{
		this.strEmail = strEmail;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	public Date getDateDOB()
	{
		return dateDOB;
	}

	public void setDateDOB(Date dateDOB)
	{
		this.dateDOB = dateDOB;
	}

	public String getStrCIN()
	{
		return strCIN;
	}

	public void setStrCIN(String strCIN)
	{
		this.strCIN = strCIN;
	}

	public String getStrPhone()
	{
		return strPhone;
	}

	public void setStrPhone(String strPhone)
	{
		this.strPhone = strPhone;
	}

	public Country getCitizenship()
	{
		return citizenship;
	}

	public void setCitizenship(Country citizenship)
	{
		this.citizenship = citizenship;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public Program getPrograms()
	{
		return programs;
	}

	public void setPrograms(Program programs)
	{
		this.programs = programs;
	}

	public Term getTerm()
	{
		return term;
	}

	public void setTerm(Term term)
	{
		this.term = term;
	}

	public Date getSubmitDate()
	{
		return submitDate;
	}

	public void setSubmitDate(Date submitDate)
	{
		this.submitDate = submitDate;
	}

	public List<DepartmentReqValue> getAppDeptReqValues()
	{
		return appDeptReqValues;
	}

	public void setAppDeptReqValues(List<DepartmentReqValue> appDeptReqValues)
	{
		this.appDeptReqValues = appDeptReqValues;
	}

	public List<ApplicationLog> getApplicationLog()
	{
		return applicationLog;
	}

	public void setApplicationLog(List<ApplicationLog> applicationLog)
	{
		this.applicationLog = applicationLog;
	}

	public List<AcademicBackground> getEduBackground()
	{
		return eduBackground;
	}

	public void setEduBackground(List<AcademicBackground> eduBackground)
	{
		this.eduBackground = eduBackground;
	}
 }
