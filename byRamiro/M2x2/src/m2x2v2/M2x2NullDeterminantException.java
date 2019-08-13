package m2x2v2;

@SuppressWarnings("serial")
public class M2x2NullDeterminantException extends RuntimeException {

	M2x2NullDeterminantException() {
	}

	public String getMessage() {
		return "determinant zéro - matrice n'est pas inversible.";
	}
}
