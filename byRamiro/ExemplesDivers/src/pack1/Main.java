package pack1;

public class Main {

	public static int add2(int x) throws RuntimeException {
		if (x == 3) {
			throw new RuntimeException();
		}
		return x + 2;
	}

	public static int add1(int x) throws Exception {
		return x + 1;
	}

	public static void main(String[] args) {
//===================================================		
		try {
			int a = 5 / 0;
		} catch (Exception e) {
			System.out.println("Impossible diviser par zéro");
		}
// ===================================================
		try {
			int a[]  = new int[] {1,2};
			System.out.println(a[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of range");
		}
//===================================================		
		try {
			System.out.println(add1(4));
		} catch (Exception e) {
		}
//===================================================				
		try {
			System.out.println(add2(3));
		} catch (RuntimeException e) {
//			e.printStackTrace();
			System.out.println("Bonjour 1");
		}
		System.out.println("Bonjour 2");
	}

}
