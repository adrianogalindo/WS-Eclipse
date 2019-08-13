package serialization2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) {
		
		Employee e = new Employee();
		e.setName(" MAry Brown");
		e.setAddress(" 123 rue des examples");
		e.setSSN(111222333);
		e.setNumber(101);
		Employee e2 = new Employee();
		e.setName(" Adriano Galindo");
		e.setAddress(" 6366 rue de Marseille");
		e.setSSN(2345678);
		e.setNumber(005);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("emplyee.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.writeObject(e2);
			out.close();
			fileOut.close();
			System.out.println(" Serialized data is saved in employee.dat");
		} catch (IOException i) {
			i.printStackTrace();
		}
		
	}

}
