package testTextFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test1TextFile {

	public static void main(String[] args) throws IOException {
		
		BufferedReader w = new BufferedReader (new FileReader("test1.txt"));
		String v = w.readLine();
		while(v!=null) {
			System.out.println(v);
			v = w.readLine();
		}
		w.close();
	}

}
