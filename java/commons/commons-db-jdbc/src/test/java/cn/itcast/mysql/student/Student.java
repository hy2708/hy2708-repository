package cn.itcast.mysql.student;

/**
 * 与student表对应的实体类
 * 
 * CREATE TABLE student( id INT PRIMARY KEY, NAME VARCHAR(21), sex CHAR(2),
 * grade DOUBLE(5,2) );
 * 
 * @author Administrator
 * 
 */
public class Student {
	private int id;
	private String name;
	private String sex;
	private double grade;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
