package application;

import java.util.Locale;
import java.util.Scanner;
import utilities.Calculator;

public class MembroEstaticoV2 {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter radius: ");
		double radius = sc.nextDouble();
		Calculator calc = new Calculator();
	
		System.out.printf("Circumference = %.2f%n", calc.circumference(radius));
		System.out.printf("Volume = %.2f%n", calc.volume(radius));
		System.out.printf("PI value = %.2f%n", calc.PI);
		
		sc.close();
	}

}
