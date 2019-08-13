package ramiroExemples;

import java.util.Locale;
import java.util.Scanner;

public class FirstExemple {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int number = 0;
		/*String teste = sc.nextLine();
		int num = Integer.valueOf(teste);
		System.out.println(num); */

		while (number < 2) {
			System.out.print("Please, type a number bigger than 1: ");
			number = sc.nextInt();
		}

		System.out.println(primeNumber(number));
		sc.close();
	}

	public static String primeNumber(int number) {
		for (int i = 2; i  < number; i++) {
			if ( number % i == 0) {return "It's not a prime number";}		
		}
		return "It's a prime number";
	}

}


