package cars;

public class Motorcycle extends Vehicle {

	//calculate the distance we can travel based on amount of gas
	public double getDistance(double value) {
		return value / 6.3 * 100;
	}

}
