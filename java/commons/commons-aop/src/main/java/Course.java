import java.util.ArrayList;

public class Course {
	private String courseName;
	private int numberOfStudents;
	ArrayList<String> students = new ArrayList<String>();
	
	public Course(String student, String courseName){
		this.courseName = courseName;
	}

	//�����Ա������ѧ��
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
	
	//ɾ�����Ա��ĳЩѧ��
	public void dropStudent(String student){

	}
}