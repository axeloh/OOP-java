package stateandbehavior;

public class Location {
	
	private int x;
	private int y;
	
	public Location(int xpos, int ypos) {
		x = xpos;
		y = ypos;

	}
	
	public void up() {
		y -= 1;
		
	}
	
	public void down() {
		y += 1;
		
	}
	
	public void left() {
		x -= 1;
		
	}
	
	public void right() {
		x += 1;
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return String.format("x-posisjonen til figuren er %s, og y-posisjonen til figuren er %s", x, y);
		
	}
	
	public static void main(String[] args) {
		
		Location figur1 = new Location(50, 40);
		System.out.println(figur1);
		figur1.up();
		figur1.left();
		System.out.println(figur1);

	}

}
