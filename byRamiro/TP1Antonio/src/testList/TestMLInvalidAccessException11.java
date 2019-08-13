package testList;

import java.util.Arrays;

import pack.MyList;
import pack.MyListIterator;

public class TestMLInvalidAccessException11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyList<String> x1 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator1 = new MyListIterator<>(x1);
		System.out.println("### Test 01 - Invalid next() call: hasNext() false ### ");
		System.out.println("Valeur de la liste x1 : " + Arrays.deepToString(x1.toArray()));
		iterator1.goToEnd();
		System.out.println("Valeur du dernière registre: " + iterator1.getCur().getData());
		iterator1.next();
		System.out.println("Lancer l'exception: Invalid next() call: hasNext() false ");
		iterator1.next();

	}

}
