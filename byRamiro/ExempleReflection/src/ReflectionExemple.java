import java.lang.reflect.Field;

public class ReflectionExemple {

	public static void main(String[] args) throws Exception, RuntimeException{
		// TODO Auto-generated method stub
		String s1 = "John";  
		String s2 = "John"; 
		String s3= new String("John");
		char[]c ={'J','o','h','n'};
		String s4= new String(c);
		System.out.println("John");
		System.out.println("s1 = "+s1); 
		System.out.println("s2 = "+s2); 
		System.out.println("s3 = "+s3);
		System.out.println("s4 = "+s4);

		Field field = String.class.getDeclaredField("value");  
		field.setAccessible(true);  
		char[] value = (char[])field.get("John");  
		value[0] = 'M';  
		value[1] = 'a';  
		value[2] = 'r';  
		value[3] = 'y';  		  

		System.out.println("John");
		System.out.println("s1 = "+s1); 
		System.out.println("s2 = "+s2); 
		System.out.println("s3 = "+s3);
		System.out.println("s4 = "+s4);	
		
//		char[] value2 = (char[])field.get("Jean");  
//		value2[0] = 'M';  
//		value2[1] = 'a';  
//		value2[2] = 'r';  
//		value2[3] = 'y';  
//		System.out.println("Jean");

	}

}
