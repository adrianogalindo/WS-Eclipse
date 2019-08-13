package pack;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void preOrderDepth(MyBinaryTree bt) {

		if (!bt.isEmpty()) {
			System.out.println(bt.root());
			if (!bt.leftChild().isEmpty()) {
				preOrderDepth(bt.leftChild());
			}
			if (!bt.rightChild().isEmpty()) {
				preOrderDepth(bt.rightChild());
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("====================================================================");
		System.out.println("                MyBinaryTree - Validation Methode isEmpty");
		System.out.println("====================================================================");
		System.out.println("### Test 01 - Arbre Vide### ");
		MyBinaryTree<String> current = new MyBinaryTree<>();
		System.out.println("Arbre isEmpty: = " + current.isEmpty());
		System.out.println();

		System.out.println("### Test 02 - Arbre non Vide### ");
		MyBinaryTree<String> current1 = new MyBinaryTree<>("A");
		System.out.println("Arbre isEmpty: = " + current1.isEmpty());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("                MyBinaryTree - Validation Exception Invalid root()");
		System.out.println("====================================================================");
		System.out.println("### Test 01 - Root en arbre Vide### ");
		MyBinaryTree<String> current2 = new MyBinaryTree<>();
		System.out.println("Lancer Exception: Invalid root() call: empty tree");
		try {
			System.out.println("Arbre isEmpty: = " + current2.root());
		} catch (Exception e) {
			System.out.println(e);

		}
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("                MyBinaryTree - Validation Methode root");
		System.out.println("====================================================================");
		System.out.println("### Test 01 - Root en arbre non Vide### ");
		MyBinaryTree<String> current3 = new MyBinaryTree<>("A");
		System.out.println("Valeur de root: = " + current3.root());
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("                MyBinaryTree - Validation preOrderDepth");
		System.out.println("====================================================================");
		System.out.println("### Test 01 ### ");
		MyBinaryTree<String> current4 = new MyBinaryTree<>("A");
		System.out.println("Valeur de root: " + current4.data);
		current4.leftChild = new MyBinaryTree<>("B");
		current4.rightChild = new MyBinaryTree<>("C");
		current4.leftChild.leftChild = new MyBinaryTree<>("D");
		current4.leftChild.rightChild = new MyBinaryTree<>("E");
		current4.rightChild.leftChild = new MyBinaryTree<>("F");
		current4.rightChild.rightChild = new MyBinaryTree<>("G");
		preOrderDepth(current4);
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("                MyBinaryTree - Validation Exception Invalid append()");
		System.out.println("====================================================================");
		System.out.println("### Test 01 - Invalid append() call: not in a leaf (not in an empty tree) ### ");
		MyBinaryTree<String> current5 = new MyBinaryTree<>("A");
		System.out.println("Valeur de root: " + current5.data);
		System.out.println("Lancer Exception: Invalid append() call: not in a leaf (not in an empty tree)");
		try {
			current5.append("B");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("                MyBinaryTree - Validation leftChild");
		System.out.println("====================================================================");
		System.out.println("### Test 01 ### ");
		MyBinaryTree<String> current6 = new MyBinaryTree<>("A");
		System.out.println("Valeur de root: " + current6.data);
		current6.leftChild = new MyBinaryTree<>("B");
		current6.rightChild = new MyBinaryTree<>("C");
		System.out.println("Valeur leftChild: " + current6.leftChild.data);
		System.out.println();

		System.out.println("====================================================================");
		System.out.println("                MyBinaryTree - Validation rightChild");
		System.out.println("====================================================================");
		System.out.println("### Test 01 ### ");
		MyBinaryTree<String> current7 = new MyBinaryTree<>("A");
		System.out.println("Valeur de root: " + current7.data);
		current7.leftChild = new MyBinaryTree<>("B");
		current7.rightChild = new MyBinaryTree<>("C");
		System.out.println("Valeur rightChild: " + current7.rightChild.data);
		System.out.println();

	}

}
