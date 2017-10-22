package inheritance;

public class SavingsAccount implements Account{
	
	protected double balance;
	protected double interestRate;
	
	public SavingsAccount(double interestRate) {
		this.interestRate = interestRate;
		balance = 0;
	}
	
	public void endYearUpdate() {
		balance += interestRate*balance;
	}
	
	@Override
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("You can only deposit a positive value.");
		}
		this.balance += amount;
		
	}

	@Override
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("You can only withdraw a positive value.");
		}
		
		else if ((this.balance - amount) < 0) {
			throw new IllegalStateException("Cannot withdraw because of lack of money..");
		}
		this.balance -= amount;
	}

	@Override
	public double getBalance() {
		return balance;
	}

}
