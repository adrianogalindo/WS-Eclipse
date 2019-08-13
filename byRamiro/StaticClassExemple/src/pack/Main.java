package pack;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(Outter.b);
		
		Outter v1= new Outter(); 
		Outter.A v2=v1.new A();
//		Outter.A v2=new Outter().new A();
		System.out.println(v2.getAa());
		System.out.println(v2.getAb());
		
		Outter.B v3 = new Outter.B();
		System.out.println(v3.getBb());
		
		System.out.println(Outter.getOb());
		
		int c=Integer.parseInt("12");

	}

}
