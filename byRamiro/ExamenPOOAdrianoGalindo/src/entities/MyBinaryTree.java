package entities;

import exception.MBTInvalidAccessException;

public class MyBinaryTree<T> {

	public T data;
	public MyBinaryTree<T> leftChild;
	public MyBinaryTree<T> rightChild;

	public MyBinaryTree() {
		this.data = null;
		this.leftChild = null;
		this.rightChild = null;
	}

	public MyBinaryTree(T v) {
		this.data = v;
		this.leftChild = new MyBinaryTree<T>();;
		this.rightChild = new MyBinaryTree<T>();;
	}

	public boolean isEmpty() { // retourne vrai si la MyBinaryTree est vide.
		return (this.data == null) && (this.leftChild == null) && (this.rightChild == null);
	}

	public T root() throws MBTInvalidAccessException { // retourne la valeur de « data » du neud current.
		if (this.isEmpty()) {
			throw new MBTInvalidAccessException(1);
		} else {
			return this.data;
		}
	}

	public MyBinaryTree<T> leftChild() { // retour l'arbre a gauche de MyBinaryTree. public T
		return this.leftChild;
	}

	public MyBinaryTree<T> rightChild() { // retour l'arbre a droit de MyBinaryTree. public T
		return this.rightChild;
	}

	public void append(T e) throws MBTInvalidAccessException { // transforme un arbre vide dans un arbre d’un seul nœud dont le champ « data » est v.
		MyBinaryTree<T> w = this;
		if (!w.isEmpty()) {
			throw new MBTInvalidAccessException(2);
		}
		this.data = e;
		w.leftChild = new MyBinaryTree<T>();
		w.rightChild = new MyBinaryTree<T>();
	}

}
