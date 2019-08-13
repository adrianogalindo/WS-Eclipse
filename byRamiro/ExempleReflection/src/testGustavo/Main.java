package testGustavo;

import java.lang.reflect.Field;


public class Main {

	public static void main(String[] args) throws Exception, RuntimeException {
		// TODO Auto-generated method stub
        MyClass mc = new MyClass();
        System.out.println(mc.getS());
        
        Field field = String.class.getDeclaredField("value");  
		field.setAccessible(true);  
		char[] value = (char[])field.get("John");  
		value[0] = 'M';  
		value[1] = 'a';  
		value[2] = 'r';  
		value[3] = 'y';  	
		
		System.out.println(mc.getS());
	}

}
