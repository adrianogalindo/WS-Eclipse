package main;

//import exempleSingleton2.*;   // it does not work. ModeControl no visible out the package

import exempleSingleton.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Form1 f = new Form1();
		
		f.Mode.setInsertMode(); 
		f.display();
		f.Mode.setUpdateMode(); 
		f.display();

		ModeControl test = ModeControl.getModeControl();
		
		System.out.println(test== f.Mode);
		
	}

}