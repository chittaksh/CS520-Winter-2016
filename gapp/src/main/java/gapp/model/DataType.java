package gapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="data_types")
public class DataType implements Serializable
{

	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int intId;
	
	@Column(name="data_type", nullable=false)
	private String strDataType;
	
	@Column(name= "deleted", nullable= false)
	private boolean deleted;

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}

	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public String getStrDataType()
	{
		return strDataType;
	}

	public void setStrDataType(String strDataType)
	{
		this.strDataType = strDataType;
	}

}
