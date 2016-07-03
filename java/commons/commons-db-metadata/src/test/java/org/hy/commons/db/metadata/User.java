package org.hy.commons.db.metadata;

import java.util.Date;

public class User {
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", status=" + status
				+ ", createTime=" + createTime + ", sex=" + sex + ", password="
				+ password + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
	}
	private int id;
	private String name;
	private String status;
	private Date createTime;
	private String sex;
	private String password;

}
