public class Vehicle {

    // private variables
    private int numPassengers;

    private double price, fuelCost, lieters;

    // constructor
    public Vehicle(final int passengers, final double price,
            final double fuelCost, final double lieters) {
        this.setNumPassengers(passengers);
        this.setPrice(price);
        this.setFuelCost(fuelCost);
        this.setLieters(lieters);
    }

    // Getters and setters

    public double getCost() {
        return fuelCost * lieters;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public double getLieters() {
        return lieters;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public double getPrice() {
        return price;
    }

    // methods to find some information
    public double getRevenue() {
        return price * numPassengers;
    }

    public void setFuelCost(final double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public void setLieters(final double lieters) {
        this.lieters = lieters;
    }

    public void setNumPassengers(final int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

}
