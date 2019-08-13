package testList;

import java.util.Arrays;

import pack.MyList;
import pack.MyListIterator;

public class TestMLInvalidAccessException14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyList<String> x1 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator1 = new MyListIterator<>(x1);
		System.out.println("### Test 01 - Invalid remove() call: undefined current position ### ");
		System.out.println("Valeur de la liste x1 : " + Arrays.deepToString(x1.toArray()));
		iterator1.goToEnd();
		System.out.println("Valeur du dernière registre: " + iterator1.getCur().getData());
		iterator1.remove();
		System.out.println("Valeur du registre precedent: " + iterator1.getCur().getData());
		iterator1.remove();
		System.out.println("Valeur du registre precedent: " + iterator1.getCur().getData());
		iterator1.remove();
		System.out.println("Valeur du registre precedent: " + iterator1.getCur().getData());
		iterator1.remove();
		System.out.println("Valeur du registre precedent: " + iterator1.getCur().getData());
		System.out.println("Lancer l'exception: Invalid remove() call: undefined current position ");
		iterator1.remove();

	}

}
