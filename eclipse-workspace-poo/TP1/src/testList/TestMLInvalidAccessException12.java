package testList;

import java.util.Arrays;

import pack.MyList;
import pack.MyListIterator;

public class TestMLInvalidAccessException12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyList<String> x1 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator1 = new MyListIterator<>(x1);
		System.out.println("### Test 01 - Invalid previous() call: hasPrevious() false ### ");
		System.out.println("Valeur de la liste x1 : " + Arrays.deepToString(x1.toArray()));
		iterator1.goToBegin();
		System.out.println("Valeur du premier registre: " + iterator1.getCur().getData());
		iterator1.previous();
		System.out.println("Lancer l'exception: Invalid previous() call: hasPrevious() false ");
		iterator1.previous();

	}

}
