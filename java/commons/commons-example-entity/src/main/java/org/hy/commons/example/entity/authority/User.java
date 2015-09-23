package org.hy.commons.example.entity.authority;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="t_user")
public class User {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		System.err.println("000000000000000000000000000000");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	private String account;
	private Date createTime;
	private Date expireTime;
	private int id;
	private String password;
	//private Person person;
	private List<UserAndRole> userAndRoles;
	
	String username =null;
	String state =null;
	
	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}
	//@Column(length=18,nullable=false)
	public String getAccount() {
		return account;
	}
	public Date getCreateTime() {
		return createTime;
	}
	@Column(updatable=false)
	public Date getExpireTime() {
		return expireTime;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	/*@OneToOne()
	@JoinColumn(name="person_id")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}*/
	
	@OneToMany(mappedBy="user")
	public List<UserAndRole> getUserAndRoles() {
		return userAndRoles;
	}
	
	
	public void setAccount(String account) {
		this.account = account;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void setUserAndRoles(List<UserAndRole> userAndRoles) {
		this.userAndRoles = userAndRoles;
	}
}
