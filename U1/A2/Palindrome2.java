import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @date September 11 2012
 * @purpose Checks if a sentence contains plaindroms
 * @author matthewlanglois11
 */
public class Palindrome2 {

    /**
     * Joins the string elements of an arraylist
     *
     * @param c
     *            The collection
     * @param seperator
     *            The charcter to be used as the seperator
     * @return
     */
    public static String join(final List<String> c, final String seperator) {
        String output = "";
        for (int i = 0; i < c.size(); i++) {
            final String s = c.get(i);
            output += s + (i < c.size() - 1 ? seperator : "");
        }
        return output.trim();
    }

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
        final ArrayList<String> plaindroms = new ArrayList<String>();
        final String[] words = JOptionPane
                .showInputDialog("Enter a sentence: ").split("\\s+");
        for (final String word : words) {
            final String reverse = Palindrome2.reverse(word);
            if (word.equalsIgnoreCase(reverse)) {
                plaindroms.add(word);
            }
        }
        System.out.println(plaindroms.size() > 0 ? "The plaindroms are: "
                + Palindrome2.join(plaindroms, ", ")
                : "You have no plaindroms!");
    }

    /**
     * Reverse the words
     *
     * @param s
     *            The word to reverse
     * @return The reversed version of a string
     */
    public static String reverse(final String s) {
        if (s.length() <= 1) {
            return s;
        }
        // recursivly call the reverse function
        return Palindrome2.reverse(s.substring(1, s.length())) + s.charAt(0);
    }
}
