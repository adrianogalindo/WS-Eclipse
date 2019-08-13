package testTextFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test2TextFile {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter w = new BufferedWriter (new FileWriter("test2.txt"));
		w.write("aaa aaa aaa");
		w.newLine();
		w.write("AA AA AA");
		w.newLine();
		w.close();
		
		
	}

}
