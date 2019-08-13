package exception;

public class MLInvalidAccessException extends RuntimeException {

	private static final long serialVersionUID = 810243047788064113L;
	private Integer messageChoice;
	
	public MLInvalidAccessException(int i) {
		this.messageChoice = i;
	}
	
	public String getMessage() {
		String msg = "";
		switch (this.messageChoice) {
		case 1 : msg = "Invalid head() call: empty list"; break;
		case 2 : msg = "Invalid end() call: empty list"; break;
		case 11: msg = "Invalid next() call: hasNext() false"; break;
		case 12: msg = "Invalid previous() call: hasPrevious() false"; break;
		case 13: msg = "Invalid set(T v) call: undefined current position"; break;
		case 14: msg = "Invalid remove() call: undefined current position"; break;
		}
		return msg;
	}

}
