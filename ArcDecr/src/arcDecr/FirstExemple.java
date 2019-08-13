package arcDecr;

import java.util.Locale;
import java.util.Scanner;

public class FirstExemple {

	public static void main(String[] args) {

				Locale.setDefault(Locale.US);
				Scanner sc = new Scanner(System.in);
				System.out.print("Please, type a number bigger than 0: ");
				int number = sc.nextInt();
				primeNumber(number);
				sc.close();
			}
			
			public static String primeNumber(int number) {
				if (number == 1) {
					return "It's a prime number";
				}
				for (int i = 2; i  < number; i++) {
					if ( number % i == 0) {
						return "It's not a prime number";
					}		
				}
				return "It's a prime number";
			}

}


