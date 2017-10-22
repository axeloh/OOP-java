package interfaces;
import java.util.ArrayList;
import java.util.Iterator;

public class CardHand implements CardContainer, Iterable<Card> {
	
private ArrayList<Card> hand = new ArrayList<Card>();
	
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
		hand.add(card);
	}
	
	public Card play(int n) {
		Card card = hand.get(n);
		hand.remove(n);
		return card;
	}
	

}

