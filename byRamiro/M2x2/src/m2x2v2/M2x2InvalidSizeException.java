package m2x2v2;

@SuppressWarnings("serial")
public class M2x2InvalidSizeException extends RuntimeException {
	private int data;

	M2x2InvalidSizeException(int s) {
		this.data = s;
	}
	
	public int getSize() {return data;}
	
	public String getMessage() {
		return "Invalid size: " + data;
	}
}