package singleton;

public class Singleton {
	private int data ;
	private static Singleton INSTANCE= new Singleton();
	private Singleton() {
		this.data=0;
	}
	public static Singleton getINSTANCE() {
		return INSTANCE;
	}
	public int getData() {
		return this.data;
	}
	public void setData(int data) {
		this.data=data;
	}

}
