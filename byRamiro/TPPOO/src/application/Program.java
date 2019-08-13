package application;

import java.util.Arrays;

import entities.MyList;
import entities.MyListIterator;

public class Program {
	public static void main(String[] args) {
		
//		------------------------------------------------------------------------------------------
		MyList<String> x1 = new MyList<String>();
		System.out.println("Teste du premier constructeur (et de toArray): ");
		System.out.println(" x1 = " + Arrays.deepToString(x1.toArray()));
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		MyList<String> x2 = new MyList<String>("AAA");
		System.out.println("Teste du deuxième constructeur (et de toArray): ");
		System.out.println(" x2 = " + Arrays.deepToString(x2.toArray()));
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		MyList<String> x3 = new MyList<String>(new String[] {"AAA", "BBB", "CCC", "DDD", "EEE"});
		System.out.println("Teste du troisiéme constructeur (et de toArray): ");
		System.out.println(" x3 = " + Arrays.deepToString(x3.toArray()));
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		System.out.println("Teste de head: ");
		System.out.print("Head de x3 =  " + x3.head());
		System.out.println();
		System.out.println("Teste de tail (et de toArray): ");
		System.out.println(Arrays.deepToString(x3.tail().toArray()));
		System.out.println("Teste de end: ");
		System.out.println("End de x3 =  " + x3.end());
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		
		System.out.println("Teste de copy: ");
		System.out.print("copy() de x3 avec addresse =  " + x3);
		System.out.println();
		MyList<String> x3Copy = x3.copy();
		System.out.print("Adresse de la copie x3.copy() :" + x3Copy);
		System.out.println();
		System.out.print("copy() de x3.tail avec addresse =  " + x3.tail);
		System.out.println();
		System.out.print("Adresse de la copie.tail x3.copy() :" + x3Copy.tail);
		System.out.println();
		System.out.println("Verifie l'adresse de x3 aprèes la copie =  " + x3);
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		System.out.println("Teste de append: ");
		x3.append("FFF");
		System.out.println("append() de x3=  " + Arrays.deepToString(x3.toArray()));
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		MyList<String> x4 = new MyList<String>(new String[] {"GGG", "HHH", "III", "JJJ", "LLL"});
		System.out.println("Teste de concat: ");
		x3.concat(x3);
		x3.concat(x4);
		System.out.println("Teste du troisiéme constructeur (et de toArray): ");
		System.out.println(" x3 concat x4 = " + Arrays.deepToString(x3.toArray()));
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		System.out.println("Teste pour initialiser l’iterateur MyListIterator. ");
		MyListIterator<String> listIterator1 = x3.myListIterator();
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("x3 en ordre direct");
		System.out.print("[ ");
		while(listIterator1.hasNext()) {
			System.out.print(listIterator1.next() +  " ");
		}
		System.out.println("]");
		System.out.println();
//		------------------------------------------------------------------------------------------
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("HasPrevious? " + listIterator1.hasPrevious());
		System.out.println();
		System.out.println("x3 en ordre inverse");
		System.out.print("[ ");
		while(listIterator1.hasPrevious()) {
			System.out.print(listIterator1.previous() +  " ");
		}
		System.out.println("]");
		System.out.println();
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("HasPrevious? " + listIterator1.hasPrevious());
		System.out.println();
//		------------------------------------------------------------------------------------------
		listIterator1.goToEnd();
		System.out.println("goToEnd()");
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("HasPrevious? " + listIterator1.hasPrevious());
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		listIterator1.goToBegin();
		System.out.println("goToBegin()");
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("HasPrevious? " + listIterator1.hasPrevious());
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		System.out.print("[ ");
		while(listIterator1.hasNext()) {
			System.out.print(listIterator1.next() +  " ");
		}
		System.out.println("]");
		System.out.println("set() data method Adriano (1) et Galindo (derniére)");
		listIterator1.goToBegin();
		listIterator1.set("Adriano");
		listIterator1.goToEnd();
		listIterator1.set("Galindo");
		listIterator1.goToBegin();
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("x3 en ordre direct");
		System.out.print("[ ");
		while(listIterator1.hasNext()) {
			System.out.print(listIterator1.next() +  " ");
		}
		System.out.println("]");
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		listIterator1.goToBegin();
		listIterator1.next();
		listIterator1.next();
		listIterator1.next();
		System.out.println();
		listIterator1.add("UHUUUUUUUUU");
		listIterator1.goToBegin();
		System.out.println("Testing methode add() Middle list UHUUUUUUUUU (4)");
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while(listIterator1.hasNext()) {
			System.out.print(listIterator1.next() +  " ");
		}
		System.out.println("]");
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		listIterator1.goToBegin();
		System.out.println();
		listIterator1.add("First Item");
		listIterator1.goToBegin();
		System.out.println("Testing methode add() debut list First Item ");
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while(listIterator1.hasNext()) {
			System.out.print(listIterator1.next() +  " ");
		}
		System.out.println("]");
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		listIterator1.goToEnd();

		System.out.println();
		listIterator1.add("Last Item");
		listIterator1.goToBegin();
		System.out.println("Testing methode add() fin list Last Item ");
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while(listIterator1.hasNext()) {
			System.out.print(listIterator1.next() +  " ");
		}
		System.out.println("]");
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		listIterator1.goToBegin();
		listIterator1.next();
		listIterator1.next();
		listIterator1.next();
		listIterator1.next();
		listIterator1.remove();
		System.out.println();
		listIterator1.goToBegin();
		System.out.println("Testing methode remove() UHUUUUUUUUU (5)");
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while(listIterator1.hasNext()) {
			System.out.print(listIterator1.next() +  " ");
		}
		System.out.println("]");
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		System.out.println();
		listIterator1.goToBegin();
		listIterator1.remove();
		System.out.println();
		listIterator1.goToBegin();
		System.out.println("Testing methode remove() First Item ");
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while(listIterator1.hasNext()) {
			System.out.print(listIterator1.next() +  " ");
		}
		System.out.println("]");
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		System.out.println();
		listIterator1.goToEnd();

		listIterator1.remove();
		System.out.println();
		listIterator1.goToBegin();
		System.out.println("Testing methode remove() Last item");
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while(listIterator1.hasNext()) {
			System.out.print(listIterator1.next() +  " ");
		}
		System.out.println("]");
		System.out.println();
		
		
		
		
		
		
		
		
		
		

	}
}
