package m2x2v2;

import java.util.Arrays;

public class M2x2 {

	private double[][] m;

	public M2x2() {
		m = new double [][] {{0,0},{0,0}};	
	}

	public M2x2(double[] a) throws M2x2InvalidSizeException {
		if (a.length != 4) {
			throw new M2x2InvalidSizeException(a.length);
		}
		m = new double[2][2];
		m[0][0]=a[0];
		m[0][1]=a[1];
		m[1][0]=a[2];
		m[1][1]=a[3];
	}

	public String display() {
		return Arrays.deepToString(m);
	}

	public M2x2 add(M2x2 b) {
		M2x2 w = new M2x2();
		w.m[0][0]=this.m[0][0]+b.m[0][0];
		w.m[0][1]=this.m[0][1]+b.m[0][1];
		w.m[1][0]=this.m[1][0]+b.m[1][0];
		w.m[1][1]=this.m[1][1]+b.m[1][1];
		return w;
	}

	public M2x2 subtract(M2x2 b) {
		M2x2 w = new M2x2();
		w.m[0][0]=this.m[0][0]-b.m[0][0];
		w.m[0][1]=this.m[0][1]-b.m[0][1];
		w.m[1][0]=this.m[1][0]-b.m[1][0];
		w.m[1][1]=this.m[1][1]-b.m[1][1];
		return w;
	}

	public M2x2 multiply(double c) {
		M2x2 w = new M2x2();
		w.m[0][0]=c*this.m[0][0];
		w.m[0][1]=c*this.m[0][1];
		w.m[1][0]=c*this.m[1][0];
		w.m[1][1]=c*this.m[1][1];
		return w;
	}

	public M2x2 multiply(M2x2 b) {
		M2x2 w = new M2x2();
		w.m[0][0] = this.m[0][0] * b.m[0][0] + this.m[0][1] * b.m[1][0];
		w.m[0][1] = this.m[0][0] * b.m[0][1] + this.m[0][1] * b.m[1][1];
		w.m[1][0] = this.m[1][0] * b.m[0][0] + this.m[1][1] * b.m[1][0];
		w.m[1][1] = this.m[1][0] * b.m[0][1] + this.m[1][1] * b.m[1][1];
		return w;
	}

	public double determinant() {
		return (m[0][0] * m[1][1] - m[0][1] * m[1][0]);
	}

	public M2x2 inverse() throws M2x2NullDeterminantException {
		double d = this.determinant();
		if (d == 0) {
			throw new M2x2NullDeterminantException();
		}
		M2x2 w = new M2x2();
		w.m[0][0] = this.m[1][1] / d;
		w.m[0][1] = -1 * this.m[0][1] / d;
		w.m[1][0] = -1 * this.m[1][0] / d;
		w.m[1][1] = this.m[0][0] / d;
		return w;
	}

}
