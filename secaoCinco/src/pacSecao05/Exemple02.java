package pacSecao05;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Exemple02 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Product[] vect = new Product[n];
		double sum = 0;
		
		for (int i = 0; i < vect.length; i++) { // poderia tambem utilisar vect.length no lugar de n
		sc.nextLine();
		String name = sc.nextLine();
		double price = sc.nextDouble();
		vect[i] = new Product(name, price);
		sum += vect[i].getPrice();
		}
		
		System.out.printf("Average price: %.2f%n", sum/vect.length);
		
		sc.close();
	}
}
