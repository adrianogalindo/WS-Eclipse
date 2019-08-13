package ramiroExemples;



public class SecondExemple {
	
	static void f1(Integer n) {
		n=n+1;
	}
	
	static void f2(int[] n) {
		n[0]=n[0]+1;
	}
	
	static void f3(Integer n) {
		n=n+1;
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3};
		int[] b = {4,5};
		
		b = a;
		
		System.out.println("lenght of b = " + b.length);
		for (int i = 0; i<b.length; i++) {
			System.out.println(" b[" + i + "] = " + b[i]);
			
			
			int a1 = 5;
			f1(a1);
			System.out.println("a1 = " + a1);
			
			int a2[] = {5};
			f2(a2);
			System.out.println("a2 = " + a2[0]);
			
			Integer a3 = 5;
			f3(a3);
			System.out.println("a3 = " + a3);
			
			String s = "true";
			Boolean b1 = Boolean.parseBoolean(s);
			System.out.println(b1);
			
			
			
		}			
	}
}
