package cars;

public class Hybrid extends Vehicle {

	//calculate the distance we can travel based on amount of gas
	public double getDistance(double value) {
		return value / 3.8 * 100;
	}

}
