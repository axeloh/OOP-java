package inheritance;

public class PassengerCar extends TrainCar {

	protected int passengerCount; 
	
	protected PassengerCar(int deadWeight, int passengerCount) {
		super(deadWeight);
		this.passengerCount = passengerCount;
		totalWeight = deadWeight + 80*passengerCount;
	}
	
	public int getPassengerCount() {
		return passengerCount;
	}
	
	public void setPassengerCount(int passengerCount) {
		totalWeight += 80*passengerCount - 80*this.passengerCount;
		this.passengerCount = passengerCount;
	}	
	
}