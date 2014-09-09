import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FundRaising {

    //define constants
    private static final String[] schools = new String[] { "Catholic Central",
            "Holy Cross", "John Paul II", "Mother Teresa", "Regina Mundi",
            "St. Joseph", "St. Mary", "St. Thomas Aquinas" };
    private static final double[] amounts = { 0.25, 0.50, 1.00, 2.00 };
    
    //create a variable for the total values initilized to 0's
    private static double[][] totals = new double[][] {
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        //loop until they wish to generate results
        while (true) {
            //find out which school to calculate for
            String shoolOptions = "Which school is fundraising?\n 0 - Generate the results\n";
            for (int i = 0; i < schools.length; i++) {
                shoolOptions += (i + 1) + " - " + schools[i] + "\n";
            }
            int schoolIndex;
            try {
                schoolIndex = Integer.parseInt(JOptionPane
                        .showInputDialog(shoolOptions));
                if (schoolIndex == 0) {
                    break;
                }
                if (schoolIndex < 1 || schoolIndex > schools.length) {
                    throw new Exception("Invalid school");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid school entered.");
                continue;
            }
            
            //find the payment option
            String paymentOptions = "Enter the payment option\n 0 - Generate the results\n";
            for (int i = 0; i < amounts.length; i++) {
                paymentOptions += (i + 1) + " - " + amounts[i] + "\n";
            }
            int paymentIndex;
            try {
                paymentIndex = Integer.parseInt(JOptionPane
                        .showInputDialog(paymentOptions));
                if (paymentIndex == 0) {
                    break;
                }
                if (paymentIndex < 1 || paymentIndex > amounts.length) {
                    throw new Exception("Invalid payment");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid payment option entered.");
                continue;
            }

            //find out how many students attend the shcool
            long studentAmount;
            try {
                studentAmount = Long
                        .parseLong(JOptionPane
                                .showInputDialog("How many students go to that school."));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid student amount entered. Not a number.");
                continue;
            }
            
            //calculate and set the values on our total array
            totals[paymentIndex - 1][schoolIndex - 1] = studentAmount
                    * amounts[paymentIndex - 1];
        }
        
        //print out the headers for the school names
        for (int i = 0; i < schools.length; i++) {
            System.out.print((i > 0 ? "  - " : " ") + schools[i]);
        }
        //add a total option
        System.out.print(" - Total");
        System.out.println();//print the line
        
        //create a variable which will hold our total amount;
        double total = 0;
        
        //loop through the totals array printing the values in a grid like pattern
        for (int i = 0; i < totals.length; i++) {
            double rowtotal = 0;
            System.out.print("$" + amounts[i] + " - ");
            for (int j = 0; j < totals[i].length; j++) {
                rowtotal += totals[i][j];//append to the row total
                System.out.print(" " + totals[i][j] + " ");
            }
            System.out.print(" " + rowtotal);
            System.out.println();
            total += rowtotal;//add to the total amount of donations
        }
        //print out the total amount of donations
        System.out.println("Total of donations: " + total);
    }
}
