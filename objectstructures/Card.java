package objectstructures;

public class Card {
	
	private char cardSuit;
	private int cardValue;
	
	public Card(char cardSuit, int cardValue) {
		checkCard(cardSuit, cardValue);
		this.cardSuit = cardSuit;
		this.cardValue = cardValue;	
	}
	
	public void checkCard(char cardSuit, int cardValue) {
		if ((cardSuit != 'S') && (cardSuit != 'H') && (cardSuit != 'D') && (cardSuit != 'C')) {
			throw new IllegalArgumentException("Enter valid cardColour(S, H, D or C)");
		}
		else if (cardValue < 1 || cardValue > 13) {
			throw new IllegalArgumentException("Enter valid vardValue(integer between 1-13)");
		}
	}
	
	public char getSuit() {
		return cardSuit;
		
	}
	
	public int getFace() {
		return cardValue;
	}
	
	public String toString() {
		return String.format("%s%s", cardSuit, cardValue);
	}
	
	public static void main(String[] args) {
		Card card1 = new Card('S', 5);
		System.out.println(card1);
	}

}
