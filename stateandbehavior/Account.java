package stateandbehavior;

public class Account {
	
	private double balance;
	private double interestRate;
	
	
	public Account(double startBalance, double startRate) {
		balance = startBalance;
		interestRate = startRate;
		
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
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
		interestRate = rate;
			
	}
	
	public String toString() {
		
		return String.format("Beløpet på konto er nå %s, renta er %s prosent.", balance, interestRate);
		
	}
	
	
	public static void main(String[] args) {
		
		Account account1 = new Account(300, 5);
		account1.deposit(500);
		account1.addInterest();
		account1.getBalance();
		System.out.println(account1);
		account1.getInterestRate();
		account1.setInterestRate(3);
		
		Account account2 = new Account(200, 3);
		account1.deposit(343);
		account2.addInterest();
		account2.getBalance();
		System.out.println(account2);
		account2.getInterestRate();	
		account2.setInterestRate(3);
		
	}

}

