import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WordJuble {

    // jumble
    private static ArrayList<String> jumble(final String word) {
        return WordJuble.jumble(word, "");
    }

    // jumbe the words
    private static ArrayList<String> jumble(final String word,
            final String jumbLet) {
        final ArrayList<String> words = new ArrayList<String>();
        String remainingLetters;
        final String origWord = word;
        final String origJumbledLetters = jumbLet;
        if (word.length() == 1) {
            words.add(jumbLet + word);
        } else {
            for (int pos = 0; pos < origWord.length(); pos++) {
                remainingLetters = origWord.substring(0, pos)
                        + origWord.substring(pos + 1, origWord.length());
                words.addAll(WordJuble.jumble(remainingLetters,
                        origJumbledLetters + origWord.charAt(pos)));
            }
        }
        return words;
    }

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        // take in the input
        final ArrayList<String> possibles = WordJuble.jumble(JOptionPane
                .showInputDialog("What word would you like to jumble?"));

        // print out the info
        System.out.println(possibles.toString().replace("[", "")
                .replace("]", "").replace(" ", "").replace(",", "\n"));
    }
}
