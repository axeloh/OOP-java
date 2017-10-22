package inheritance;

import java.util.ArrayList;

public class Train{

	private ArrayList<TrainCar> trainCars;
	
	protected Train() {
		trainCars = new ArrayList<>();
	}
	
	public void addTrainCar(TrainCar trainCar) {
		trainCars.add(trainCar);
	}
	
	public boolean contains(TrainCar trainCar) {
		if (trainCars.contains(trainCar)) {
			return true;
		}
		return false;
	}
	
	public int getTotalWeight() {
		int totalWeight = 0;
		for (TrainCar trainCar : trainCars) {
			totalWeight += trainCar.getTotalWeight();
		}
		return totalWeight;
	}
	
	public int getPassengerCount() {
		int passengerCount = 0;
		for (TrainCar trainCar : trainCars) {
			if (trainCar instanceof PassengerCar) {
				passengerCount += ((PassengerCar) trainCar).getPassengerCount();
			}
		}
		return passengerCount;
	}
	
	public int getCargoWeight() {
		int cargoWeight = 0;
		for (TrainCar trainCar : trainCars) {
			if (trainCar instanceof CargoCar) {
				cargoWeight+= ((CargoCar) trainCar).getCargoWeight();
			}
		}
		return cargoWeight;
	}
	
	public String toString() {
		String s = "";
		int i = 1;
		for (TrainCar trainCar : trainCars) {
			s += "Vogn nr " + i + ":\n";
			if (trainCar instanceof PassengerCar) {
				s += "Vogntype: Passenger Car\n";
				s += "Number of passengers: " + ((PassengerCar) trainCar).getPassengerCount();
			}
			else {
				s += "VognType: Cargo Car\n";
				s += "Lastvekt: " + ((CargoCar) trainCar).getCargoWeight();
			}
			s += "\nTotalvekt: " + trainCar.getTotalWeight() + "\n";
			s += "-----------------------\n";
			i++;
		}
		return s;
	}
	
	public static void main(String[] args) {
		Train train = new Train();
		TrainCar pc1 = new PassengerCar(800, 2);
		TrainCar pc2 = new PassengerCar(500, 1);
		TrainCar pc3 = new PassengerCar(1300, 8);
		TrainCar cc1 = new CargoCar(1000, 300);
		TrainCar cc2 = new CargoCar(2000, 400);
		TrainCar cc3 = new CargoCar(500, 100);
		train.addTrainCar(pc1);
		train.addTrainCar(pc2);
		train.addTrainCar(pc3);
		train.addTrainCar(cc1);
		train.addTrainCar(cc2);
		train.addTrainCar(cc3);
		System.out.println(train);
		System.out.println(train.getTotalWeight());
		
	}
}
