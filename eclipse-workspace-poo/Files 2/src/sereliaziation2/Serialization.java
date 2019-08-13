package sereliaziation2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee();
		e1.setName("Mary Brown");
		e1.setAddress("123 Rue des examples");
		e1.setSSN(11122333);
		e1.setNumber(101);
		Employee e2 = new Employee();
		e2.setName("John Smith");
		e2.setAddress("120 Rue des examples");
		e2.setSSN(11122444);
		e2.setNumber(102);

		try {
			FileOutputStream fileout = new FileOutputStream("employee.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(e1);
			out.writeObject(e2);
			out.close();
			fileout.close();
			System.out.println("Serializable data is saved in employee.dat");
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

}
