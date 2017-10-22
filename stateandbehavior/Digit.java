package stateandbehavior;

public class Digit {
	
	private int numberSystem;
	private int numberValue; 
	
	public Digit(int tallsystem1) {
		numberSystem = tallsystem1;
		numberValue = 0;
		
	}
	
	public int getValue() {
		return numberValue;
		
	}
	
	public boolean increment() {
		numberValue ++;
		if (numberValue == numberSystem) {
			numberValue = 0;
			return true;
		}
		return false;

	}
	
	public int getBase() {
		return numberSystem;
	
	}
	
	public String toString() {
		if (numberValue < 10) {
			return String.format("%s", numberValue);
			
		} 
		else {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int index = numberValue - 10;
		char letter = alphabet.charAt(index);
		return String.format("%s", letter);
		}
		
	}
	
	public static void main(String[] args) {
		Digit number = new Digit(16);
		number.increment();
		System.out.println(number);
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		System.out.println(number);
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		System.out.println(number);
		
	}

}
