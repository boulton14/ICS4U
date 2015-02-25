import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @date September 11 2012
 * @purpose Checks if a word is a plaindrom
 * @author matthewlanglois11
 */
public class Palindrome {

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
        // a simple user imput box
        final String word = JOptionPane.showInputDialog("Enter a word: ")
                .replace(" ", "");
        final String reverse = Palindrome.reverse(word);// fetch the reverse
        // output the results
        System.out
                .println(reverse.equalsIgnoreCase(word) ? "Your word is a plaindrom!"
                        : "Your word is not a plaindrom");
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
        return Palindrome.reverse(s.substring(1, s.length())) + s.charAt(0);
    }
}
