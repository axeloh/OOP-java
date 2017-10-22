package inheritance;

public abstract class AbstractAccount {
	
	protected double balance;
	
	protected AbstractAccount() {
		this.balance = 0;
	}
	
	protected void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("You can only deposit a positive value.");
		}
		this.balance += amount;
	}
	
	protected abstract void internalWithdraw(double amount);
	
	protected void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("You can only withdraw a positive value.");
		}
		internalWithdraw(amount);
	}
	
	protected double getBalance() {
		return balance;
	}
	
	
	
	
}
