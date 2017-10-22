package inheritance;
import interfaces.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CardHand extends CardContainerImpl implements CardContainer, Iterable<Card> {
	
	private ArrayList<Card> hand; 
	

	public CardHand(int n) {
		super(n);
		hand = new ArrayList<Card>();
	}
	
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}

	public int getCardCount() {
		return hand.size();
	}
	
	public Card getCard(int n) {
		if (n >= 0 && n <= hand.size()) {
			return hand.get(n);
		}
		throw new IllegalArgumentException("Enter a valid number!");
	}
	
	public void addCard(Card card) {
		if (super.isOverMaxCardCount(getCardCount())) {
			throw new IllegalStateException("For mange kort. Du kan kun ha " + getCardCount() + " antall kort på hånda.");
		}
		hand.add(card);
	}
	
	public Card play(int n) {
		Card card = hand.get(n);
		hand.remove(n);
		return card;
	}
	

}

