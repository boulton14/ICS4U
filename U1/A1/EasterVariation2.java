import java.text.DateFormatSymbols;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @date September 11 2012
 * @purpose Find the date that easter sunday will occur.
 * @author matthewlanglois11
 */
public class EasterVariation2 {

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
        int year = Calendar.getInstance().get(Calendar.YEAR);
        try {
            year = Integer.parseInt(JOptionPane.showInputDialog("Easter "
                    + "Date Calculator\nPlease enter a year"));
        } catch (final Exception e) {// invalid number entered
            JOptionPane
                    .showMessageDialog(
                            null,
                            "Oh No! You failed to enter a valied year!\nWe will just calculate for the current year: "
                                    + year);
        }
        // variables and calcualtions for the day easter will occur

        int a, b, c, d, q, f, g, h, j, k, n, p, month, day;
        a = year / 100;
        b = year % 100;
        c = (3 * (a + 25)) / 4;
        d = (3 * (a + 25)) % 4;
        q = (8 * (a + 11)) / 25;
        f = (5 * a + b) % 19;
        g = (19 * f + c - q) % 30;
        h = (f + 11 * g) / 319;
        j = (60 * (5 - d) + b) / 4;
        k = (60 * (5 - d) + b) % 4;
        n = (2 * j - k - g + h) % 7;
        month = (g - h + n + 114) / 31;
        p = (g - h + n + 114) % 31;
        day = (p + 1) / 1;

        // Display the results
        JOptionPane.showMessageDialog(null, "Easter will occur on Sunday "
                + new DateFormatSymbols().getMonths()[month - 1] + " " + day
                + ", " + year);

    }
}
