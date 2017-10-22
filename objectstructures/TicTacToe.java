package objectstructures;


public class TicTacToe {
	
	private char[][] board; 
		
		public TicTacToe() {
			this.board = new char[3][3];
			for (int i = 0; i < 3; i++) {
				board[i][0] = ' ';
				board[i][1] = ' ';
				board[i][2] = ' ';
			}
		}
		
		public char getCell(int x, int y) {
			return board[x][y];
		}
		
		public boolean setCell(char c, int x, int y) {
			if (c != 'o' && c != 'x') {
				throw new IllegalArgumentException("Skriv inn gyldig symbol!");
			}
			
			if (isOccupied(x, y)) {
				return false;
			}
			board[x][y] = c;
			return true;
		}
		
		public boolean isOccupied(int x, int y) {
			if (board[x][y] == ' ') {
				return false;
			}
			return true;
		}
		
		public char getCurrentPlayer() {
			int a = 0;
			int b = 0;
			for (int i = 0; i < 3; i++) {
				if (board[i][0] == 'x') {
					a++;
				}
				if (board[i][1] == 'x') {
					a++;
				}
				if (board[i][2] == 'x') {
					a++;
				}
				if (board[i][0] == 'o') {
					b++;
				}
				if (board[i][1] == 'o') {
					b++;
				}
				if (board[i][2] == 'o') {
					b++;
				}
			}
				
			if (a == b) {
				return 'x';
			}
			return 'o';
				
			}

		
		public String toString() {
			if (isWinner('x')) {
				return "Spiller 'x' har vunnet!";
			}
			else if (isWinner('o')) {
				return "Spiller 'o' har vunnet!";
			}
			else if (isFinished()) {
				return "Spillet er ferdig, og det endte med uavgjort!";
			}
			else {
				String a = "";
				a += "Spiller " + getCurrentPlayer() + " sin tur";
				a += "\n\n";
				a += "\n";
				a += "    ";
				a += board[0][0];
				a += "\t|  ";
				a += board[0][1];
				a += "\t|  ";
				a += board[0][2];
				a += " \n";
				a += " ---------------";
				a += "\n";
				a += "    ";
				a += board[1][0];
				a += "\t|  ";
				a += board[1][1];
				a += "\t|  ";
				a += board[1][2];
				a += "\n";
				a += " ---------------";
				a += "\n";
				a += "    ";
				a += board[2][0];
				a += "\t|  ";
				a += board[2][1];
				a += "\t|  ";
				a += board[2][2];
				a += "\n";
				return a;
			}
		}
		
		public void play(int x, int y) {
			char c = getCurrentPlayer();
			isWinner('o');
			isWinner('x');
			setCell(c, x, y);
			}
			
		
		public boolean isWinner(char c) {
			if (board[0][0] == c && board[0][1] == c && board[0][2] == c) {
				return true;
			}
			else if (board[1][0] == c && board[1][1] == c && board[1][2] == c) {
				return true;
			}
			else if (board[2][0] == c && board[2][1] == c && board[2][2] == c) {
				return true;
			}
			else if (board[0][0] == c && board[1][0] == c && board[2][0] == c) {
				return true;
			}
			else if (board[0][1] == c && board[1][1] == c && board[2][1] == c) {
				return true;
			}
			else if (board[0][2] == c && board[1][2] == c && board[2][2] == c) {
				return true;
			}	
			else if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
				return true;
			}
			else if (board[0][2] == c && board[1][1] == c && board[2][0] == c) {
				return true;
			}
			return false;
		}
		
		public boolean hasWinner() {
			if (isWinner('x') || isWinner('o')) {
				return true;
			}
			return false;
		}
		
		public boolean isFinished() {
			if (hasWinner()) {
				return true;
			}
			int x = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (isOccupied(i, j)) {
						x++;
					}
				}
			}
			if (x == 9) {
				return true;
			}
			return false;
		}
		
		public void getInput(String in) {
			int x = Character.getNumericValue(in.charAt(0));
			int y = Character.getNumericValue(in.charAt(1));
			if (x != 0 && x != 1 && x != 2) {
				throw new IllegalArgumentException("Skriv inn gyldig felt (0, 1 eller 2");
			}
			else if ( y != 0 && y != 1 && y != 2) {
				throw new IllegalArgumentException("Skriv inn gyldig felt (0, 1 eller 2");
			}
			play(x,y);
		}
		
	
//		public static void main(String[] args) {
//			TicTacToe board1 = new TicTacToe();
//			System.out.println(board1);
//			System.out.println(board1.getCurrentPlayer());
//			board1.setCell('x', 0, 0);
//			board1.play(0, 0);
//			System.out.println(board1.getCurrentPlayer());
//			board1.setCell('o', 0, 1);
//			board1.setCell('x', 0, 2);
//			board1.setCell('x', 1, 0);
//			board1.setCell('o', 1, 1);
//			board1.setCell('x', 2, 2);
//			System.out.println(board1);
//			boolean a = board1.isOccupied(1, 0);
//			System.out.println(a);
//			boolean b = board1.isFinished();
//			System.out.println(b);
//			
//		}

	}
