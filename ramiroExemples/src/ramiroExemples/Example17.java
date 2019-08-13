package ramiroExemples;

public class Example17 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] a= {'a', 'b', 'c'};
		System.out.println(a.toString());
		System.out.println(String.valueOf(a));
		System.out.println(new String(a));
		String s = "bonjour";
		System.out.println(s.valueOf(a)); //is not a good pratice
		System.out.println(s);
	}
}