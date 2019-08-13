package application;

import java.util.Locale;
import java.util.Scanner;
import entities.BankAccount;

public class ExerciceBankAccount {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter account number: ");
		int accountNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter account holder: ");
		String accountUserName= sc.nextLine();
		System.out.print("Is there na initial deposit (y/n)? ");
		char doDeposit = sc.next().charAt(0);
		
		BankAccount bankAccount;
		double amount;
		
		if (doDeposit == 'y') {
			System.out.print("Enter initial deposit value: ");
			amount = sc.nextDouble();
			bankAccount = new BankAccount(accountNumber, accountUserName, amount); 
		}
		else {
			bankAccount = new BankAccount(accountNumber, accountUserName); 
		}
		
		System.out.println();
		System.out.println("Account data:");
		System.out.println(bankAccount);
		
		System.out.println();
		System.out.print("Enter a deposit value: ");
		amount = sc.nextDouble();
		bankAccount.depositChequing(amount);
		System.out.println("Updated account data:");
		System.out.println(bankAccount);
		
		System.out.println();
		System.out.print("Enter a withdraw value: ");
		amount = sc.nextDouble();
		bankAccount.withdrawChequing(amount);
		System.out.println("Updated account data:");
		System.out.println(bankAccount);
		
		
		sc.close();
	}

}
