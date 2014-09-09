package cars;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class FuelEffiency {

	public static void main(String[] args) {
		// take the users input
		double d = Double.parseDouble(JOptionPane
				.showInputDialog("How many lieters of gas do you have?"));

		// create an insance of each class
		Vehicle t = new Truck();
		Vehicle c = new Car();
		Vehicle h = new Hybrid();
		Vehicle m = new Motorcycle();
		
		// decimal format to 2 decimal places
		DecimalFormat df = new DecimalFormat(".##");

		// print out the information
		System.out.println("On " + d + " lieters of gas you can go:\n\n");
		System.out.println("Car = " + df.format(c.getDistance(d)) + "KM");
		System.out.println("Truck = " + df.format(t.getDistance(d)) + "KM");
		System.out.println("Motorcycle = " + df.format(m.getDistance(d)) + "KM");
		System.out.println("Hybrid = " + df.format(h.getDistance(d)) + "KM");
	}

}
