package main;

import complex_v1.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Complex x1 = new Complex(1,2);
		System.out.println("x1 = " + x1);
		Complex x2 = new Complex(4,5);
		System.out.println(x1+" + " + x2 + " = "+x1.add(x2));
		System.out.println("("+x1+") - (" + x2 + ") = "+x1.subtract(x2));
		System.out.println("2 x (" + x1 + ") = "+x1.multiply(2));
		System.out.println("(" + x1 + ") x (" + x2 + ") = "+x1.multiply(x2));
		System.out.println("inverse of ("+x1 +") = "+ x1.invert());
		Complex x3 = new Complex(0,0);
		try {
			System.out.println(x3.invert());
		}
		catch(Complex.DivisionByZeroException e1){
			System.out.println(e1.getMessage());
		}

	}

}
