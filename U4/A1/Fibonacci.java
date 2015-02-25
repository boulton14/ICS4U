import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Fibonacci {

    public static int fibonacci(final int n) {
        // recursive call
        return n == 1 || n == 2 ? 1 : Fibonacci.fibonacci(n - 1)
                + Fibonacci.fibonacci(n - 2);
    }

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        try {
            // loop to allow the user to check multiple times
            while (true) {
                // display a message dialogue asking the user which term they would like to see, along with the value of it
                JOptionPane
                        .showMessageDialog(
                                null,
                                "The value is: "
                                        + Fibonacci.fibonacci(Integer.parseInt(JOptionPane
                                                .showInputDialog("What term of fibonacci would you like to see?"))));
            }
        } catch (final Exception e) {
        }

    }

}
