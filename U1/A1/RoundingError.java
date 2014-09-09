import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @date September 11 2012
 * @purpose Causes a rounding error
 * @author matthewlanglois11
 * 
 */
public class RoundingError {

    /**
     * The main method which initlizes the program.
     * 
     * @param args
     *            Any arguments passed to the program.
     * @throws UnsupportedLookAndFeelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        double num;
        try {
            num = Double.parseDouble(JOptionPane
                    .showInputDialog("Enter a number: "));
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Oh No! You failed to enter a valied number!");
            return;
        }
        double d = Math.pow(Math.sqrt(num), 2);//calculate the square of the squareroot
        //output the information
        JOptionPane.showMessageDialog(null, "The square of the square: " + d
                + "\nThe roundoff error is: " + (num - d));
    }
}
