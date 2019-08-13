package sereliaziation;

public class Employee implements java.io.Serializable{
	
	private static final long serialVersionID = 1L;
	
	public String name;
	public String address;
	public transient int SSN;
	public int number;

}
