package main;

import liskov.CarreImm;
import liskov.RectangleImm;

public class Main {
	
	public static  void displayData(RectangleImm a) {
		System.out.println("c�t� horizontal: "+ a.getc1());
		System.out.println("c�t� vertical: "+ a.getc2());
		System.out.println("perimetre: "+a.perimetre());
		System.out.println("surface: "+a.surface());
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RectangleImm r = new RectangleImm(3,5);
		System.out.println("Retangle r");
		displayData(r);
		
		RectangleImm s = new RectangleImm(2,7);
		System.out.println("Retangle s");
		displayData(s);
		
		CarreImm c = new CarreImm(3);
		System.out.println("Carr� c");
		displayData(c);
		
	}

}
