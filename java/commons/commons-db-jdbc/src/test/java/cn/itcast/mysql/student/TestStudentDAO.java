package cn.itcast.mysql.student;

import java.util.List;

import org.junit.Test;

/**
 * 测试StudentDao类
 * 
 * @author Administrator
 * 
 */
public class TestStudentDAO {

	@Test
	public void testSaveStudent() {
		StudentDAO dao = new StudentDAO();
		Student s = new Student();
		s.setId(3);
		s.setName("张四");
		s.setSex("女");
		s.setGrade(61);
		dao.saveStudent(s);
	}

	@Test
	public void testUpdateStudent() {
		StudentDAO dao = new StudentDAO();
		Student s = new Student();
		s.setId(1);
		s.setName("小黄");
		s.setSex("女");
		s.setGrade(64);
		dao.updateStudent(s);
	}

	@Test
	public void testDeleteStudentById() {
		StudentDAO dao = new StudentDAO();
		int id = 1;
		dao.deleteStudentById(id);
	}

	@Test
	public void testDeleteAllStudents() {
		StudentDAO dao = new StudentDAO();
		dao.deleteAllStudents();
	}

	@Test
	public void testFindStudentById() {
		int id = 2;
		StudentDAO dao = new StudentDAO();
		Student s = dao.findStudentById(id);
		System.out.println("id=" + s.getId() + " name=" + s.getName() + " sex=" + s.getSex()
				+ " grade=" + s.getGrade());
	}
	
	@Test
	public void testFindAllStudents() {
		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.findAllStudents();
		for(Student s : list) {
			System.out.println("id=" + s.getId() + " name=" + s.getName() + " sex=" + s.getSex()
					+ " grade=" + s.getGrade());
		}
	}
}




