package inheritance;

public class SavingsAccount2 extends AbstractAccount {
	
	private int withdrawals;
	private double fee;
	
	public SavingsAccount2(int withdrawals, double fee) {
		super();
		this.withdrawals = withdrawals;
		this.fee = fee;
	}
	
	@Override
	protected void internalWithdraw(double amount) {
		if (balance - amount < 0) {
			throw new IllegalStateException("Ikke nok penger på konto.");
		}
		if (withdrawals <= 0) {
			if (balance - amount - fee < 0) {
				throw new IllegalStateException("Ikke nok penger på konto (gebyr inkl.)");
			}
			balance -= fee;
		}
		balance -= amount;
		withdrawals--;
	}
	
	

}
