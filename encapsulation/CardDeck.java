package encapsulation;
import java.util.ArrayList;
import  encapsulation.Card;

public class CardDeck {
	
	private ArrayList<Card> deck;
	
	
	public CardDeck(int n) {
		ArrayList<Card> deck = new ArrayList<Card>();
		for (int i = 1; i <= n; i++) {
			Card card = new Card('S', i);
			deck.add(card);	
		}
		for (int i = 1; i <= n; i++) {
			Card card = new Card('H', i);
			deck.add(card);
		}
		for (int i = 1; i <= n; i++) {
			Card card = new Card('D', i);
			deck.add(card);	
		}
		for (int i = 1; i <= n; i++) {
			Card card = new Card('C', i);
			deck.add(card);	
		}
		
		this.deck = deck;
		
	}
	
	public int getCardCount() {
		return deck.size();
	}
	
	public Card getCard(int n) {
		if (n >= 0 && n <= deck.size()) {
			return deck.get(n);
		}
		throw new IllegalArgumentException("Enter a valid number.");
	}
	
	public void shufflePerfectly() {
		int half_index = getCardCount()/2;
		ArrayList<Card> firstHalf = new ArrayList<Card>();
		ArrayList<Card> secondHalf = new ArrayList<Card>();
		for (int i = 0; i <= half_index - 1; i++) {
			firstHalf.add(getCard(i));
			secondHalf.add(getCard(half_index + i));
		}
		System.out.println(firstHalf);
		System.out.println(secondHalf);
		
		ArrayList<Card> shuffled = new ArrayList<Card>();
		for (int i = 0; i < half_index; i++) {
			Card kort1 = firstHalf.get(i);
			shuffled.add(kort1);
			Card kort2 = secondHalf.get(i);
			shuffled.add(kort2);
		}
		this.deck = shuffled;
	}
	
	public String toString() {
		return String.format("%s", deck);
	}
	

	}

		 

		
