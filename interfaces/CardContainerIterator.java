package interfaces;
import java.util.Iterator;


public class CardContainerIterator implements Iterator<Card> {
	
	private int pos;
	private CardContainer obj;
	
	public CardContainerIterator(CardContainer obj) {
		this.obj = obj;
		pos = 0;
	}

	@Override
	public boolean hasNext() {
		if (pos > obj.getCardCount()) {
			return false;
		}
		return true;
	}

	@Override
	public Card next() {
		Card nextCard = obj.getCard(pos);
		pos++; 
		return nextCard;
	}
		
	
	

}
