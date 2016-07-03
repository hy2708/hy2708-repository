package org.hy.commons.lang.example.entity;

import java.util.Date;
import java.util.LinkedList;


public class Employee {

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", bornDate=" + bornDate
				+ ", hireDate=" + hireDate + ", inputDate=" + inputDate
				+ ", updateDate=" + updateDate + ", contact=" + contact + "]";
	}

	private Integer id=null;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String name;
	
	//出生日期
	private Date bornDate;
	
	
	//雇佣日期
	private  Date hireDate;
	
	//录入时间
	private Date inputDate = new Date();
	
	//修改时间
	private Date updateDate = inputDate;
	
	Contact contact =null;
	
	LinkedList<Contact> contacts= new LinkedList<Contact>();

	public LinkedList<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(LinkedList<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
}

class Contact{
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	Integer id =null;
	String email=null;
}
