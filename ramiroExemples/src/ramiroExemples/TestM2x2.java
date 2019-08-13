package ramiroExemples;

import entities.M2x2;

public class TestM2x2 {

	public static void main(String[] args) {
		//---------------------------------------------------
		
		M2x2 m1 = new M2x2();
		M2x2 m2 = new M2x2(new double [] {1,2,2,10});
		System.out.println("Constructeur");
		System.out.println("m1 = " + m1.display());
		System.out.println("m2 = " + m2.display());
		System.out.println();
		
		//---------------------------------------------------
		M2x2 m3 = new M2x2(new double[] {1,2,2,4});
		System.out.println("Determinant");
		System.out.println("Determinant de [[1,2], [2,10] = " + new M2x2(new double[] {1,2,2,10}).determinant());
		System.out.println("m3 = " + m3.display());
		System.out.println("Determinant de m3 = " + m3.determinant());
		System.out.println();
		
		//---------------------------------------------------
		System.out.println("addition");
		System.out.println("m3 = " + m3.display());
		System.out.println("addition de m3 avec [[2,4], [1,8] = " + m3.add(new M2x2(new double[] {2,4,1,8})).display());
		System.out.println();		
		
		//---------------------------------------------------
		System.out.println("subtraction");
		System.out.println("m3 = " + m3.display());
		System.out.println("subtraction de m3 avec [[2,4], [1,8] = " + m3.sous(new M2x2(new double[] {2,4,1,8})).display());
		System.out.println();		
		
		//---------------------------------------------------
		System.out.println("multiplication par constante");
		System.out.println("m3 = " + m3.display());
		System.out.println("2 * m3 = " + m3.multReel(2).display());
		System.out.println("2.5 * m3 = " + m3.multReel(2.5).display());
		System.out.println();		
		
		//---------------------------------------------------
		System.out.println("multiplication par matrice");
		System.out.println("m2 = " + m2.display());
		System.out.println("m3 = " + m3.display());
		System.out.println("m3  * m2 = " + m3.multMatParMat(m2).display());
		System.out.println("m3 *  [[2,4], [1,8]  = " + m3.multMatParMat(new M2x2(new double[] {2,4,1,8})).display());
		System.out.println();		
		
		//---------------------------------------------------
		System.out.println("Inverse M2");
		System.out.println("m2 = " + m2.display());
		System.out.println("Inverse de m2 = " + m2.inverse().display());
		System.out.println("Inverse de [[2,0], [1,2]  = " + new M2x2(new double[] {2,1,0,2}).inverse().display());
		System.out.println();		
		
		//---------------------------------------------------
		System.out.println("Inverse M3");
		System.out.println("m3 = " + m3.display());
		System.out.println("Inverse de m3 = " + m3.inverse().display());
		System.out.println("Inverse de [[2,4], [1,8]  = " + new M2x2(new double[] {2,4,1,8}).inverse().display());
		System.out.println();		
		
		
		
		
	}

}
