package pack;

public class MyBinaryTree<T> {
	T data;
	MyBinaryTree<T> leftChild;
	MyBinaryTree<T> rightChild;

	public MyBinaryTree() {
		this.data = null;
		this.leftChild = null;
		this.rightChild = null;
	}

	public MyBinaryTree(T v) {
		this.data = v;
		this.leftChild = new MyBinaryTree<T>();
		this.rightChild = new MyBinaryTree<T>();
	}

	// retourne vrai si la MyBinaryTree est vide.
	public boolean isEmpty() {
		if (this.data != null || this.leftChild != null || this.rightChild != null) {
			return false;
		}
		return true;
		// return (this.data != null && this.leftChild != null && this.rightChild !=
		// null);

	}

	// retourne la valeur de « data » du nœud racine.
	public T root() throws MBTInvalidAccessException {
		if (this.data == null) {
			throw new MBTInvalidAccessException(1);
		}
		return this.data;

	}

	// retour la sub-arbre de gauche.
	public MyBinaryTree<T> leftChild() {
		return this.leftChild;

	}

	// retour la sub-arbre de droite.
	public MyBinaryTree<T> rightChild() {
		return this.rightChild;

	}

	// transforme un arbre vide dans un arbre d’un seul nœud dont le champ « data »
	// est v.
	public void append(T e) throws MBTInvalidAccessException {
		if (!this.isEmpty()) {
			throw new MBTInvalidAccessException(2);
		}
		this.data = e;
		this.leftChild = new MyBinaryTree<>();
		this.rightChild = new MyBinaryTree<>();

	}

}
