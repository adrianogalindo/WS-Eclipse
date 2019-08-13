package pack1;

public class Main2 {
	
	public static int add2(int x) throws Exception {
		if (x==3) {
			throw new RuntimeException();
		}
		if (x==5) {
			throw new Exception();
		}
		return x+2;
	}

	public static void main(String[] args) {
		
		try {
			System.out.println(add2(5));
		} 
		catch (RuntimeException e) {
			System.out.println("Il ya eu une RuntimeException");		
		}
		catch (Exception e) {
			System.out.println("Il ya eu une Exception");		
		}
	}

}
