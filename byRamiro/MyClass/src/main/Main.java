package main;

import myClass.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyClass a = new MyClass("Anne");
		MyClass b = new MyClass("John");
		MyClass c = new MyClass("Michael");
		
		System.out.println("Objets créés : " +MyClass.countObjets());
		
		System.out.println("Le premier objet a le nom "+ MyClass.getObjets(0).getData() );

	}

}
