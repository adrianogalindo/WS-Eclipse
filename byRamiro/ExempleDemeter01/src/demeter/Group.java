package demeter;

import java.util.*;

public class Group {
	private List<Student> students;
	
	public List<Student> students(){
		return students;
	}
	
	public int  totalOfStudents(){
		return students.size();
	}
	
	public Student findStudent(int num ){
		Student e = null; 
		boolean found=false;
		for (int i =0; (i <students.size()) && (!found); i++){
			if (num==students.get(i).getId()) {
				e=students.get(i);
				found=true;
			}
		}
		return e ; 
		
	}
	

}
