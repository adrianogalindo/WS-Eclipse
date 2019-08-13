package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) {
		
		Employee e = new Employee();
		e.name = " Mary Brown";
		e.address = " 123 rue des examples";
		e.SSN = 111222333;
		e.number = 101;
		
		try {
			FileOutputStream fileOut = new FileOutputStream("emplyee.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.println(" Serialized data is saved in employee.dat");
		} catch (IOException i) {
			i.printStackTrace();
		}
		
	}

}
