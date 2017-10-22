package interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Stack;

public class Sudoku implements SaveAndLoad {
	
	private Route[][] board;
	private String[][] gameBoard;
	private Stack<ActionSudoku> undoStack;
	private Stack<ActionSudoku> redoStack;
	private String startBoard;
	
	public Sudoku() {
		board = new Route[9][9];
		startBoard = Route.example_board1;
		undoStack = new Stack<>();
		redoStack = new Stack<>();
		setStartBoard();
		makeBoard();
	}
	
	public void setStartBoard() {
		int l = 0;
		for (int i = 0; i < 9; i++) {
			String sub_a1 = startBoard.substring(l, l + 9);
			l += 9;
			for (int j = 0; j < 9; j++) {
				Route value = new Route(sub_a1.charAt(j));
				board[i][j] = value;
				if (board[i][j].isNumber()) {
					board[i][j].makeProtected();
				}
			}
		}
	}
	
	public void setRoute(int row, int col, Route value) {
		if (!isProtected(row, col)) {
			ActionSudoku oldValue = new ActionSudoku(row, col, board[row][col]);
			undoStack.push(oldValue);
			board[row][col] = value;
			updateConflict();
			updategameBoard();
			resetConflicts();
			redoStack.removeAllElements();
		}
	}
	
	public boolean isProtected(int row, int col) {
		if (board[row][col].isProtected) {
			return true;
		}
		return false;
	}
	
	public void resetConflicts() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j].solveConflict();
			}
		}
	}
	
	public void checkRows(int row,int col){
		for (int i = 0; i < 9 ; i++){
			if (board[row][col].getValue() == board[row][i].getValue() && col!= i && board[row][col].isNumber()) {
				board[row][col].makeConflict();
			}
		}
	}
	
	public void checkCols(int row, int col) {
		for (int i = 0; i < 9 ; i++){
			if (board[row][col].getValue() == board[i][col].getValue() && row!= i && board[row][col].isNumber()) {
				board[row][col].makeConflict();
			}
		}
	}
	
	public void checkArea(int row, int col) {
		int squareRow = row/3;
		int squareCol = col/3;
		for (int i = squareRow*3; i < squareRow*3 + 3; i++) {
			for (int j = squareCol*3; j < squareCol*3 + 3; j++) {
				if (board[row][col].getValue() == board[i][j].getValue() && board[row][col].isNumber() && !(row == i && col == j)) {
					board[row][col].makeConflict(); 
				}
			}
		}	
	}
	
	public void updateConflict() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				checkRows(i, j);
				checkCols(i, j);
				checkArea(i, j);
			}
		}
	}
	
	public void updategameBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j].isInConflict) {
					gameBoard[i][j] = " " + board[i][j].getValue() + "*";
				}
				else if (!board[i][j].isProtected) {
					gameBoard[i][j] = " " + board[i][j].getValue() + " ";
				}
				
			}
		}
	}
	
	public void makeBoard() {
		gameBoard = new String[9][9];
		for (int a = 0; a < 9; a++) {
			for (int b = 0; b < 9; b++) {
				Route value_1 = board[a][b];
				if (value_1.isProtected) {
					gameBoard[a][b] = "(" + value_1.getValue() + ")";
				}
				else {
					gameBoard[a][b] = " . ";
				}
			}
		}
	}
	
	public void printBoard() {
		for (int i = 0; i < 9; i++) {
		System.out.println(Arrays.deepToString(gameBoard[i]));
		}
	}
	
	public boolean isFinished() {
		int r = 0;
		for (int a = 0; a < 9; a++) {
			for (int b = 0; b < 9; b++) {
				if(board[a][b].isNumber() && !board[a][b].isInConflict) {
					r++;
				}
			}
		}
		if (r == 81) {
			return true;
		}
		return false;
	}
	
 	public String toString() {
	String a = "";
	String b = "";
	for (int i = 0; i < 9; i++) {
		if (i % 3 == 0) {
			a += " +-----------+-----------+-----------+\n";
		}
		for (int j = 0; j < 9; j++) {
			if (j % 3 == 0) {
				a += " | ";
			}
			a += gameBoard[i][j];
			if (j == 8) {
				a += " | ";
			}
		}
		if (i == 8) {
			a += "\n +-----------+-----------+-----------+";
		}
		a += "\n";
	}
	if (isFinished()) {
		b += "Gratulerer, du l�ste sudokuen!\n\n";
		b += a;
		return b;
	}
	return a;
} 

	public void getInput(String in) {
		int x = Character.getNumericValue(in.charAt(0));
		int y = Character.getNumericValue(in.charAt(1));
		Route value = new Route(in.charAt(2));
		setRoute(x, y, value);
	}
	
	public void undo() {
		if (undoStack.empty()) {
			throw new IllegalStateException("Kan ikke angre før en handling gjort.");
		}
		ActionSudoku action = undoStack.pop();
		Route oldValue = board[action.row][action.col]; 
		ActionSudoku oldAction = new ActionSudoku(action.row, action.col, oldValue);
		redoStack.push(oldAction);
		board[action.row][action.col] = action.value;
		updateConflict();
		updategameBoard();
		resetConflicts();
	}
	
	public void redo() {
		if (redoStack.isEmpty()) {
			throw new IllegalStateException("Kan ikke gjenta før en handling er angret.");
		}
		ActionSudoku action = redoStack.pop();
		Route oldValue = board[action.row][action.col]; 
		ActionSudoku oldAction = new ActionSudoku(action.row, action.col, oldValue);
		undoStack.push(oldAction);
		board[action.row][action.col] = action.value;
		updateConflict();
		updategameBoard();
		resetConflicts();
	}
	
	public void save(String fileName) {
		String boardSave = "";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				boardSave += board[i][j].getValue();
			}
			boardSave += "\n";
		}
		try {
			String filePath = new File("").getAbsolutePath();
			filePath += "/src/interfaces/" + fileName;
			File file = new File(filePath);
			FileWriter writer = new FileWriter(file);
			writer.write(boardSave);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.err.println("Skjedde feil ved skriving til fil");
		}
		
	}
	
	public void load(String fileName) {
		Reader reader = null;
		try {
			String filePath = new File("").getAbsolutePath();
			filePath += "/src/interfaces/" + fileName;
			File file = new File(filePath);
			reader = new FileReader(file);
			char[] buffer = new char[89];
			reader.read(buffer);
			int k = 0;
			int l = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (buffer[k] == '\n') {
						k++;
					}
					board[i][j] = new Route(buffer[k]);
					if (buffer[k] == startBoard.charAt(l) && startBoard.charAt(l) != '.') {
						board[i][j].makeProtected();
						gameBoard[i][j] = "(" + board[i][j].getValue() + ")";
					}
					k++;
					l++;
				}
			}
			updateConflict();
			updategameBoard();
			resetConflicts();
			System.out.println("Fil loadet!");
		} catch (FileNotFoundException e) {
			System.err.println("Fant ikke filen..");
		} catch (IOException e) {
			System.err.println("Skjedde en feil med lesing fra fil");
		} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	
	public static void main(String[] args) {
		Sudoku spill1 = new Sudoku();
		//spill1.printBoard();
		//System.out.println("---------------------------------------------");
		//System.out.println(spill1.startBoard.length());
		spill1.setRoute(0, 0, new Route('5'));
		spill1.setRoute(1, 0, new Route('5'));
		spill1.setRoute(1, 0, new Route('3'));
		spill1.setRoute(0, 0, new Route('6'));
		//spill1.printBoard();
		//System.out.println("-----------------------------------------------");
		spill1.setRoute(0, 3, new Route('6'));
		spill1.setRoute(3, 3, new Route('6'));
		spill1.setRoute(3, 4, new Route('4'));
		spill1.setRoute(0, 1, new Route('9'));
		//spill1.printBoard();
		spill1.setRoute(0, 3, new Route('5'));
		spill1.setRoute(7, 0, new Route('8'));
		System.out.println(spill1);
		spill1.save("sudoku2.txt");
		spill1.load("sudoku2.txt");
		
		//System.out.println("---------------------------------------------");
		//spill1.printBoard();
		
	}

}
