package objectstructures;


public class BattleshipBoard {
	
	private Cell[][] board1;
	private Cell[][] board2;
	private char[][] gameBoard1;
	private char[][] gameBoard2;
	private int player = 1;
	private int boardSize = 10;
	private String a = "";
	private boolean player1Wins = false;
	private boolean player2Wins = false;
	
	public BattleshipBoard() {
		board1 = new Cell[boardSize][boardSize];
		board2 = new Cell[boardSize][boardSize];
		String b1 = Levels.sample_level1;
		String b2 = Levels.sample_level2;
		int k = 0;
		int l = 0;
		for (int i = 0; i < boardSize; i ++) {
			 String sub1 = b1.substring(l, l + 10);
			 String sub2 = b2.substring(l, l + 10);
			 l += 10;
			 for (int j = 0; j < boardSize; j++) {
				 board1[k][j] = new Cell(sub1.charAt(j) == 'X');
				 board2[k][j] = new Cell(sub2.charAt(j) == 'X');
			 }
			 k += 1;
		}
		makeBoard();
	
	}
	
	public void changeTurn() {
		if (player == 1) {
			player = 2;
		}
		else {
			player = 1;
		}
	}
	
	public void markAsBombed(int x, int y) {
		if (player == 1) {
			board2[x][y].beenShot();
			gameBoard2[x][y] = 'X';
		}
		else {
			board1[x][y].beenShot();
			gameBoard1[x][y] = 'X';	
		}
		a = "It was a hit!";
		System.out.println("It was a hit!");
	}
	
	public void markAsMissed(int x, int y) {
		if (player == 1) {
			board2[x][y].beenShot();
			gameBoard2[x][y] = '.';
		}
		else {
			board1[x][y].beenShot();
			gameBoard1[x][y] = '.';	
		}
		a = "It was a miss..";
		System.out.println("It was a miss..");
	}
	
	public void bomb(Cell[][] board, int x, int y) {
		if (isAlreadyBombed(board, x, y)) {
			throw new IllegalArgumentException("This route has already been bombed!");
		}
		
		if (isHit(board, x, y)) {
			markAsBombed(x, y);
		}
		else if (!isHit(board, x, y)) {
			markAsMissed(x, y);
		}	
		changeTurn();
	}
	
	
	public boolean isHit(Cell[][] board, int x, int y) {
		if (board[x][y].isShip && !board[x][y].isShot) {
			return true;
		}
		else if (!board[x][y].isShip) {
			return false;
		}
		return false;
	}
	
	public boolean isAlreadyBombed(Cell[][] board, int x, int y) {
		return board[x][y].isShot;
	}
	
	public void isWinner() {
		int a = 0;
		int b = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board1[i][j].isShip && !board1[i][j].isShot) {
					a++;
				}
				if (board2[i][j].isShip && !board2[i][j].isShot) {
					b++;
				}
			}
		}
		if (a == 0) {
			player1Wins = true;
		}
		if (b ==0) {
			player2Wins =true;
		}
	}
	
	public void makeBoard() {
		gameBoard1 = new char[boardSize][boardSize];
		gameBoard2 = new char[boardSize][boardSize];
		
		for (int a = 0; a < 10; a++){
			for(int b = 0; b < 10; b++){
				gameBoard1[a][b] = '~';
				gameBoard2[a][b] = '~';
			}
		}
	}
	
	public void getInput(String in) {
		int x = Character.getNumericValue(in.charAt(0));
		int y = Character.getNumericValue(in.charAt(1));
		if (player == 1) {
			bomb(board2, x, y);
		}
		else if (player == 2) {
			bomb(board1, x, y);
		}
	}
	
	public String toString() {
		isWinner();
		if (player1Wins) {
			return "Player 1 won!";
		}
		if (player2Wins) {
			return "Player 2 won!";
		}

		if (player == 1) {
			a += "\n\nYour turn, player 1!\n";
			for (int c = 0; c < boardSize; c++) {
				a += "| " + gameBoard2[c][0] + " ";
				a += gameBoard2[c][1] + " ";
				a += gameBoard2[c][2] + " ";
				a += gameBoard2[c][3] + " ";
				a += gameBoard2[c][4] + " ";
				a += gameBoard2[c][5] + " ";
				a += gameBoard2[c][6] + " ";
				a += gameBoard2[c][7] + " ";
				a += gameBoard2[c][8] + " ";
				a += gameBoard2[c][9] + " |\n";
			}
		}
		else if (player == 2) {
			a += "\n\nYour turn, player 2!\n";
			for (int c = 0; c < boardSize; c++) {
				a += "| " + gameBoard1[c][0] + " ";
				a += gameBoard1[c][1] + " ";
				a += gameBoard1[c][2] + " ";
				a += gameBoard1[c][3] + " ";
				a += gameBoard1[c][4] + " ";
				a += gameBoard1[c][5] + " ";
				a += gameBoard1[c][6] + " ";
				a += gameBoard1[c][7] + " ";
				a += gameBoard1[c][8] + " ";
				a += gameBoard1[c][9] + " |\n";
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		BattleshipBoard spill1 = new BattleshipBoard();
		for (int i = 0; i < 10; i++) {
			char[] row = spill1.gameBoard1[i];
			System.out.println(row);
		}
		
		
	}

}
