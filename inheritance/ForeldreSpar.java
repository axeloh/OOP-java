package inheritance;

public class ForeldreSpar extends SavingsAccount {

	private int legalWithrawals;
	private int remainingWithdrawals;
	
	public ForeldreSpar(double interestRate, int legalWithrawals) {
		super(interestRate);
		this.legalWithrawals = legalWithrawals;
		this.remainingWithdrawals = legalWithrawals;
	}
	
	public void withdraw(double amount) {
		if (remainingWithdrawals <= 0) {
			throw new IllegalStateException("Ingen flere uttak mulig dette året.");
		}
		super.withdraw(amount);
		remainingWithdrawals --;
	}
	
	public int getRemainingWithdrawals() {
		return remainingWithdrawals;
	}
	
	public void endYearUpdate() {
		super.endYearUpdate();
		remainingWithdrawals = legalWithrawals;
		
	}
	
	public static void main(String[] args) {
		SavingsAccount fp1 = new ForeldreSpar(0.03, 3);
		fp1.deposit(20000);
		fp1.withdraw(10000);
		int a = ((ForeldreSpar) fp1).getRemainingWithdrawals(); 
		System.out.println(a);
		fp1.withdraw(2000);
		System.out.println(((ForeldreSpar) fp1).getRemainingWithdrawals());
		fp1.withdraw(500);
		System.out.println(((ForeldreSpar) fp1).getRemainingWithdrawals());
		System.out.println(fp1.getBalance());
		fp1.endYearUpdate();
		System.out.println(fp1.getBalance());
		fp1.withdraw(500);
		System.out.println(((ForeldreSpar) fp1).getRemainingWithdrawals());
	}
	

}
