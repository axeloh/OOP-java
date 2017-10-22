package objectstructures;

public class Route {
	
	public static final String example_board1 = ".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....";
	public static final String example_board2 = ".68.257.3..........71..39..61.35.2...8.....4...3.64.95..76..58..........8.653.42.";
	public static final String example_board3 = ".....59.4.8..9.6.5..6....3..3.7.145...8.4.7...742.6.9..6....3..8.1.6..7.3.98.....";
	public static final String example_board4 = "...6...513....2..66...3..89..4.2.6...3.418.2...8.7.1..59..6...38..3....241...9...";
	
	public char value;
	public boolean isProtected = false;
	public boolean isInConflict = false;
	
	public Route(char value) {
			this.value = value;
		}
	
	public char getValue() {
		return value;
	}
	
	public boolean isNumber() {
		if (value != '.') {
			return true;
		}
		return false;
	}
	public void makeProtected(){
		isProtected = true;
	}
	public void makeConflict() {
		if (!isProtected) {
			isInConflict = true;
		}
	}
	
	public void solveConflict() {
		if (!isProtected) {
			isInConflict = false;
		}
	}
	
}
