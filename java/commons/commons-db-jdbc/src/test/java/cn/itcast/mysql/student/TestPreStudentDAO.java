package cn.itcast.mysql.student;

import java.util.List;

import org.junit.Test;

/**
 * 测试StudentDao类
 * 
 * @author Administrator
 * 
 */
public class TestPreStudentDAO {

	@Test
	public void testSaveStudent() {
		PreStudentDao dao = new PreStudentDao();
		Student s = new Student();
		s.setId(1);
		s.setName("张一");
		s.setSex("女");
		s.setGrade(61);
		dao.saveStudent(s);
	}

	@Test
	public void testUpdateStudent() {
		PreStudentDao dao = new PreStudentDao();
		Student s = new Student();
		s.setId(3);
		s.setName("小黄");
		s.setSex("女");
		s.setGrade(64);
		dao.updateStudent(s);
	}

	@Test
	public void testDeleteStudentById() {
		PreStudentDao dao = new PreStudentDao();
		int id = 3;
		dao.deleteStudentById(id);
	}

	@Test
	public void testDeleteAllStudents() {
		PreStudentDao dao = new PreStudentDao();
		dao.deleteAllStudents();
	}

	@Test
	public void testFindStudentById() {
		int id = 2;
		PreStudentDao dao = new PreStudentDao();
		Student s = dao.findStudentById(id);
		System.out.println("id=" + s.getId() + " name=" + s.getName() + " sex=" + s.getSex()
				+ " grade=" + s.getGrade());
	}
	
	@Test
	public void testFindAllStudents() {
		PreStudentDao dao = new PreStudentDao();
		List<Student> list = dao.findAllStudents();
		for(Student s : list) {
			System.out.println("id=" + s.getId() + " name=" + s.getName() + " sex=" + s.getSex()
					+ " grade=" + s.getGrade());
		}
	}
}




