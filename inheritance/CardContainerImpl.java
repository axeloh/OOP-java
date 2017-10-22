package inheritance;
import interfaces.*;

public class CardContainerImpl implements CardContainer{
	
	protected int maxCardCount;
	
	public CardContainerImpl(int maxCardCount) {
		this.maxCardCount = maxCardCount;
		
	}
	
	public boolean isOverMaxCardCount(int n) {
		if (n >= getMaxCardCount()) {
			return true;
		}
		return false;
	}
	
	public int getMaxCardCount() {
		return maxCardCount;
	}
	
	@Override
	public int getCardCount() {
		return 0;
	}

	@Override
	public Card getCard(int n) {
		return null;
	}
	
	

}
