package testList;

import java.util.Arrays;

import pack.MyList;
import pack.MyListIterator;

public class TestMLInvalidAccessException2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyList<String> x1 = new MyList<>();
		System.out.println("### Test 01 - Invalid end() call: empty list ### ");
		System.out.println("Valeur de la liste x1 : " + Arrays.deepToString(x1.toArray()));
		System.out.println("Lancer l'exception: Invalid end() call: empty list ");
		System.out.println(x1.end());

	}

}
