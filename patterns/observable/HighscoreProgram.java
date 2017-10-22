package patterns.observable;

import java.util.Scanner;

public class HighscoreProgram implements HighscoreListListener{
	
	HighscoreList hsl;

	@Override
	public void listChanged(HighscoreList list, int n) {
		System.out.println("Listen endret seg på plass nr: " + n);
		System.out.println("Skriv inn neste resultat:");
	}
	
	public void init() {
		hsl = new HighscoreList(10);
		hsl.addHighscoreListListener(this);
		System.out.println("Hei og velkommen.");
		System.out.println("Skriv inn første resultat ('slutt' for å stoppe): ");
	}
	
	public void run() {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) { // fortsetter så lenge input er et tall.
			int num = in.nextInt();
			hsl.addResult(num);
		}
	}
	
	public static void main(String[] args) {
		HighscoreProgram prog = new HighscoreProgram();
		prog.init();
		prog.run();
	}
	

	
	
	

}
