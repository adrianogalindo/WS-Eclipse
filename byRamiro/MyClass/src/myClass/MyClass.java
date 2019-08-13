package myClass;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
	
	private String data;
	public String getData() {
		return this.data;
	} 
	
	private static List<MyClass> list =new ArrayList<MyClass>(); 
	 
	public MyClass(String data) {
		this.data=data; 
		list.add(this);
	}
	
	public static MyClass getObjets(int i) {
		return list.get(i);
	}
	
	public static int countObjets() {
		return list.size();
	}
	
	
	
	

}
