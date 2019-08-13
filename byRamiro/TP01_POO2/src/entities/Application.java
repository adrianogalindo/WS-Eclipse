package entities;

import java.util.Arrays;

import exception.LCInvalidAccessException;

public class Application {

	public static void main(String[] args) {

//		------------------------------------------------------------------------------------------
		LinkedChaine<String> x1 = new LinkedChaine<String>();
		System.out.println("Teste du premier constructeur (et de toArray): ");
		System.out.println(" x1 = " + Arrays.deepToString(x1.toArray()));
		System.out.println();

//		------------------------------------------------------------------------------------------
		LinkedChaine<String> x2 = new LinkedChaine<String>("AAA");
		System.out.println("Teste du deuxième constructeur (et de toArray): ");
		System.out.println(" x2 = " + Arrays.deepToString(x2.toArray()));
		System.out.println();

//		------------------------------------------------------------------------------------------
		LinkedChaine<String> x3 = new LinkedChaine<String>(new String[] { "AAA", "BBB", "CCC", "DDD", "EEE" });
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
		System.out.println(Arrays.deepToString(x3.toArray()));

		LinkedChaine<String> x3Copy = x3.copy();

		System.out.print("Adresse de la copie x3.copy() :" + x3Copy);
		System.out.println();

		System.out.println(Arrays.deepToString(x3Copy.toArray()));

		System.out.println();
		System.out.print("copy() de x3.fin avec addresse =  " + x3.fin);
		System.out.println();
		System.out.print("Adresse de la copie.fin x3.copy() :" + x3Copy.fin);
		System.out.println();
		System.out.println("Verifie l'adresse de x3 aprèes la copie =  " + x3);
		System.out.println();

//		------------------------------------------------------------------------------------------
		System.out.println("Teste de append: ");
		x3.append("FFF");
		System.out.println("append() de x3=  " + Arrays.deepToString(x3.toArray()));
		System.out.println();

//		------------------------------------------------------------------------------------------
		LinkedChaine<String> x4 = new LinkedChaine<String>(new String[] { "GGG", "HHH", "III", "JJJ", "LLL" });
		System.out.println("Teste de concat: ");
		x3.concat(x3);
		System.out.println(" x3 concat x3 = " + Arrays.deepToString(x3.toArray()));

		x3.concat(x4);
		System.out.println("Teste du troisiéme constructeur (et de toArray): ");
		System.out.println(" x3 concat x4 = " + Arrays.deepToString(x3.toArray()));
		System.out.println();

//		------------------------------------------------------------------------------------------
		LinkedChaine<String> xNull = new LinkedChaine<>();
		System.out.println("Teste de exception de concat: ");
		
		try {
			x3.concat(xNull);
		} catch (LCInvalidAccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" x3 concat xNull = " + Arrays.deepToString(x3.toArray()));
		System.out.println();
		System.out.println();

//		------------------------------------------------------------------------------------------
		System.out.println("Teste pour initialiser l’iterateur MyListIterator. ");
		LinkedChainedIterator<String> listIterator1 = x3.linkedChainedIterator();
		System.out.println("HasNext? " + listIterator1.hasNext());
		System.out.println("x3 en ordre direct");
		System.out.print("[ ");
		while (listIterator1.hasNext()) {
			System.out.print(listIterator1.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------

		LinkedChaine<String> x5 = new LinkedChaine<String>(
				new String[] { "AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH", "III", "JJJ" });
		System.out.println("Teste du 3 constructeur (et de toArray): ");
		System.out.println(" x5 = " + Arrays.deepToString(x5.toArray()));
		System.out.println();
		LinkedChainedIterator<String> listIterator2 = x5.linkedChainedIterator();

		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("HasPrevious? " + listIterator2.hasPrevious());
		System.out.println();
		System.out.println("x5 en ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {
			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("HasPrevious? " + listIterator2.hasPrevious());
		System.out.println();

		System.out.println("x5 en ordre inverse");
		System.out.print("[ ");
		while (listIterator2.hasPrevious()) {
			System.out.print(listIterator2.previous() + " ");
		}
		System.out.println("]");
		System.out.println();
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("HasPrevious? " + listIterator2.hasPrevious());
		System.out.println();

//		------------------------------------------------------------------------------------------

		System.out.println();
		System.out.println("goToEnd()");
		listIterator2.goToEnd();
		System.out.println("Teste pour next() Exception ");
		try {
			listIterator2.next();
		} catch (LCInvalidAccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("goToBegin()");
		listIterator2.goToBegin();
		System.out.println("Teste pour previous() Exception");
		try {
			listIterator2.previous();
		} catch (LCInvalidAccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

//		------------------------------------------------------------------------------------------
		listIterator2.goToEnd();
		System.out.println("goToEnd()");
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("HasPrevious? " + listIterator2.hasPrevious());
		System.out.println();

//		------------------------------------------------------------------------------------------
		listIterator2.goToBegin();
		System.out.println("goToBegin()");
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("HasPrevious? " + listIterator2.hasPrevious());
		System.out.println();

//		------------------------------------------------------------------------------------------
		System.out.print("[ ");
		while (listIterator2.hasNext()) {
			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println("set() data method Adriano (1) et Galindo (derniére)");
		listIterator2.goToBegin();
		listIterator2.next();
		listIterator2.set("Adriano");
		listIterator2.goToEnd();
		listIterator2.set("Galindo");
		listIterator2.goToBegin();

		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("HasPrevious? " + listIterator2.hasPrevious());
		System.out.println("x5 en ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {

			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------

		System.out.println("]");
		System.out.println("set() data method Cavalcante (2)");
		listIterator2.goToBegin();
		listIterator2.next();
		listIterator2.next();
		listIterator2.set("Cavalcante");
		listIterator2.goToBegin();

		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("HasPrevious? " + listIterator2.hasPrevious());
		System.out.println("x5 en ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {

			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------

		System.out.println("set() data method Try Catch Exception");
		listIterator2.goToBegin();
		try {
			listIterator2.set("Teste Exception");
		} catch (LCInvalidAccessException e) {
			System.out.println(e.getMessage());
		}
		listIterator2.goToBegin();

		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("HasPrevious? " + listIterator2.hasPrevious());
		System.out.println("x5 en ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {

			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------
		listIterator2.goToBegin();
		listIterator2.next();
		listIterator2.next();
		listIterator2.next();
		System.out.println();
		listIterator2.add("UHUUUUUUUUU");
		listIterator2.goToBegin();
		System.out.println("Testing methode add() Middle list UHUUUUUUUUU (4)");
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {
			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------
		listIterator2.goToBegin();
		System.out.println();
		listIterator2.add("First Item");
		listIterator2.goToBegin();

		System.out.println("Testing methode add() debut list First Item ");
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {
			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------
		listIterator2.goToEnd();

		System.out.println();
		listIterator2.add("Last Item");
		listIterator2.goToBegin();
		System.out.println("Testing methode add() fin list Last Item ");
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {
			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------

		listIterator2.goToBegin();
		listIterator2.next();
		listIterator2.next();
		listIterator2.next();
		listIterator2.next();
		listIterator2.next();
		listIterator2.remove();
		System.out.println();
		listIterator2.goToBegin();
		System.out.println("Testing methode remove() UHUUUUUUUUU (5)");
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {
			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------
		System.out.println();
		listIterator2.goToBegin();
		listIterator2.next();
		listIterator2.remove();
		System.out.println();
		listIterator2.goToBegin();
		System.out.println("Testing methode remove() First Item ");
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {
			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------
		System.out.println();
		listIterator2.goToEnd();

		listIterator2.remove();
		System.out.println();
		listIterator2.goToBegin();
		System.out.println("Testing methode remove() Last item");
		System.out.println("HasNext? " + listIterator2.hasNext());
		System.out.println("ordre direct");
		System.out.print("[ ");
		while (listIterator2.hasNext()) {
			System.out.print(listIterator2.next() + " ");
		}
		System.out.println("]");
		System.out.println();

//		------------------------------------------------------------------------------------------
		System.out.println();
		listIterator2.goToBegin();
		System.out.println("Testing Exception pour le method remove()");
		try {
			listIterator2.remove();
		} catch (LCInvalidAccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		listIterator2.goToBegin();
		System.out.println();

	}

}
