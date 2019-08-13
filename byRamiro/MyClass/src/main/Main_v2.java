package main;

import myClass_v2.MyClass;

public class Main_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass a = new MyClass("Anne");
		MyClass b = new MyClass("John");
		MyClass c = new MyClass("Michael");
		
		System.out.println("Objets créés : " +MyClass.Objets.count());
		
		System.out.println("Le premier objet a le nom "+ MyClass.Objets.get(0).getData() );

	}

}
