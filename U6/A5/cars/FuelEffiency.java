package cars;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class FuelEffiency {

    public static void main(final String[] args) {
        // take the users input
        final double d = Double.parseDouble(JOptionPane
                .showInputDialog("How many lieters of gas do you have?"));

        // create an insance of each class
        final Vehicle t = new Truck();
        final Vehicle c = new Car();
        final Vehicle h = new Hybrid();
        final Vehicle m = new Motorcycle();

        // decimal format to 2 decimal places
        final DecimalFormat df = new DecimalFormat(".##");

        // print out the information
        System.out.println("On " + d + " lieters of gas you can go:\n\n");
        System.out.println("Car = " + df.format(c.getDistance(d)) + "KM");
        System.out.println("Truck = " + df.format(t.getDistance(d)) + "KM");
        System.out
                .println("Motorcycle = " + df.format(m.getDistance(d)) + "KM");
        System.out.println("Hybrid = " + df.format(h.getDistance(d)) + "KM");
    }

}
