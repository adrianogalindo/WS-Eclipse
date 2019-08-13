package testTextFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test3TextFile {

	public static void main(String[] args) throws IOException {
		
		PrintWriter w = new PrintWriter(new BufferedWriter (new FileWriter("test3.txt")));
		w.write("aaa aaa aaa aaa");
		w.println();
		w.println("AA AA AA AA");
		w.println();
		w.close();
	}

}
