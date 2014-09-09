public class Vehicle {

	// private variables
	private int numPassengers;

	private double price, fuelCost, lieters;

	// constructor
	public Vehicle(final int passengers, final double price, final double fuelCost,
			final double lieters) {
		this.setNumPassengers(passengers);
		this.setPrice(price);
		this.setFuelCost(fuelCost);
		this.setLieters(lieters);
	}

	// Getters and setters

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getFuelCost() {
		return fuelCost;
	}

	public void setFuelCost(double fuelCost) {
		this.fuelCost = fuelCost;
	}

	public int getNumPassengers() {
		return numPassengers;
	}

	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}

	public double getLieters() {
		return lieters;
	}

	public void setLieters(double lieters) {
		this.lieters = lieters;
	}

	// methods to find some information
	public double getRevenue() {
		return price * numPassengers;
	}

	public double getCost() {
		return fuelCost * lieters;
	}

}
