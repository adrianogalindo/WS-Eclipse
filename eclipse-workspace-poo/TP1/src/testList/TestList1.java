package testList;

import java.util.Arrays;

import pack.MyList;
import pack.MyListIterator;

public class TestList1 {

	public static void main(final String[] args) {

		// TODO Auto-generated method stub

		System.out.println("====================================================================");
		System.out.println("                MyList - Validation Methode isEmpty");
		System.out.println("====================================================================");
		System.out.println("### Test 01 - Liste Vide### ");
		MyList<String> x1 = new MyList<>();
		System.out.println("Liste isEmpty: = " + x1.isEmpty());
		System.out.println();

		System.out.println("### Test 02 - Liste non Vide ### ");
		MyList<String> x1a = new MyList<>("Antonio");
		System.out.println("Creation d'une liste avec un registre ");
		System.out.println("Liste isEmpty: = " + x1a.isEmpty());
		System.out.println("Taille de la liste: " + x1a.size());
		System.out.println("Valeur de la liste x1a: " + Arrays.deepToString(x1a.toArray()));
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("               MyList - Validation Methode Object[] toArray");
		System.out.println("====================================================================");
		System.out.println("### Test 01 ### ");
		MyList<String> x2 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		System.out.println("Creation d'une liste avec un array ");
		System.out.println("Taille de la liste: " + x2.size());
		System.out.println("Valeur du premier registre: " + x2.getData());
		System.out.println("Valeur de la liste x2: " + Arrays.deepToString(x2.toArray()));
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("               MyList - Validation Methode ListCopy");
		System.out.println("====================================================================");
		System.out.println("### Test 01 ### ");
		MyList<String> x3 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyList<String> x3a = new MyList<>();
		System.out.println("Valeur de la liste x3 avant le copy: " + Arrays.deepToString(x3.toArray()));
		System.out.println("Valeur de la liste x3a avant le copy: " + Arrays.deepToString(x3a.toArray()));
		x3a = x3.copy();
		System.out.println("Valeur de la liste x3 apres le copy: " + Arrays.deepToString(x3.toArray()));
		System.out.println("Valeur de la liste x3a apres le copy: " + Arrays.deepToString(x3a.toArray()));
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("               MyList - Validation Methode Head");
		System.out.println("====================================================================");
		System.out.println("### Test 01 ### ");
		MyList<String> x4 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		System.out.println("Valeur de la liste x4 : " + Arrays.deepToString(x4.toArray()));
		System.out.println("Valeur de data: " + x4.getData());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("               MyList - Validation Methode Tail");
		System.out.println("====================================================================");
		System.out.println("### Test 01 ### ");
		MyList<String> x5 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		System.out.println("Valeur de la liste x5 : " + Arrays.deepToString(x5.toArray()));
		System.out.println("Valeur du premier registre: " + x5.getData());
		System.out.println("Valeur de tail: " + x5.tail().getData());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("               MyList - Validation Methode End");
		System.out.println("====================================================================");
		System.out.println("### Test 01 ### ");
		MyList<String> x6 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		System.out.println("Valeur de la liste x6 : " + Arrays.deepToString(x6.toArray()));
		System.out.println("Valeur de dernier registre: " + x6.end());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("               MyList - Validation Methode Append");
		System.out.println("====================================================================");
		MyList<String> x7 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		System.out.println("### Test 01 ### ");
		System.out.println("Valeur de la liste x7 avant l'Append: " + Arrays.deepToString(x7.toArray()));
		System.out.println("Test constructor ");
		x7.append("Thiago");
		System.out.println("Valeur de la liste x7 apres l'Append: " + Arrays.deepToString(x7.toArray()));
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("               MyList - Validation Methode Concat");
		System.out.println("====================================================================");
		MyList<String> x8 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyList<String> x8a = new MyList<>(new String[] { "Bruno", "Fred", "Carol" });
		System.out.println("### Test 01 ### ");
		System.out.println("Valeur de la liste x8 avant le concat: " + Arrays.deepToString(x8.toArray()));
		System.out.println("Valeur de la liste x8a avant le concat: " + Arrays.deepToString(x8a.toArray()));
		x8.concat(x8a);
		System.out.println("Valeur de la liste x8 apres le concat: " + Arrays.deepToString(x8.toArray()));
		System.out.println("Valeur de la liste x8a apres le concat: " + Arrays.deepToString(x8a.toArray()));
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("            MyListIterator - Validation Methode hasNext");
		System.out.println("====================================================================");
		MyList<String> x9 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator1 = new MyListIterator<>(x9);
		System.out.println("### Test 01 ### ");
		System.out.println("Valeur de la liste x9 : " + Arrays.deepToString(x9.toArray()));
		System.out.println("Valeur du première registre: " + x9.getData());
		System.out.println("Validation si il y a hasNext: " + iterator1.hasNext());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("            MyListIterator - Validation Methode Next");
		System.out.println("====================================================================");
		MyList<String> x10 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator2 = new MyListIterator<>(x10);
		System.out.println("### Test 01 ### ");
		System.out.println("Valeur de la liste x10 : " + Arrays.deepToString(x10.toArray()));
		System.out.println("Valeur du première registre: " + x10.getData());
		System.out.println("Validation si il y a hasNext: " + iterator2.hasNext());
		iterator2.next();
		System.out.println("Valeur du registre prochaine: " + iterator2.next());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("            MyListIterator - Validation Methode hasPrevius");
		System.out.println("====================================================================");
		MyList<String> x11 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator3 = new MyListIterator<>(x11);
		System.out.println("### Test 01 ### ");
		System.out.println("Valeur de la liste x11 : " + Arrays.deepToString(x11.toArray()));
		System.out.println("Valeur du première registre: " + x11.getData());
		System.out.println("Validation si il y a hasPrevious: " + iterator3.hasPrevious());
		System.out.println("### Test 02 ### ");
		System.out.println("Valeur de la liste x11 : " + Arrays.deepToString(x11.toArray()));
		iterator3.next();
		System.out.println("Valeur du registre prochaine: " + iterator3.next());
		System.out.println("Validation si il y a hasPrevious: " + iterator3.hasPrevious());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("            MyListIterator - Validation Methode Previus");
		System.out.println("====================================================================");
		MyList<String> x12 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator4 = new MyListIterator<>(x12);
		System.out.println("### Test 01 ### ");
		System.out.println("Valeur de la liste x12 : " + Arrays.deepToString(x12.toArray()));
		System.out.println("Valeur du première registre: " + x12.getData());
		iterator4.next();
		System.out.println("Valeur du registre prochaine: " + iterator4.next());
		iterator4.previous();
		System.out.println("Valeur du registre precedent: " + iterator4.previous());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("            MyListIterator - Validation Methode goToBegin");
		System.out.println("====================================================================");
		MyList<String> x13 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator5 = new MyListIterator<>(x13);
		System.out.println("### Test 01 ### ");
		System.out.println("Valeur de la liste x13 : " + Arrays.deepToString(x13.toArray()));
		System.out.println("Valeur du première registre: " + x13.getData());
		iterator5.next();
		System.out.println("Valeur du registre apres next : " + iterator5.next());
		System.out.println("Valeur du registre apres autre next : " + iterator5.next());
		iterator5.goToBegin();
		System.out.println("Valeur du registre apres goToBegin: " + iterator5.getCur().getData());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("            MyListIterator - Validation Methode goToEnd");
		System.out.println("====================================================================");
		MyList<String> x14 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator6 = new MyListIterator<>(x14);
		System.out.println("### Test 01 ### ");
		System.out.println("Valeur de la liste x14 : " + Arrays.deepToString(x14.toArray()));
		System.out.println("Valeur du première registre: " + x14.getData());
		iterator6.goToEnd();
		System.out.println("Valeur du registre apres goToEnd: " + iterator6.getCur().getData());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("            MyListIterator - Validation Methode Set");
		System.out.println("====================================================================");
		MyList<String> x15 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator7 = new MyListIterator<>(x15);
		System.out.println("### Test 01 ### ");
		System.out.println("Valeur de la liste x15 : " + Arrays.deepToString(x15.toArray()));
		iterator7.goToBegin();
		System.out.println("Valeur du première registre: " + iterator7.getCur().getData());
		System.out.println("Executer le methode set avec la valeur Thiago");
		iterator7.set("Thiago");
		System.out.println("Valeur de la liste x15 apres le set: " + Arrays.deepToString(x15.toArray()));
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("            MyListIterator - Validation Methode Add");
		System.out.println("====================================================================");
		MyList<String> x16 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator8 = new MyListIterator<>(x16);
		System.out.println("### Test 01 - Add en debut de la liste ### ");
		System.out.println("Valeur de la liste x16 : " + Arrays.deepToString(x16.toArray()));
		System.out.println("Executer le methode add avec la valeur Thiago");
		iterator8.add("Thiago");
		System.out.println("Valeur de la liste x16 apres le add: " + Arrays.deepToString(x16.toArray()));
		System.out.println();

		MyList<String> x16a = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator8a = new MyListIterator<>(x16a);
		System.out.println("### Test 02 Add en fin de la liste ### ");
		System.out.println("Valeur de la liste x16a : " + Arrays.deepToString(x16a.toArray()));
		iterator8a.goToEnd();
		System.out.println("Valeur du dernière registre: " + iterator8a.getCur().getData());
		System.out.println("Executer le methode add avec la valeur Thiago");
		iterator8a.add("Thiago");
		System.out.println("Valeur de la liste x16 apres le add: " + Arrays.deepToString(x16a.toArray()));
		System.out.println();

		MyList<String> x16b = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator8b = new MyListIterator<>(x16b);
		System.out.println("### Test 03 - Add en la deuxième position de la liste ### ");
		System.out.println("Valeur de la liste x16b : " + Arrays.deepToString(x16b.toArray()));
		iterator8b.goToBegin();
		System.out.println("Valeur du première registre: " + iterator8b.getCur().getData());
		System.out.println("Executer le methode add avec la valeur Thiago");
		iterator8b.add("Thiago");
		System.out.println("Valeur de la liste x16b apres le add: " + Arrays.deepToString(x16b.toArray()));
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("            MyListIterator - Validation Methode Remove");
		System.out.println("====================================================================");
		MyList<String> x17 = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator9 = new MyListIterator<>(x17);
		System.out.println("### Test 01 - Remove en debut de la liste ### ");
		System.out.println("Valeur de la liste x17 : " + Arrays.deepToString(x17.toArray()));
		iterator9.goToBegin();
		iterator9.remove();
		System.out.println("Valeur de la liste x17 apres le remove: " + Arrays.deepToString(x17.toArray()));
		System.out.println();

		MyList<String> x17a = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator9a = new MyListIterator<>(x17a);
		System.out.println("### Test 02 Remove en fin de la liste ### ");
		System.out.println("Valeur de la liste x17a : " + Arrays.deepToString(x17a.toArray()));
		iterator9a.goToEnd();
		System.out.println("Valeur du dernière registre: " + iterator9a.getCur().getData());
		iterator9a.remove();
		System.out.println("Valeur de la liste x17 apres le remove: " + Arrays.deepToString(x17a.toArray()));
		System.out.println();

		MyList<String> x17b = new MyList<>(new String[] { "Antonio", "Gabriel", "Ialo", "Adriano" });
		MyListIterator<String> iterator9b = new MyListIterator<>(x17b);
		System.out.println("### Test 03 - Remove en la deuxième position de la liste ### ");
		System.out.println("Valeur de la liste x17b : " + Arrays.deepToString(x17b.toArray()));
		iterator9b.goToBegin();
		System.out.println("Valeur du première registre: " + iterator9b.getCur().getData());
		iterator9b.next();
		System.out.println("Valeur du deuxième registre: " + iterator9b.getCur().getData());
		iterator9b.remove();
		System.out.println("Valeur de la liste x17b apres le remove: " + Arrays.deepToString(x17b.toArray()));

	}
}
