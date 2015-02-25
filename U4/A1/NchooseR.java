import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class NchooseR {

    public static int choose(final int set, final int amount) {
        // if the set is less than the amount to calculate then there will be no possible way
        if (set < amount) {
            return 0;
        }
        // recursivly call until the amount == 0/set size then return 1
        return amount == 0 || amount == set ? 1 : NchooseR.choose(set - 1,
                amount - 1) + NchooseR.choose(set - 1, amount);
    }

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        try {
            while (true) {
                // find the amount to calculate
                final int amount = Integer
                        .parseInt(JOptionPane
                                .showInputDialog("How many objects would you like to choose?"));
                // find the amount of objects in the set
                final int set = Integer
                        .parseInt(JOptionPane
                                .showInputDialog("How many objects are there to choose from?"));
                // print out
                System.out.println("There are " + NchooseR.choose(set, amount)
                        + " ways to choose " + amount
                        + " object(s) from a set of " + set + " objects.");
            }
        } catch (final Exception e) {
        }
    }
}
