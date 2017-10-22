package encapsulation;
import java.util.HashMap;

public class Nim {
	
	HashMap<Integer, Integer> piles = new HashMap<Integer, Integer>();
	
	public Nim(int pileSize) {
		setPiles(pileSize);
	}
	
	public Nim() {
		setPiles(10);
	}
	
	 
	 public void setPiles(int pileSize) {
		 this.piles.put(0, pileSize);
		 this.piles.put(1, pileSize);
		 this.piles.put(2, pileSize);
	 }
	
	public void removePieces(int number, int targetPile) {
		if (isGameOver()) {
			throw new IllegalStateException("Spillet er over!");
		}
		else if ((targetPile != 0) && (targetPile != 1) && (targetPile != 2)) {
			throw new IllegalArgumentException("Oppgi gyldig targetPile/haug.");
		}
		else if (number < 1) {
			throw new IllegalArgumentException("Nummer må være mer enn 1,");
		}
		else if (isValidMove(number, targetPile) == false){
			throw new IllegalArgumentException("Ugyldig trekk");
		}
		this.piles.put(targetPile, piles.get(targetPile) - number);
	}
	
	public boolean isValidMove(int number, int targetPile) {
		if (targetPile != 0 && targetPile != 1 && targetPile != 2) {
			return false;
		}
		else if (number > this.piles.get(targetPile)) {
			return false;
		}
		else if (number < 1) {
			return false;
		}
		else if (isGameOver()) {
			return false;
		}
		return true;
	}
	
	public boolean isGameOver() {
		for (int i = 0; i < 3; i++) {
			if (this.piles.get(i) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public int getPile(int targetPile) {
		return this.piles.get(targetPile);
	}	
	
	public String toString() {
		return String.format("Pile 0 has %s bricks\nPile 1 has %s bricks\nPile 2 has %s piles\n", piles.get(0), piles.get(1),
				piles.get(2));
	}
	
	public static void main(String[] args) {
		Nim spill1 = new Nim(5);
		System.out.println(spill1);
		spill1.removePieces(4, 0);
		System.out.println(spill1);
		spill1.removePieces(6, 0);
		System.out.println(spill1);
		System.out.println(spill1.isValidMove(6, 0));
		
	}
}

