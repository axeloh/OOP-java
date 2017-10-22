package interfaces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Card implements Comparable<Card> {
	private char cardSuit;
	private int cardValue;
	List<Card> cards = new ArrayList<Card>();
	
	public Card(char cardSuit, int cardValue) {
		checkCard(cardSuit, cardValue);
		this.cardSuit = cardSuit;
		this.cardValue = cardValue;	
	}
	
	public int compareTo(Card card) {
		List<Character> a = Arrays.asList('S', 'H', 'D', 'C');
		int b = a.indexOf(this.getSuit());
		int c = a.indexOf(card.getSuit());
		if (b < c) {
			return 1;
		}
		else if (b > c) {
			return -1;
		}
		else {
			if (this.getFace() > card.getFace()) {
				return 1;
			}
			return -1;
		}
		
		
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
		String a = "";
		for (int i = 0; i < cards.size(); i++) {
			a += String.format("%s%s" + " | ", cards.get(i).cardSuit, cards.get(i).cardValue);
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		Card card1 = new Card('S', 5);
		Card card2 = new Card('S', 4);
		Card card3 = new Card('H', 5);
		Card card4 = new Card('C', 13);
		Card card5 = new Card('S', 9);
		card1.cards.add(card1);
		card1.cards.add(card2);
		card1.cards.add(card3);
		card1.cards.add(card4);
		card1.cards.add(card5);
		System.out.println(card1);
		Collections.sort(card1.cards);
		System.out.println(card1);
		
		
		
	}

	

}
