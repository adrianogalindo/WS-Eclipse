package demeter;

public class Student {
	private int id;
	private String name;
	
	public Student (int id, String name) {
		this.id= id;
		this.name =name;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean setId(int id ) {
		if (id >0 ) {
			this.id = id;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getName() {
		return name;
	}
	
	

}
