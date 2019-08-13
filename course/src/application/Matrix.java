package application;

import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int m = sc.nextInt();
		final int n = sc.nextInt();
		
		int[][] mat = new int[m][n];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		int number = sc.nextInt();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == number) {
					System.out.printf("Position %d,%d%n", i,j);
					if (j > 0) {System.out.println("Left: " + mat[i][j-1]);}
					if (i > 0) {System.out.println("Up: " + mat[i-1][j]);}
					if (j < mat[i].length-1) {System.out.println("Right: " + mat[i][j+1]);}
					if (i < mat.length-1) {System.out.println("Down: " + mat[i+1][j]);}
				}
			}
		}
		
		
		sc.close();
	}

}
