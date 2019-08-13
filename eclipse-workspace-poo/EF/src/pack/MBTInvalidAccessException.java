package pack;

public class MBTInvalidAccessException extends RuntimeException {
	private final int errorCode;

	public MBTInvalidAccessException(final int exp) {

		this.errorCode = exp;

	}

	public String getMessage() {

		String msg = " ";
		switch (this.errorCode) {
		case 1:
			msg = "Invalid root() call: empty tree";
			break;
		case 2:
			msg = "Invalid append() call: not in a leaf (not in an empty tree)";
			break;
		}
		return msg;
	}

}
