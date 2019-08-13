package main;

import liskov2.*;


public class Main4 {
	
	public static  void displayData(PolygoneColore a) {
		System.out.println("cotes: "+a.listCotes().toString());
		System.out.println("perimetre: "+a.perimetre());
		System.out.println("surface: "+a.surface());
		System.out.println("couleur: "+a.getColor());
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
			Rectangle r = new Rectangle(3,5);
			PolygoneColore cr =new PolygoneColore(r);
			
			System.out.println("Rectangle coloré cr");
			displayData(cr);
			
			System.out.println("Rectangle coloré cr en rouge");
			cr.setColor("RED");
			displayData(cr);
			
			System.out.println("Rectangle coloré cr en rouge et changé");
			r.setCote(10, 14);
			displayData(cr);
			
			PolygoneColore cc = new PolygoneColore( new Carre(3));
			
			System.out.println("Carré cc");
			displayData(cc);
			
			
				
		}


}
