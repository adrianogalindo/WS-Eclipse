package application;

import entities.MyBinaryTree;
import exception.MBTInvalidAccessException;

public class ExceptionRootTest {
	
	public static void main(String[] args) {
		MyBinaryTree<String> racine = new MyBinaryTree<String>();
		try {
			racine.root();
		} catch (MBTInvalidAccessException e) {
			System.out.println("Exception occurred: "  + e.getMessage());
		}


		
		
	}

}
