package cars;

public class Motorcycle extends Vehicle {

    // calculate the distance we can travel based on amount of gas
    @Override
    public double getDistance(final double value) {
        return value / 6.3 * 100;
    }

}
