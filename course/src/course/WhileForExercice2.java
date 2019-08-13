package course;

import java.util.Scanner;

public class WhileForExercice2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number positive: ");
		double n = sc.nextDouble();

		while (n <= 0) {
			System.out.print("The number must be positive: ");
			n = sc.nextDouble();
		}
		int higher = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			System.out.print("Value #" + i + ": ");
			int x = sc.nextInt();
			if (x > higher) {
				higher = x;
			}
		}

		System.out.println("Higher is: " + higher);
		sc.close();
	}

}
