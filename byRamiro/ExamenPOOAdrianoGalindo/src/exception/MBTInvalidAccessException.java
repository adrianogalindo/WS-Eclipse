package exception;

public class MBTInvalidAccessException extends RuntimeException {
	
	private static final long serialVersionUID = 6166142414919867602L;
	private Integer messageChoice;
	
	public MBTInvalidAccessException(int i) {
		this.messageChoice = i;
	}
	
	public String getMessage() {
		String msg = "";
		switch (this.messageChoice) {
		case 1 : msg = "Invalid root() call: empty list"; break;
		case 2 : msg = "Invalid append() call: not in a leaf (not an empty tree)"; break;
		}
		return msg;
	}
}
