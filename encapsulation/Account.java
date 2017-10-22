package encapsulation;

public class Account {
	
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate) {
		if ((balance < 0) || (interestRate < 0)) {
			throw new IllegalArgumentException("Both balance and rent must be positive values.");
		}
		else {
			this.balance = balance;
			this.interestRate = interestRate;
		}
	}
	
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("You can only deposit a positive value.");
		}
		else {
			this.balance += amount;
		}
		
	} 
	
	public void addInterest() {
		double rent = (interestRate/100);
		balance += balance*rent;
		
	} 
	
	public double getBalance() {
		return balance;
		
	} 
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double rate) {
		if (rate < 0) {
			throw new IllegalArgumentException("The rate must be a positive value.");
		}
		else {
			interestRate = rate;
		}
			
	}
	
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("You can only withdraw a positive value.");
		}
		
		else if ((this.balance - amount) < 0) {
			throw new IllegalArgumentException("Cannot withdraw because your balance isn't high enough.");
		}
		
		else {
			this.balance -= amount;
		}
	}
	
	public String toString() {
		
		return String.format("Beløpet på konto er nå %s, renta er %s prosent.", balance, interestRate);
		
	}
	
	

}
