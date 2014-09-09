package cars;

public class Truck extends Vehicle {

	//calculate the distance we can travel based on amount of gas
	public double getDistance(double value) {
		return value / 14.1 * 100;
	}

}
