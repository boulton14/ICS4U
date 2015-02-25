package cars;

public class Hybrid extends Vehicle {

    // calculate the distance we can travel based on amount of gas
    @Override
    public double getDistance(final double value) {
        return value / 3.8 * 100;
    }

}
