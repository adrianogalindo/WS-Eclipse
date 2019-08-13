package application;

import java.util.Locale;
import java.util.Scanner;
import utilities.CalculatorStatic;

public class MembroEstaticoV3Static {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter radius: ");
		double radius = sc.nextDouble();
	
		System.out.printf("Circumference = %.2f%n", CalculatorStatic.circumference(radius));
		System.out.printf("Volume = %.2f%n", CalculatorStatic.volume(radius));
		System.out.printf("PI value = %.2f%n", CalculatorStatic.PI);
		
		sc.close();
	}

}
