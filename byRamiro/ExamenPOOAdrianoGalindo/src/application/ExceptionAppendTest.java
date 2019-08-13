package application;

import entities.MyBinaryTree;
import exception.MBTInvalidAccessException;

public class ExceptionAppendTest {
	public static void main(String[] args) {
		MyBinaryTree<String> racine = new MyBinaryTree<String>("Adriano Galindo");
			try {
				racine.append("Cavalcante Fonseca");
			} catch (MBTInvalidAccessException e) {
				System.out.println("Exception occurred: " + e.getMessage());
			}
		
		
	}

}
