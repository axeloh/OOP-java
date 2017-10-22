package interfaces;

public class ActionSudoku {
	
	int row;
	int col;
	Route value;
	
	public ActionSudoku(int row, int col, Route value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}
	
	public Route getValue() {
		return value;
	}
	

}
