package entities;

import java.util.Arrays;

public class M2x2 {
	
	@SuppressWarnings("serial")
	static class M2x2InvalidSizeException extends RuntimeException {
		private int data;

		M2x2InvalidSizeException(int s){
			this.data = s;
		}

		public int getSize() {
			return data;
		}

		public String getMessage() {
			return "Invalid size: " + data ; 
		}
	}

	@SuppressWarnings("serial")
	static class M2x2NullDeterminantException extends RuntimeException {
		M2x2NullDeterminantException(){

		}

		public String getMessage() {
			return "determinant zero - matrice n'est pas inversible.";
		}
	}
	private double[][] m;

	public M2x2() {
		m = new double [][] {{0,0},{0,0}};
	}


	public M2x2(double[] a)  throws M2x2InvalidSizeException {
		if(a.length != 4) {
			throw new M2x2InvalidSizeException(a.length);
		}

		m = new double[2][2];
		m[0][0] =a[0];
		m[0][1] =a[1];
		m[1][0] =a[2];
		m[1][1] =a[3];
	}


	public String display() {
		return (Arrays.deepToString(m));
	}

	public M2x2 add(M2x2 b) {
		M2x2 w = new M2x2();
		w.m[0][0] = this.m[0][0]+b.m[0][0];
		w.m[0][1] = this.m[0][1]+b.m[0][1];
		w.m[1][0] = this.m[1][0]+b.m[1][0];
		w.m[1][1] = this.m[1][1]+b.m[1][1];
		return w;
	}

	public M2x2 sous(M2x2 b) {
		M2x2 w = new M2x2();
		w.m[0][0] = this.m[0][0]-b.m[0][0];
		w.m[0][1] = this.m[0][1]-b.m[0][1];
		w.m[1][0] = this.m[1][0]-b.m[1][0];
		w.m[1][1] = this.m[1][1]-b.m[1][1];
		return w;
	}

	public M2x2 multReel(double r) {
		M2x2 w = new M2x2();
		w.m[0][0] = this.m[0][0] * r;
		w.m[0][1] = this.m[0][1] * r;
		w.m[1][0] = this.m[1][0] * r;
		w.m[1][1] = this.m[1][1] * r;
		return w;
	}

	public M2x2 multMatParMat(M2x2 b) {
		M2x2 w = new M2x2(); 
		w.m[0][0] = this.m[0][0]*b.m[0][0] + this.m[0][1] * b.m[1][0];
		w.m[0][1] = this.m[0][0]*b.m[0][1] + this.m[0][1] * b.m[1][1];
		w.m[1][0] = this.m[1][0]*b.m[0][0] + this.m[1][1] * b.m[1][0];
		w.m[1][1] = this.m[0][1]*b.m[0][1] + this.m[1][1] * b.m[1][1];
		return w;
	}

	public double determinant() {
		return  this.m[0][0] * this.m[1][1] - this.m[0][1] * this.m[1][0];
	}

	public M2x2 inverse() {
		
		
		if (determinant() == 0) {
				throw new M2x2NullDeterminantException();
			}
		
		M2x2 w = new M2x2();
		w.m[0][0] = this.m[1][1] / determinant();
		w.m[0][1] = (-this.m[0][1]) / determinant();
		w.m[1][0] = (-this.m[1][0]) / determinant();
		w.m[1][1] = this.m[0][0] / determinant();
		return w;
	}
}
