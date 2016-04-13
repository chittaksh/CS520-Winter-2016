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
@Table(name = "roles")
public class Role implements Serializable{

	public static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="id")
    private Integer intRoleId;

	@Column(name="role_name", nullable=false)
	private String strRole;
	
	@Column(name="deleted", nullable = false)
	private boolean deleted;
	
	@OneToMany(mappedBy="role",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<User> users;

	public Integer getIntRoleId()
	{
		return intRoleId;
	}

	public void setIntRoleId(Integer intRoleId)
	{
		this.intRoleId = intRoleId;
	}

	public String getStrRole()
	{
		return strRole;
	}

	public void setStrRole(String strRole)
	{
		this.strRole = strRole;
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}
}
