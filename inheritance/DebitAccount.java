package inheritance;

public class DebitAccount extends AbstractAccount {

	public DebitAccount(){
		super();
	}
	
	@Override
	protected void internalWithdraw(double amount) {
		if ((balance - amount) < 0) {
			throw new IllegalStateException("Ikke nok penger på konto..");
		}
		balance -= amount;
	}

}
