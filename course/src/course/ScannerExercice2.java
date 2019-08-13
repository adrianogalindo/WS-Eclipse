package course;

import java.util.Locale;
import java.util.Scanner;

public class ScannerExercice2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt(); //35
		sc.nextLine(); // se chama flush que é uma limpeza de linha por causa da quebra de linha
		String name = sc.nextLine(); // Adriano Galindo
		char gender = sc.next().charAt(0); // M
		String s = sc.next();
		char letter = s.charAt(0);
		int digit = Integer.parseInt(s.substring(1));
		double n2 = sc.nextDouble();
		
		String name2 = sc.next();
		char ch = sc.next().charAt(0);
		int age = sc.nextInt();
		double height = sc.nextDouble();
		
		System.out.println(n1);
		System.out.println(name);
		System.out.println(gender);
		System.out.println(letter);
		System.out.println(digit);
		System.out.println(n2);
		
		System.out.println(name2);
		System.out.println(ch);
		System.out.println(age);
		System.out.println(height);



		
		
		sc.close();
		
	}

}
