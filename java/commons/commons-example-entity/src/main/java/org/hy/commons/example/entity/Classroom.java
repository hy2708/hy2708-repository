package org.hy.commons.example.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;

//import com.hy.enterprise.framework.jpa.core.entity.SimpleAbstractPersistentEntity;
//import com.hy.enterprise.framework.jpa.core.entity.identifier.Identifier;
//import com.hy.enterprise.framework.jpa.core.entity.identifier.IntegerIdentifier;
//import com.hy.enterprise.framework.jpa.core.entity.util.StringIdentifier;

@Entity
@Table(name="t_classroom")
public class Classroom //extends IntegerIdentifier
{
	
	public Classroom() {
		super();
	}
	
	public Classroom(int id) {
		super();
		id = id;
	}

	public Classroom( String name, int grade,
			Special special) {
		super();
		
		this.name = name;
		this.grade = grade;
		this.special = special;
	}

	Set<Student> students;
	String name =null;
	private int grade;
	
	private Special special;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@ManyToOne
	@JoinColumn(name="special_id")
	public Special getSpecial() {
		return special;
	}

	public void setSpecial(Special special) {
		this.special = special;
	}

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 通过onetomany注解,得到
	 得到方法名称
	 然后分别在iEntityDao中entityDao中创建findXxxx方法
	 然后分别在iEntityDao中entityDao中创建findXxxxById方法
	 */
	@OneToMany(mappedBy="classroom")
	//@LazyCollection(LazyCollectionOption.EXTRA)
	//@Transient
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
