package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class TriangleMethodsExercice {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the measures of triangle X: ");
		Triangle x, y;
		x = new Triangle();
		y = new Triangle();
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		System.out.println("Enter the measures of triangle Y: ");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		double areaX = x.areaTriangle();
		double areaY = y.areaTriangle();
		
		System.out.printf("Triangle X area: %.4f%n", areaX);
		System.out.printf("Triangle Y area: %.4f%n", areaY);
		
		if (areaX > areaY) {
			System.out.println("Larger are is X: " + areaX);
		}
		else {
			System.out.println("Larger are is Y: " + areaY);
		}

		
		sc.close();
	}

}
