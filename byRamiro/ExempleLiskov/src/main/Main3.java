package main;

import liskov2.*;

public class Main3 {
	
	public static  void displayData(Polygone a) {
		System.out.println("cotes: "+a.listCotes().toString());
		System.out.println("perimetre: "+a.perimetre());
		System.out.println("surface: "+a.surface());
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
			Rectangle r = new Rectangle(3,5);
			System.out.println("Retangle r");
			
			displayData(r);
			
			Carre c = new Carre(3);
			System.out.println("Carré c");
			displayData(c);
			
			c.setCote(4);
			System.out.println("Carré c après changement c.setCote(4)");
			displayData(c);
			
			Rectangle s = new Rectangle(5,7);
			System.out.println("Retangle s");
			displayData(s);
				
		}

}
