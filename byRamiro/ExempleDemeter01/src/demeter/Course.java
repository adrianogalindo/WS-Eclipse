package demeter;

import java.util.List;

public class Course {
	private List<Group> groups;
	
	public List<Group> groups(){
		return groups;
	}

	public int  totalOfStudents(){
		int r=0;
		for (Group g : groups){
			r=r+g.totalOfStudents();
		}
		return r;
	}
	public Student findStudent(int num ){
		Student e = null;
		for (int i =0; (i <groups.size()) && (e==null); i++){
			e=groups.get(i).findStudent(num);	
		}
		return e ; 		
	}
	
}
