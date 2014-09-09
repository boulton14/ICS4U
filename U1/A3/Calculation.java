import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @date September 11 2012
 * @purpose Calculate the sum, product, diffrence and quotient of two double
 * @author matthewlanglois11
 * 
 */
public class Calculation {

    /**
     * 
     * @param args
     *            Program args
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws UnsupportedLookAndFeelException
     */
    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        // Set a nicer look and feel
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        double first, second;
        try {
            // take the inputs and assign them to the variables
            first = Double.parseDouble(JOptionPane
                    .showInputDialog("Enter your first double value: "));
            second = Double.parseDouble(JOptionPane
                    .showInputDialog("Enter your second double value: "));
        } catch (final Exception e) {// Prevent any invalid doubles and prevent throwing the error
            JOptionPane.showMessageDialog(null,
                    "Oh No! You failed to enter a valid double!");
            return;// prevent further execution
        }
        // addition
        System.out.println("Sum: " + (first + second));
        // product
        System.out.println("Product: " + (first * second));
        // Difference
        System.out.println("Difference: " + (first - second));
        // Quotient
        System.out.println("Quotient: " + (first / second));
    }
}
