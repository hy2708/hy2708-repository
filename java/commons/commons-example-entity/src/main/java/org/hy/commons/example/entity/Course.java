package org.hy.commons.example.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.hy.enterprise.framework.jpa.core.entity.SimpleAbstractPersistentEntity;
//import com.hy.enterprise.framework.jpa.core.entity.identifier.IntegerIdentifier;

@Entity
@Table(name="t_course")
public class Course //extends IntegerIdentifier
{
	
	Set<Student> students;

	@ManyToMany(mappedBy="courses")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
