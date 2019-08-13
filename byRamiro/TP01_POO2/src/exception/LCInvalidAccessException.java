package exception;

public class LCInvalidAccessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8593277196107656428L;
	private final int errorCode;

	public LCInvalidAccessException(final int exp) {

		this.errorCode = exp;

	}

	public String getMessage() {

		String msg = " ";
		switch (this.errorCode) {
		case 1:
			msg = "Invalid head() call: empty chaine";
			break;
		case 2:
			msg = "Invalid end() call: empty chaine";
			break;
		case 3:
			msg = "Invalid data: No data to add to the list";
			break;
		case 11:
			msg = "Invalid next() call: hasNext() false";
			break;
		case 12:
			msg = "Invalid previous() call: hasPrevious() false";
			break;
		case 13:
			msg = "Invalid set(T v) call: undefined current position";
			break;
		case 14:
			msg = "Invalid remove() call: undefined current position";
			break;
		}
		return msg;
	}
}