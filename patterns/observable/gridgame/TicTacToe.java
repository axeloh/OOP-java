package patterns.observable.gridgame;

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import interfaces.Action;

public class TicTacToe implements GenericGridGame<Character>{
	
	private char[][] board; 
	private Stack<Action> undoStack = new Stack<>();
	private Stack<Action> redoStack = new Stack<>();
	private Collection<GridListener<Character>> listeners = new ArrayList<>();

		public TicTacToe() {
			this.board = new char[3][3];
			for (int i = 0; i < 3; i++) {
				board[i][0] = ' ';
				board[i][1] = ' ';
				board[i][2] = ' ';
			}
		}
		
		@Override
		public Character getCell(int x, int y) {
			return board[y][x];
		}
		
		public boolean setCell(char c, int x, int y) {
			if (c != 'o' && c != 'x' && c != ' ') {
				throw new IllegalArgumentException("Skriv inn gyldig symbol!");
			}
			
			if (isOccupied(x, y)) {
				return false;
			}
			board[y][x] = c;
			for (GridListener<Character> listener : listeners) {
				listener.gridChanged(this, x, y, 1, 1);
			}
			return true;
		}
		
		public boolean isOccupied(int x, int y) {
			return board[y][x] != ' ';
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
			String a = "";
			if (isWinner('x')) {
				a += "Henrik har vunnet og er best. I alt!";
			}
			else if (isWinner('o')) {
				a += "Med stor flaks har axel vunnet";
			}
			else if (isFinished()) {
				a += "Spillet er ferdig, og det endte med uavgjort!";
			}
			if (!hasWinner() && !isFinished()) {
				a += "Spiller " + getCurrentPlayer() + " sin tur";
			}
			a += "\n\n";
			a += "\n";
			a += "   ";
			a += board[0][0];
			a += " | ";
			a += board[0][1];
			a += " | ";
			a += board[0][2];
			a += " \n";
			a += "  -----------";
			a += "\n";
			a += "   ";
			a += board[1][0];
			a += " | ";
			a += board[1][1];
			a += " | ";
			a += board[1][2];
			a += "\n";
			a += "  -----------";
			a += "\n";
			a += "   ";
			a += board[2][0];
			a += " | ";
			a += board[2][1];
			a += " | ";
			a += board[2][2];
			a += "\n";
			return a;
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
		
		@Override
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

		public static void main(String[] args) {
			TicTacToe board1 = new TicTacToe();
			System.out.println(board1);
			board1.play(0,0);
			System.out.println(board1);
			board1.play(1,1);
			board1.play(1, 2);
			System.out.println(board1);
			board1.play(2, 2);
			board1.save("game1.txt");
			board1.load("game1.txt");
			System.out.println(board1);
			board1.undo();
			System.out.println(board1);
			board1.undo();
			System.out.println(board1);
			board1.undo();
			System.out.println(board1);
			board1.redo();
			System.out.println(board1);
			board1.redo();
			System.out.println(board1);
			board1.undo();
			System.out.println(board1);
			board1.play(1, 2);
			System.out.println(board1);
			
		}

		public void play(int x, int y) {
			if (!hasWinner()) {
				char c = getCurrentPlayer();
				setCell(c, x, y);
				Action action = new Action(c, x, y);
				undoStack.push(action);
				redoStack.removeAllElements();
			}
		}
		
		@Override
		public void undo() {
			if (undoStack.empty()) {
				throw new IllegalStateException("Du kan ikke angre før en handling er blitt gjort!");
			}
			Action action = undoStack.pop();
			redoStack.push(action);
			board[action.y][action.x] = ' ';
			for (GridListener<Character> listener : listeners) {
				listener.gridChanged(this, action.y, action.x, 1, 1);
			}
		}
		
		@Override
		public void redo() {
			if (redoStack.empty()) {
				throw new IllegalStateException("Du kan ikke gjenta før en handling er blitt angret!");
			}
			Action action = redoStack.pop();
			undoStack.push(action);	
			board[action.y][action.x] = action.c;
			for (GridListener<Character> listener : listeners) {
				listener.gridChanged(this, action.y, action.x, 1, 1);
			}
		}
		
		@Override
		public void save(String fileName) {
			String boardSave = "";
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					boardSave += board[i][j];
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
				System.err.println("Skjedde en feil ved skriving til fil.");
			}
		}

		@Override
		public void load(String fileName) {
			Reader reader = null;
			try {
				String filePath = new File("").getAbsolutePath();
				filePath += "/src/interfaces/" + fileName;
				File file = new File(filePath);
				reader = new FileReader(file);
				char[] buffer = new char[12];
				reader.read(buffer);
				int k = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (k == 3) { k = 4; }
						else if (k ==7) { k = 8; }
						board[i][j] = buffer[k];
						k++;
					}
				}
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
			
		@Override
		public void addGridListener(GridListener<Character> gridListener) {
			if (listeners.contains(gridListener)) {
				throw new IllegalArgumentException("Lytter allerede registrert.");
			}
			listeners.add(gridListener);		
		}


		@Override
		public void removeGridListener(GridListener<Character> listener) {
			if (!listeners.contains(listener)) {
				throw new IllegalArgumentException("Lytter er ikke registrert.");
			}
			listeners.remove(listener);
		}


		@Override
		public String[] getImages(Character t) {
			String[] pic = new String[1];
			if (t.equals('x')) {
				pic[0] = "x.png";
			}
			else if (t.equals('o')) {
				pic[0] = "o.png";
			}
			else {
				pic[0] = "blanc.png";
			}
			return pic;
		}

		@Override
		public boolean canUndo() {
			return !undoStack.empty();
		}

		@Override
		public boolean canRedo() {
			return !redoStack.empty();
		}

		@Override
		public int getColumnCount() {
			return board.length;
		}

		@Override
		public int getRowCount() {
			return board.length;
		}

		@Override
		public boolean doAIMove() {
			char c = getCurrentPlayer();
			isWinner('o');
			isWinner('x');
			Random rand = new Random();
			int x = rand.nextInt(3);
			int y = rand.nextInt(3);
			char opponent = ' ';
			if (c == 'x') {
				opponent = 'o';
			}
			else {
				opponent = 'x';
			}
			if (checkWin(c)) {
				return true;
			}
			if (checkWin(opponent)) {
				return true;
			}
			while (isOccupied(x, y)) {
			x = rand.nextInt(3);
			y = rand.nextInt(3);
			}
			play(x, y);
			return true;
		}
		
		public boolean checkWin(char c) {
			for (int i = 0; i < 3; i++) {
				if (board[i][0] == c && board[i][1] == c) {
					if (!isOccupied(2, i)) {
						play(2, i);
						return true;
					}
				}
				if (board[i][1] == c && board[i][2] == c) {
					if (!isOccupied(0, i)) {
						play(0, i);
						return true;
					}
				}
				if (board[i][0] == c && board[i][2] == c) {
					if (!isOccupied(1, i)) {
						play(1, i);
						return true;
					}
				}
				if (board[0][i] == c && board[2][i] == c) {
					if (!isOccupied(i, 1)) {
						play(i, 1);
						return true;
					}
				}
				
				if (board[0][i] == c && board[1][i] == c) {
					if (!isOccupied(i, 2)) {
						play(i, 2);
						return true;
					}
					
				}
				if (board[1][i] == c && board[2][i] == c) {
					if (!isOccupied(i, 0)) {
						play(i, 0);
						return true;
					}
				}	
			}
			if (board[0][0] == c && board[1][1] == c) {
				if (!isOccupied(2, 2)) {
					play(2, 2);
					return true;
				}
			}
			if (board[1][1] == c && board[2][2] == c) {
				if (!isOccupied(0, 0)) {
					play(0, 0);
					return true;
				}
			}
			if (board[2][0] == c && board[1][1] == c) {
				if (!isOccupied(2, 0)) {
					play(2, 0);
					return true;
				}
			}
			if (board[0][2] == c && board[1][1] == c) {
				if (!isOccupied(0, 2)) {
					play(0, 2);
					return true;
				}
			}
			if (board[0][0] == c && board[2][2] == c) {
				if (!isOccupied(1,1)) {
					play(1, 1);
					return true;
				}
			}
			if (board[0][2] == c && board[2][0] == c) {
				if (!isOccupied(1,1)) {
					play(1, 1);
					return true;
				}
			}
			
			return false;
		}

		
		
	}
