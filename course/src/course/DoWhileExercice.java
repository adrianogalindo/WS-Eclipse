package course;

import java.util.Locale;
import java.util.Scanner;

public class DoWhileExercice {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		char confirmation;
		do {
			System.out.print("Enter a number: ");
			double n = sc.nextDouble();
			double sq = Math.sqrt(n);
			System.out.printf("Square root = %.3f%n", sq);

			System.out.print("Repeat (y/n): ");
			confirmation = sc.next().charAt(0);
		} while (confirmation == 'y');
		System.out.print("finish!!!");

		sc.close();
	}


}
