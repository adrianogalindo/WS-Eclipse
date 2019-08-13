package sereliaziation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.name = "Mary Brown";
		e.address = "123 Rue des examples";
		e.SSN = 11122333;
		e.number =101;
		
		try {
			FileOutputStream fileout = new FileOutputStream("employee.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(e);
			out.close();
			fileout.close();
			System.out.println("Serializable data is saved in employee.dat");
		}catch (IOException i){
			i.printStackTrace();
		}

	}

}
