import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VehicleTester {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        // Take some user input
        final String leters = JOptionPane
                .showInputDialog("How many lieters of fuel did you use?");
        final String passengers = JOptionPane
                .showInputDialog("How many people were in the car");
        final String price = JOptionPane
                .showInputDialog("How much did you charge each person?");
        final String fuelCost = JOptionPane
                .showInputDialog("How much did the fuel cost/lieter?");
        final String distance = JOptionPane
                .showInputDialog("How far did you drive?");

        // Create an instance of the vehicle
        final Vehicle v = new Vehicle(Integer.parseInt(passengers),
                Double.parseDouble(price), Double.parseDouble(fuelCost),
                Double.parseDouble(leters));

        // print out the information
        System.out.println("Gas used = " + v.getLieters() + "\nGas price = "
                + v.getFuelCost() + "\nKM's driven = " + distance
                + "\nPassengers onboard = " + v.getNumPassengers()
                + "\nFare cost = " + v.getPrice() + "\nTotal cost = "
                + v.getCost() + "\nTotal revenue = " + v.getRevenue()
                + "\nTotal profit = " + (v.getRevenue() - v.getCost()));
    }
}
