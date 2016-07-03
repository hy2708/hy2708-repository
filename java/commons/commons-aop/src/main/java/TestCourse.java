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
		    
        //打印course1有关内容		  
		 System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
		 ArrayList<String> students1 = course1.getStudents();
		 System.out.println("course1的学生 ： " + students1 );
		   
		//打印有关course2的内容
		 System.out.println("Number of students in course2: " + course2.getNumberOfStudents());	
		 ArrayList<String> students2 = course2.getStudents();
		 System.out.println("course2的学生 ： " + students2 );
		   
     }
}
