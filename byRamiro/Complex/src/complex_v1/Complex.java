package complex_v1;

public class Complex {

	@SuppressWarnings("serial")
	public class DivisionByZeroException extends RuntimeException {

		DivisionByZeroException() {
		}

		public String getMessage() {
			return "Exception: division by zero.";
		}
	}

	private double re, im;

	public Complex() {
		this.re = this.im = 0;
	}

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double getRealPart() {
		return re;
	}

	public double getImaginaryPart() {
		return im;
	}

	@Override
	public String toString() {
		if (this.im >= 0) {
			return this.re + "+" + this.im + "i";
		} else {
			return this.re + "" + this.im + "i";
		}
	}

	public Complex add(Complex y) {
		return new Complex(this.re + y.re, this.im + y.im);
	}

	public Complex subtract(Complex y) {
		return new Complex(this.re - y.re, this.im - y.im);
	}

	public Complex multiply(double r) {
		return new Complex(r * this.re, r * this.im);
	}

	public Complex multiply(Complex y) {
		return new Complex(this.re * y.re - this.im * y.im, 
				           this.re * y.im + this.im * y.re);
	}

	public Complex invert() throws DivisionByZeroException {
		double d = this.re * this.re + this.im * this.im;
		if (d == 0) {
			throw new DivisionByZeroException();
		} else {
			return new Complex(this.re / d, -1 * this.im / d);
		}
	}

}
