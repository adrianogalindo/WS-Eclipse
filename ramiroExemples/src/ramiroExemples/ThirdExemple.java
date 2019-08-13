package ramiroExemples;

public class ThirdExemple {
		int data;

		ThirdExemple(int data) {
			this.data = data;
		}

		int getData() {
			return data;
		}

		void setData(int data) {
			this.data = data;
		}


	static void f1(ThirdExemple n) {
		n.setData(n.getData() + 1);
	}

	public static void main(String[] args) {
		ThirdExemple a1 = new ThirdExemple(5);
		f1(a1);
		System.out.println("a1 = " + a1.getData());

	}
	

	
	

	


	
	
	
	
}
