package sereliaziation2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = null;
		Employee e2 = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e1 = (Employee) in.readObject();
			e2 = (Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}

		System.out.println("Deseralization employee...");
		System.out.println("==================================");
		System.out.println("Name: " + e1.getName());
		System.out.println("Address: " + e1.getAddress());
		System.out.println("SSN: " + e1.getSSN());
		System.out.println("Number: " + e1.getNumber());
		System.out.println("==================================");
		System.out.println("Name: " + e2.getName());
		System.out.println("Address: " + e2.getAddress());
		System.out.println("SSN: " + e2.getSSN());
		System.out.println("Number: " + e2.getNumber());
		System.out.println("==================================");

	}

}
