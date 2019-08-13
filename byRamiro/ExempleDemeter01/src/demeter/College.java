package demeter;

import java.util.List;

public class College {
	private List<Course> courses;
	
	public List<Course> courses(){
		return courses;
	}

//	public int totalOfStudents() {
//		int r=0;
//		for (Course c : courses) {
//			for (Group g : c.groups()) {
//				for (Student e: g.students()) {
//					r++;
//				}
//			}	
//		}	
//		return r;
//	}
	
	public int  totalOfStudents(){
		int r=0;
		for (Course c : courses){
			r=r+c.totalOfStudents();
		}
		return r;
	}
	
//	public Student findStudent(int num) {
//		Student e = null; 
//		boolean found=false;
//		for (int i =0; (i <courses.size()) && (!found); i++) {
//			for (int j =0; (j <courses.get(i).groups().size()) && (!found); j++) {
//				for (int k =0; (k <courses.get(i).groups().get(j).students().size()) && (!found); j++) {
//					Student ec=courses.get(i).groups().get(j).students().get(k);
//					if (num==ec.getId()) {
//						e=ec;
//						found=true;
//					}
//				}
//			}
//		}
//		
//		return e; 
//	}
		
		public Student findStudent(int num ){
			Student e = null;
			for (int i =0; (i <courses.size()) && (e==null); i++){
				e=courses.get(i).findStudent(num);	
			}
			return e ; 		
		}
		
		
}
