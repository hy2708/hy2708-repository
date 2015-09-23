package org.hy.commons.example.entity;

import java.util.Set;
import java.util.jar.Attributes.Name;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.hy.enterprise.framework.jpa.core.entity.SimpleAbstractPersistentEntity;
//import com.hy.enterprise.framework.jpa.core.entity.identifier.IntegerIdentifier;

//@Entity
//@Table(name="t_student")
public class Student //extends IntegerIdentifier
{
	
	
	public Student() {
		super();
	}
	public Student(String name,String sex, Classroom classroom) {
		super();
		this.name = name;
		this.classroom = classroom;
		this.sex = sex;
	}
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	String name ;
	Classroom classroom; 
	Set<Course> courses;

	private String sex;
	
//	Long id=null;
	Integer id=null;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToMany()
	@JoinTable(
			name="t_student_course",
			joinColumns={@JoinColumn(name="student_id")},
			inverseJoinColumns={@JoinColumn(name="course_id")}
	)
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	 通过manytoone注解,得到
	 得到方法名称
	 然后分别在iEntityDao中entityDao中创建findXxxx方法
	 然后分别在iEntityDao中entityDao中创建findXxxxById方法
	内部实现是，createQuery(select O from ${Xxx} )
	
	 */
	//双向关联,只在多的一端维护,就好
	@ManyToOne//(cascade=CascadeType.PERSIST)
	@JoinColumn(name="classroom_id")
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
}
