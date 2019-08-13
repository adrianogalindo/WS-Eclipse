package course;

import java.util.Scanner;

public class WhileExercice {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		double n = sc.nextDouble();
		
		while (n >= 0) {
			double sr = Math.sqrt(n);
			System.out.printf("raiz quadrada é: %.3f%n", sr);
			System.out.print("Enter another number: ");
			n = sc.nextDouble();
		}
		
		System.out.println("Negative number");
		
		
		
		sc.close();
	}

}
