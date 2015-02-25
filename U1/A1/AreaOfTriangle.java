import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @date September 11 2012
 * @purpose Calculates the area of a triangle
 * @author matthewlanglois11
 */
public class AreaOfTriangle {

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
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// set
                                                                            // a
                                                                            // more
                                                                            // appropriate
                                                                            // look
                                                                            // and
                                                                            // feel
        double a, b, c;// the side lengths of the triangle
        try { // calculate the input values
            a = Double
                    .parseDouble(JOptionPane
                            .showInputDialog("Enter your \"first side length\" value: "));
            b = Double
                    .parseDouble(JOptionPane
                            .showInputDialog("Enter your \"second side length\" value: "));
            c = Double
                    .parseDouble(JOptionPane
                            .showInputDialog("Enter your \"third side length\" value: "));
        } catch (final Exception e) {// check the inputs were valid
            JOptionPane.showMessageDialog(null,
                    "Oh No! You failed to enter a valied number!");
            return;
        }
        final double s = (a + b + c) / 2;// calcualte the semi-perimiter
        final double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));// calculate
                                                                       // the
                                                                       // area
        JOptionPane.showMessageDialog(null, "The area is: " + area + " units²");// output
                                                                                // the
                                                                                // info
    }
}
