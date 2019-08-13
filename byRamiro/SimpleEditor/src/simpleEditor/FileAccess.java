package simpleEditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileAccess {
	
	static String currentframe = "";
	static boolean notSaved = false;
	
	static void myReadFile (String fname) throws IOException {
		BufferedReader myFile = new BufferedReader(new FileReader(fname));
		Main.frame.textArea.setText("");
		String v = myFile.readLine();
		while(v != null) {
			Main.frame.textArea.append(v + '\n');
			v = myFile.readLine();
		}
		myFile.close();
		currentframe = fname;
		notSaved = false;
	}
	
	static void myWriteFile (String fname) throws IOException {
		PrintWriter myFile = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
		myFile.write(Main.frame.textArea.getText());
		myFile.close();
		currentframe = fname;
		notSaved = false;
	}

}
