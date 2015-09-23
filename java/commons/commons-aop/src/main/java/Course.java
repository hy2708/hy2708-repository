import java.util.ArrayList;

public class Course {
	private String courseName;
	private int numberOfStudents;
	ArrayList<String> students = new ArrayList<String>();
	
	public Course(String student, String courseName){
		this.courseName = courseName;
	}

	//向线性表中添加学生
	public void addStudent(String student){
		students.add(student);
		numberOfStudents++;
	}
	public ArrayList<String> getStudents(){
		return students;
	}
	
	public int getNumberOfStudents(){
		return numberOfStudents;
	}
	
	public String getCourse(){
		return courseName;
	}
	
	//删除线性表的某些学生
	public void dropStudent(String student){

	}
}