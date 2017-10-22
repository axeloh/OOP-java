package inheritance;

public class CargoCar extends TrainCar{
	
	protected int cargoWeight;

	protected CargoCar(int deadWeight, int cargoWeight) {
		super(deadWeight);
		this.cargoWeight = cargoWeight;
		totalWeight = deadWeight + cargoWeight;

	}
	
	public int getCargoWeight() {
		return cargoWeight;
	}
	
	public void setCargoWeight(int cargoWeight) {
		totalWeight += cargoWeight - this.cargoWeight;
		this.cargoWeight = cargoWeight;
		
	}


}
