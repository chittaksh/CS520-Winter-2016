package gapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer intId;
    
    @Column(name="name", nullable = false)
    private String strName;

    @Column(name="type", nullable=false)
    private String strType;

    @Column(name="data", nullable=false)
    private byte[] fileData;

    @Column(name="uploadDate",nullable = false)
    private Date uploadDate;
    
    @Column(name="comment", nullable=false)
    private String strComment;
    
    @ManyToOne(optional=true,cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private AcademicBackground academic;
    
    @ManyToOne(optional=true,cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private DepartmentReqValue deptReqFile;

	public Integer getIntId()
	{
		return intId;
	}

	public void setIntId(Integer intId)
	{
		this.intId = intId;
	}

	public String getStrName()
	{
		return strName;
	}

	public void setStrName(String strName)
	{
		this.strName = strName;
	}

	public String getStrType()
	{
		return strType;
	}

	public void setStrType(String strType)
	{
		this.strType = strType;
	}

	public byte[] getFileData()
	{
		return fileData;
	}

	public void setFileData(byte[] fileData)
	{
		this.fileData = fileData;
	}

	public Date getUploadDate()
	{
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate)
	{
		this.uploadDate = uploadDate;
	}

	public String getStrComment()
	{
		return strComment;
	}

	public void setStrComment(String strComment)
	{
		this.strComment = strComment;
	}

	public AcademicBackground getAcademic()
	{
		return academic;
	}

	public void setAcademic(AcademicBackground academic)
	{
		this.academic = academic;
	}

	public DepartmentReqValue getDeptReqFile()
	{
		return deptReqFile;
	}

	public void setDeptReqFile(DepartmentReqValue deptReqFile)
	{
		this.deptReqFile = deptReqFile;
	}
}
