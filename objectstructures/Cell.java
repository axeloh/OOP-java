package objectstructures;

public class Cell {
	
	boolean isShip;
	boolean isShot;
	
	public Cell(boolean isShip){
		this.isShip = isShip;
		this.isShot = false;
	}
	
	public void beenShot() {
		isShot = true;
	}
	
	

	
	
	

}
