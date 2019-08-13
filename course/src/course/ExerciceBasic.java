package course;

import java.util.Locale;
import java.util.Scanner;

public class ExerciceBasic {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Exec�cio 02 (iniciante)");
		double pi = 3.14159;
		double raio = sc.nextDouble();
		
		double area = pi * raio * raio;
		
		System.out.printf("%.4f%n", area);
		
		
		
		System.out.println("Exec�cio 03 (iniciante)");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int diferenca = a * b - c * d;
		
		System.out.println(diferenca);
		
		
		System.out.println("Exec�cio 04 (iniciante)");
		
		int numeroFuncionario = sc.nextInt();
		int numeroHorasTrabalhada = sc.nextInt();
		double valorHoraDeTrabalho = sc.nextDouble();
		
		System.out.println("NUMBER = " + numeroFuncionario);
		System.out.printf("SALARY = U$ %.2f%n", (double) numeroHorasTrabalhada * valorHoraDeTrabalho);
		
		
		System.out.println("Exec�cio 05 (iniciante)");
		//int codigoPeca1 = sc.nextInt();
		int quantidadePeca1 = sc.nextInt();
		double valorPeca1 = sc.nextDouble();
		//int codigoPeca2 = sc.nextInt();
		int quantidadePeca2 = sc.nextInt();
		double valorPeca2 = sc.nextDouble();
		
		double total = (double) quantidadePeca1 * valorPeca1 + quantidadePeca2 * valorPeca2;
		
		System.out.printf("VALOR A PAGAR: R$ %.2f%n", total);
		
		
		sc.close();
	}

}
