import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FundRaising {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        // loop until they wish to generate results
        while (true) {
            // find out which school to calculate for
            String shoolOptions = "Which school is fundraising?\n 0 - Generate the results\n";
            for (int i = 0; i < FundRaising.schools.length; i++) {
                shoolOptions += (i + 1) + " - " + FundRaising.schools[i] + "\n";
            }
            int schoolIndex;
            try {
                schoolIndex = Integer.parseInt(JOptionPane
                        .showInputDialog(shoolOptions));
                if (schoolIndex == 0) {
                    break;
                }
                if (schoolIndex < 1 || schoolIndex > FundRaising.schools.length) {
                    throw new Exception("Invalid school");
                }
            } catch (final Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid school entered.");
                continue;
            }

            // find the payment option
            String paymentOptions = "Enter the payment option\n 0 - Generate the results\n";
            for (int i = 0; i < FundRaising.amounts.length; i++) {
                paymentOptions += (i + 1) + " - " + FundRaising.amounts[i]
                        + "\n";
            }
            int paymentIndex;
            try {
                paymentIndex = Integer.parseInt(JOptionPane
                        .showInputDialog(paymentOptions));
                if (paymentIndex == 0) {
                    break;
                }
                if (paymentIndex < 1
                        || paymentIndex > FundRaising.amounts.length) {
                    throw new Exception("Invalid payment");
                }
            } catch (final Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid payment option entered.");
                continue;
            }

            // find out how many students attend the shcool
            long studentAmount;
            try {
                studentAmount = Long
                        .parseLong(JOptionPane
                                .showInputDialog("How many students go to that school."));
            } catch (final Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid student amount entered. Not a number.");
                continue;
            }

            // calculate and set the values on our total array
            FundRaising.totals[paymentIndex - 1][schoolIndex - 1] = studentAmount
                    * FundRaising.amounts[paymentIndex - 1];
        }

        // print out the headers for the school names
        for (int i = 0; i < FundRaising.schools.length; i++) {
            System.out.print((i > 0 ? "  - " : " ") + FundRaising.schools[i]);
        }
        // add a total option
        System.out.print(" - Total");
        System.out.println();// print the line

        // create a variable which will hold our total amount;
        double total = 0;

        // loop through the totals array printing the values in a grid like pattern
        for (int i = 0; i < FundRaising.totals.length; i++) {
            double rowtotal = 0;
            System.out.print("$" + FundRaising.amounts[i] + " - ");
            for (int j = 0; j < FundRaising.totals[i].length; j++) {
                rowtotal += FundRaising.totals[i][j];// append to the row total
                System.out.print(" " + FundRaising.totals[i][j] + " ");
            }
            System.out.print(" " + rowtotal);
            System.out.println();
            total += rowtotal;// add to the total amount of donations
        }
        // print out the total amount of donations
        System.out.println("Total of donations: " + total);
    }

    // define constants
    private static final String[] schools = new String[] { "Catholic Central",
            "Holy Cross", "John Paul II", "Mother Teresa", "Regina Mundi",
            "St. Joseph", "St. Mary", "St. Thomas Aquinas" };

    private static final double[] amounts = { 0.25, 0.50, 1.00, 2.00 };

    // create a variable for the total values initilized to 0's
    private static double[][] totals = new double[][] {
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
}
