package serialization;

public class Employee implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String name;
	public String address;
	public transient int SSN;
	public int number;

}
