package org.hy.commons.example.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="t_special")
public class Special {
	public Special() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Special(int id) {
		super();
		this.id = id;
	}
	private int id;
	private String name;
	private String type;
	private Set<Classroom> classroom;
	
	public Special(String name, String type) {
		this.name=name;
		this.type=type;
	}
	@Id
	@GeneratedValue
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@OneToMany(mappedBy="special")
	//@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<Classroom> getClassroom() {
		return classroom;
	}
	public void setClassroom(Set<Classroom> classroom) {
		this.classroom = classroom;
	}
	
	
}
