package application;

import java.util.Locale;
import java.util.Scanner;

import entities.RectangleStatic;

public class RectangleExerciceStatic {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter rectangle width and height: ");
		double width = sc.nextDouble();
		double height = sc.nextDouble();
		

		
		System.out.printf("AREA = %.2f%n", RectangleStatic.area(width, height));
		System.out.printf("PERIMETER = %.2f%n", RectangleStatic.perimeter(width, height));
		System.out.printf("DIAGONAL = %.2f%n", RectangleStatic.diagonal(width, height));
		sc.close();
		
	}

}
