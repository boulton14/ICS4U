import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WordPyrmaid {
    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // print out the pyrmid with their word
        WordPyrmaid.pyrmid(JOptionPane
                .showInputDialog("What word would you like to jumble?"));
    }

    private static void pyrmid(final String word) {
        // print the word
        System.out.println(word);
        // exit when we have reached the min length for a word
        if (word.length() == 1 || word.length() == 2) {
            return;
        }
        // recursivly call using the shortened string
        WordPyrmaid.pyrmid(word.substring(1, word.length() - 1));
    }
}
