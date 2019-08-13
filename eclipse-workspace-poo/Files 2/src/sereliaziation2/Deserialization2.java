package sereliaziation2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserialization2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> le = new ArrayList<Employee>();
		try {
			FileInputStream fileIn = new FileInputStream("employee.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			while (fileIn.available() > 0) {
				le.add((Employee) in.readObject());
			}
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
		for (int i = 0; i < le.size(); i++) {
			System.out.println("Name: " + le.get(i).getName());
			System.out.println("Address: " + le.get(i).getAddress());
			System.out.println("SSN: " + le.get(i).getSSN());
			System.out.println("Number: " + le.get(i).getNumber());
			System.out.println("==================================");
		}

	}

}
