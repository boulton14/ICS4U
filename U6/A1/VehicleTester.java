import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VehicleTester {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		// Take some user input
		String leters = JOptionPane.showInputDialog("How many lieters of fuel did you use?");
		String passengers = JOptionPane.showInputDialog("How many people were in the car");
		String price = JOptionPane.showInputDialog("How much did you charge each person?");
		String fuelCost = JOptionPane.showInputDialog("How much did the fuel cost/lieter?");
		String distance = JOptionPane.showInputDialog("How far did you drive?");

		// Create an instance of the vehicle
		Vehicle v = new Vehicle(Integer.parseInt(passengers), Double.parseDouble(price),
				Double.parseDouble(fuelCost), Double.parseDouble(leters));

		// print out the information
		System.out.println("Gas used = " + v.getLieters() + "\nGas price = " + v.getFuelCost()
				+ "\nKM's driven = " + distance + "\nPassengers onboard = " + v.getNumPassengers()
				+ "\nFare cost = " + v.getPrice() + "\nTotal cost = " + v.getCost()
				+ "\nTotal revenue = " + v.getRevenue() + "\nTotal profit = "
				+ (v.getRevenue() - v.getCost()));
	}
}
