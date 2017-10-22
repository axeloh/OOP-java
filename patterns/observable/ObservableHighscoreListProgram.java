package patterns.observable;

import java.util.Scanner;


public class ObservableHighscoreListProgram implements ObservableListListener{
	
	ObservableList hsl;

	@Override
	public void listChanged(ObservableList list, int n) {
		System.out.println("Listen endret seg på plass nr: " + n);
		System.out.println("Skriv inn neste resultat:");
	}
	
	public void init() {
		hsl = new ObservableHighscoreList(10);
		hsl.addObservableListListener(this);
		System.out.println("Hei og velkommen.");
		System.out.println("Skriv inn første resultat ('slutt' for å stoppe): ");
	}
	
	public void run() {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) { // fortsetter så lenge input er et tall.
			int num = in.nextInt();
			String s = String.valueOf(num);
			if (s.length() == 1) {
				((ObservableHighscoreList) hsl).addResult(num);
			}
			else if (s.contains(" ")) {
				int spaceIndex = s.indexOf(" ");
				int index = s.charAt(spaceIndex - 1);
				int value = s.charAt(spaceIndex + 1);
				hsl.addElement(index, value);
				
			}
		}
		in.close();
	}
	
	public static void main(String[] args) {
		ObservableHighscoreListProgram prog = new ObservableHighscoreListProgram();
		prog.init();
		prog.run();
	}

}
