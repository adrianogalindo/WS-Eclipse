package main;

import m2x2.*;

public class TestM2x2_1 {

	public static void main(String[] args) {
		
	//----------------------------------------------
        M2x2 m1= new M2x2();        
        M2x2 m2= new M2x2(new double[]{1,2,2,10});
        System.out.println("Constructeur");
        System.out.println("m1 = " + m1.display());
        System.out.println("m2 = " + m2.display());
        System.out.println();
   //----------------------------------------------          
        M2x2 m3= new M2x2(new double[]{1,2,2,4});
        System.out.println("determinant");
        System.out.println("determinant de  [[1 , 2] , [2 , 10]] = " + 
        new M2x2(new double[]{1,2,2,10}).determinant());
        System.out.println("m3 = " + m3.display());
        System.out.println("determinant de m3 = " + m3.determinant());
        System.out.println();
   //----------------------------------------------         
        System.out.println("addition");
        System.out.println("m3 = " + m3.display());
        System.out.println("addition de m3 avec [[2 , 4] , [1 , 8]] = " + 
        m3.add(new M2x2(new double[]{2,4,1,8})).display());
        System.out.println();
   //----------------------------------------------         
        System.out.println("subtraction");
        System.out.println("m3 = " + m3.display());
        System.out.println("m3 - [[2 , 4] , [1 , 8]] = " +
        m3.subtract(new M2x2(new double[]{2,4,1,8})).display());
        System.out.println();
   //----------------------------------------------         
        System.out.println("multiplication par constante");
        System.out.println("m3 = " + m3.display());
        System.out.println("2 * m3 = " + m3.multiply(2).display());
        System.out.println("2.5 * m3 = " + m3.multiply(2.5).display());
        System.out.println();     
   //----------------------------------------------         
        System.out.println("multiplication");
        System.out.println("m2 = " + m2.display());
        System.out.println("m3 = " + m3.display());
        System.out.println("m3 * m2 = " + m3.multiply(m2).display());
        System.out.println("m3 *  [[2 , 4] , [1 , 8]] = " + 
        m3.multiply(new M2x2(new double[]{2,4,1,8})).display());
        System.out.println();     
   //----------------------------------------------         
        System.out.println("Inverse");
        System.out.println("m2 = " + m2.display());
        System.out.println("Inverse de m2 = " + m2.inverse().display());
        System.out.println("Inverse de [[2 , 0] , [1 , 2]] = " + 
        new M2x2(new double[]{2,0,1,2}).inverse().display());
        System.out.println();  
   //----------------------------------------------  
        System.out.println("Inverse - Exception");
        try {
        	System.out.println("Inverse de [[2 , 4] , [1 , 2]] = " + 
                new M2x2(new double[]{2,4,1,2}).inverse().display());
        }
        catch( M2x2.M2x2NullDeterminantException e) {
        	System.out.println("matrix non-invertible");
        	System.out.println(e.getMessage());
        }
        System.out.println();  
   //----------------------------------------------  
        System.out.println("Constructor - Exception");
        try {
                new M2x2(new double[]{2,4,1,2,5});
        }
        catch( M2x2.M2x2InvalidSizeException e) {
        	System.out.println(e.getMessage());
        }
        
	}

}

