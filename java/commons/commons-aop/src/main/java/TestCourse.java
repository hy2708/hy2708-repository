import java.util.*;

public class TestCourse {
	 public static void main(String[] args) {
		 Course course1 = new Course("Data Structures", null);
		 Course course2 = new Course("Database Systems", null);
		    
		 course1.addStudent("Peter Jones");
		 course1.addStudent("Brian Smith");
		 course1.addStudent("Anne Kennedy");

		 course2.addStudent("Peter Jones");
		 course2.addStudent("Steve Smith");
		    
        //��ӡcourse1�й�����		  
		 System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
		 ArrayList<String> students1 = course1.getStudents();
		 System.out.println("course1��ѧ�� �� " + students1 );
		   
		//��ӡ�й�course2������
		 System.out.println("Number of students in course2: " + course2.getNumberOfStudents());	
		 ArrayList<String> students2 = course2.getStudents();
		 System.out.println("course2��ѧ�� �� " + students2 );
		   
     }
}
