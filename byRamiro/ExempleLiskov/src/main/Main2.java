package main;

import liskov.*;

// Montre que si nous faisons carr� muable une extension 
// de retangle muable, le principe de Liskov sera viol�. 
// Consid�rez la m�thode dupliqueHateur

public class Main2 {
	
	public static  void displayData(Rectangle a) {
		System.out.println("c�t� horizontal: "+ a.getc1());
		System.out.println("c�t� vertical: "+ a.getc2());
		System.out.println("perimetre: "+a.perimetre());
		System.out.println("surface: "+a.surface());
		System.out.println();
	}
	
	public static void dupliqueHateur(Rectangle r)
	{
//		if(r.getClass()==Carre.class) { r.setCote(2*r.getc1(), 2*r.getc2());}
//		else {r.setCote(r.getc1(), 2*r.getc2());}
		r.setCote(r.getc1(), 2*r.getc2());
	}
	
	public static void main(String[] args) {
		
			Rectangle r = new Rectangle(3,5);
			System.out.println("Retangle r");
			displayData(r);
			
			Carre c = new Carre(3);
			System.out.println("Carr� c");
			displayData(c);
			
			c.setCote(4, 20);
			System.out.println("Carr� c apr�s changement c.setCote(4, 20)");
			displayData(c);
			
			Rectangle s = new Rectangle(5,7);
			System.out.println("Retangle s");
			displayData(s);
			
			dupliqueHateur(s);
			
			System.out.println("Retangle s apr�s changement dupliqueHateur(s);");
			displayData(s);
			
			System.out.println("Carr� c");
			displayData(c);
			
			dupliqueHateur(c);
			
			System.out.println("Carr� c apr�s changement dupliqueHateur(c);");
			displayData(c);
			
			
		}

	

}
