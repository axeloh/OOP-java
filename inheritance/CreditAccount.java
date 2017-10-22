package inheritance;

public class CreditAccount extends AbstractAccount {

	private double creditLine;
	
	public CreditAccount(double creditLine) {
		super();
		setCreditLine(creditLine);
	}
	
	@Override
	protected void internalWithdraw(double amount) {
		if ((balance + creditLine - amount) < 0) {
			throw new IllegalStateException("Ikke nok penger på konto (kreditt inkl.)");
		}
		balance -= amount;

		}

	public void setCreditLine(double creditLine) {
		if (creditLine <= 0) {
			throw new IllegalArgumentException("Kredittlinjen må være positiv.");
		}
		if (balance + creditLine < 0) {
			throw new IllegalStateException("Kreditt + balansen må være positiv.");
		}
		this.creditLine = creditLine;
	}
	
	public double getCreditLine() {
		return creditLine;
	}

}
