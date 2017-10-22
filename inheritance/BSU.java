package inheritance;

public class BSU extends SavingsAccount {
	
	private double maxYearlyDeposit;
	private double thisYearsDeposits;

	public BSU(double interestRate, double maxYearlyDeposit) {
		super(interestRate);
		this.maxYearlyDeposit = maxYearlyDeposit;
	}
	
	public void deposit(double amount) {
		if ((thisYearsDeposits + amount) > maxYearlyDeposit) {
			throw new IllegalStateException("Du kan ikke sette inn over innskuddsgrensa.");
		}
		super.deposit(amount);
		thisYearsDeposits += amount;
	}
	
	public void withdraw(double amount) {
		if (amount > thisYearsDeposits) {
			throw new IllegalStateException("Du kan ikke ta ut mer enn årets innskudd.");
		}
		super.withdraw(amount);
		thisYearsDeposits -= amount;
	}
	
	public void endYearUpdate() {
		super.endYearUpdate();
		thisYearsDeposits = 0;
	}
	
	public double getTaxDeduction() {
		return 0.2*thisYearsDeposits;
	}
	
	public static void main(String[] args) {
		BSU bsu = new BSU(0.3, 20000);
		System.out.println(bsu instanceof SavingsAccount);
	}
	
	
	
	
	

}
