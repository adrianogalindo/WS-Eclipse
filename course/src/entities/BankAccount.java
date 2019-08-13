package entities;

public class BankAccount {
	private int accountNumber;
	private String accountUserName;
	private double accountChequing;
	
	public BankAccount() {
	} 
	
	public BankAccount(int accountNumber, String accountUserName, double initialDeposit) {
		this.accountNumber = accountNumber;
	    this.accountUserName = accountUserName;
		depositChequing(initialDeposit);
	} 
	
	public BankAccount(int accountNumber, String accountUserName) {
		this.accountNumber = accountNumber;
		this.accountUserName = accountUserName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountUserName() {
		return accountUserName;
	}

	public void setAccountUserName(String accountUserName) {
		this.accountUserName = accountUserName;
	}

	public double getAccountChequing() {
		return accountChequing;
	}
	
	public void depositChequing(double deposit) {
		accountChequing += deposit;
	}
	
	public void withdrawChequing(double withdraw) {
		accountChequing -= withdraw + 5.00;
	}

	
	public String toString() {
		return "Account " + getAccountNumber()
		+ ", Holder: "
		+ getAccountUserName()
		+ ", Balance:   $ "
		+ String.format("%.2f", getAccountChequing());
	}

	
	
	
	
	
	
	
	
}
