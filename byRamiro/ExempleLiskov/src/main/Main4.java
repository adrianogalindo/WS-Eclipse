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
			
			System.out.println("Rectangle color� cr");
			displayData(cr);
			
			System.out.println("Rectangle color� cr en rouge");
			cr.setColor("RED");
			displayData(cr);
			
			System.out.println("Rectangle color� cr en rouge et chang�");
			r.setCote(10, 14);
			displayData(cr);
			
			PolygoneColore cc = new PolygoneColore( new Carre(3));
			
			System.out.println("Carr� cc");
			displayData(cc);
			
			
				
		}


}
