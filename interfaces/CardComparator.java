package interfaces;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class CardComparator implements Comparator<Card> {
	
	private boolean ace;
	private char trumf;

	public CardComparator(boolean ace, char trumf) {
		this.ace = ace;
		this.trumf = trumf;
	}
	
	@Override
	public int compare(Card o1, Card o2) {
		int face1 = o1.getFace();
		int face2 = o2.getFace();
		char type1 = o1.getSuit();
		char type2 = o2.getSuit();
		
		if (type1 == trumf && type2 != trumf){
			return 1;
		}
		if (type2 == trumf && type1 != trumf){
			return -1;
		}
		if (ace == true){
			if (face1 != 1 && face2 != 1) {
				return o1.compareTo(o2);
			}
			List<Character> types = Arrays.asList('S', 'H', 'D', 'C');
			if (types.indexOf(type1) < types.indexOf(type2)){
				return 1;
			}
			if (types.indexOf(type1) > types.indexOf(type2)){
				return -1;
			}
			if (type1 == type2){
				if (face1 == 1 && face2 != 1){
					return 1;
				}
				if (face2 == 1 && face1 != 1){
					return -1;
				}
				else{
					return o1.compareTo(o2);
				}
			}
		}
		else {
			return o1.compareTo(o2);
		}
		return 0;
	}

}
