package cars;

public class Car extends Vehicle {

    // calculate the distance we can travel based on amount of gas
    @Override
    public double getDistance(final double value) {
        return value / 9.4 * 100;
    }

}
