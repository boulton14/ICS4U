package car;

import java.awt.Toolkit;

public class Car {

    // Declare variables
    private final String make;
    private final String model;
    private final String size;
    private final int year;
    private final int price;
    private final String color;

    // end variable decleration

    /**
     * The third constructor
     * 
     * @param make
     *            The maker of the car
     * @param model
     *            The model of the car
     * @param year
     *            The year the car was made
     * @param price
     *            The price of the car
     * @param color
     *            The color of the car
     * @param size
     *            The size of the car
     */
    public Car(final String make, final String model, final int year,
            final int price, final String color, final String size) {
        // define variables
        this.model = model;
        this.make = make;
        this.year = year;
        this.price = price;
        this.color = color;
        this.size = size;
    }

    /**
     * The second constructor with 3 parameters
     * 
     * @param make
     * @param model
     * @param size
     */
    public Car(final String make, final String model, final String size) {
        this(make, model, 2000, 20000, "black", size);
    }

    /**
     * Default constructor
     */
    public Car() {
        this("Java", "Java Car", "Large");
    }

    // Start -- Getters -- used to fetch private variables in a controlable manner
    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getSize() {
        return size;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    // End getters

    /**
     * Honks the cars horn
     */
    public void honkHorn() {
        // pretend it makes a beep noise :D
        Toolkit.getDefaultToolkit().beep();
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Honk Honk...");
    }

    @Override
    public String toString() {
        // return a string containing information on the car
        return "Car: " + getModel() + " made by " + getMake()
                + ". The car is a " + getSize() + " size made in " + getYear()
                + " for a price of $" + getPrice() + ". This car was a "
                + getColor() + " car.";
    }
}
