package gapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements Serializable
{
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int intId;

	@Column(name = "country_name", nullable = false)
	private String strCountryName;
	
	@Column(name="deleted", nullable = false)
	private boolean deleted;

	public int getIntId()
	{
		return intId;
	}

	public void setIntId(int intId)
	{
		this.intId = intId;
	}

	public String getStrCountryName()
	{
		return strCountryName;
	}

	public void setStrCountryName(String strCountryName)
	{
		this.strCountryName = strCountryName;
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
