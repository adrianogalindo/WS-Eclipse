package application;

import entities.MyBinaryTree;

public class Program {
	public static void main(String[] args) {
		
		MyBinaryTree<String> racine = new MyBinaryTree<String>("Adriano Galindo");
		
//		------------------------------------------------------------------------------------------
		MyBinaryTree<String> currentConstructeur = new MyBinaryTree<String>();
		System.out.println("Teste du premier constructeur ");
		System.out.println(" currentConstructeur.data = " + currentConstructeur.data);
		System.out.println(" currentConstructeur.leftChild = " + currentConstructeur.leftChild);
		System.out.println(" currentConstructeur.rightChild = " + currentConstructeur.rightChild);
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		MyBinaryTree<String> currentConstructeurNonVide = new MyBinaryTree<String>("Adriano Galindo");
		System.out.println("Teste du deuxième constructeur ");
		System.out.println(" currentConstructeur.data = " + currentConstructeurNonVide.data);
		System.out.println(" currentConstructeur.leftChild = " + currentConstructeurNonVide.leftChild.isEmpty());
		System.out.println(" currentConstructeur.rightChild = " + currentConstructeurNonVide.rightChild.isEmpty());
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		System.out.println("Teste du methode root(), append(), leftChild() et  rightChild");
		MyBinaryTree<String> testCurrent= racine;
		testCurrent=testCurrent.rightChild();
		testCurrent.append ("Alessandra Nishikawa");
		testCurrent=testCurrent.leftChild();
		testCurrent.append("Ramiro Guerreiro");
		testCurrent = racine;
		System.out.println(" currentConstructeur = " + testCurrent.root());
		testCurrent=testCurrent.rightChild();
		System.out.println(" currentConstructeur = " + testCurrent.root());
		testCurrent=testCurrent.leftChild();
		System.out.println(" currentConstructeur = " + testCurrent.root());
		System.out.println();
		
//		------------------------------------------------------------------------------------------
		
	}

}
