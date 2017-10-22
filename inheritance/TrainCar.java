package inheritance;

public class TrainCar {
	
	protected int deadWeight;
	protected int totalWeight;
	
	protected TrainCar(int deadWeight) {
		this.deadWeight = deadWeight;

	}
	
	protected int getTotalWeight() {
		return totalWeight;
	}
	
	protected void setDeadWeight(int deadWeight) {
		this.deadWeight = deadWeight;
	}
	
	protected int getDeadWeight() {
		return deadWeight;
	}

}
