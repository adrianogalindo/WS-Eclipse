package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestConsole {

	public static void main(String[] args) throws IOException {
		
		//Solution 1
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name1 = sc.nextLine();
		System.out.println("Welcome "+ name1);
		//sc.close(); It cannot be closed now, because it closes the stream System.in
		
		//Solution 2 -- Requires "throws IOException"
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your name:");
		String name2 = br.readLine();
		System.out.println("Welcome "+name2);
		
		sc.close();
	}

}
