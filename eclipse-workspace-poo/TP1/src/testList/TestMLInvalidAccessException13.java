package testList;

import java.util.Arrays;

import pack.MyList;
import pack.MyListIterator;

public class TestMLInvalidAccessException13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyList<String> x1 = new MyList<>();
		MyListIterator<String> iterator1 = new MyListIterator<>(x1);
		System.out.println("### Test 01 - Invalid set(T v) call: undefined current position ### ");
		System.out.println("Valeur de la liste x1 : " + Arrays.deepToString(x1.toArray()));
		System.out.println("Lancer l'exception: Invalid set(T v) call: undefined current position ");
		iterator1.set("Thiago");

	}

}
