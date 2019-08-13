package pacSecao05;

import java.util.Locale;
import java.util.Scanner;

public class Exemple01 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] vect = new double [n];
		double sum = 0;
		
		for (int i = 0; i <  n; i++) {
			vect[i] = sc.nextDouble();
			sum += vect[i];
		}
		
		System.out.printf("Average Height: %.2f%n", sum/n);
		
		
		
		sc.close();
	}

}
