import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Hangman {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // find a row and colom for the word to use
        final int row = new Random().nextInt(Hangman.category.length);
        final int colom = new Random().nextInt(Hangman.words[row].length);
        // a variable containing the lives left
        int lives = 7;
        // find the word to compare the output to
        final String word = Hangman.words[row][colom];
        // create the default output
        String output = word.replaceAll("[A-Za-z$-]", "-");
        try {
            // put the user in a loop to keep guessing untill they win or loose
            while (true) {
                // print some information for the user
                System.out.println("Category: " + Hangman.category[row]);
                System.out.println("Word: " + output);

                // allow them to guess
                final String input = JOptionPane
                        .showInputDialog("Guesses remaining: " + lives
                                + "\nGuess a letter: ");
                // turn their guess into a string
                final String guess = Character.toString(input.charAt(0));
                // check if the real word contains their guess
                if (word.toLowerCase().contains(guess.toLowerCase())) {
                    // set up the new output
                    for (int i = 0; i < word.length(); i++) {
                        if (Character.toString(word.charAt(i))
                                .equalsIgnoreCase(guess)) {
                            final StringBuilder builder = new StringBuilder(
                                    output);
                            builder.replace(i, i + 1,
                                    Character.toString(word.charAt(i)));
                            output = builder.toString();
                        }
                    }
                    // check if they have guessed the full word
                    if (output.equalsIgnoreCase(word)) {
                        JOptionPane.showMessageDialog(null,
                                "You have guessed the correct word: " + word
                                        + "\nYou win!");
                        System.exit(0);
                    }
                } else {// else subtract a life, if 0 lives then tell them they lost and exit the game
                    if (lives == 0) {
                        JOptionPane.showMessageDialog(null,
                                "You loose!\nThe correct word was: " + word);
                        System.exit(0);
                    }
                    lives--;
                }
                // print out the hang man
                Hangman.printHangman(lives);
                System.out.println("\n");
            }
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Thanks for playing!");
        }
    }

    // print the lines based on the lives remaining
    private static void printHangman(final int lives) {
        if (lives == 7) {
            return;
        } else if (lives == 6) {
            System.out.println(" O ");
        } else if (lives == 5) {
            System.out.println(" O ");
            System.out.println("/ ");
        } else if (lives == 4) {
            System.out.println(" O ");
            System.out.println("/|");
        } else if (lives == 3) {
            System.out.println(" O ");
            System.out.println("/|\\");
        } else if (lives == 2) {
            System.out.println(" O ");
            System.out.println("/|\\");
            System.out.println("/  ");
        } else if (lives == 1) {
            System.out.println(" O ");
            System.out.println("/|\\");
            System.out.println("/ \\ ");
        }
    }

    // define some constants
    private static final String[] category = new String[] { "Computers",
            "Games", "TV", "Movies" };

    private static final String[][] words = new String[][] {
            { "Java", "Netbeans", "Eclipse" },
            { "Halo", "Call of Duty", "Minecraft" },
            { "Flashpoint", "Criminal Minds", "NCIS" },
            { "Saving private ryan", "Letters from iwo jima", "Defiance" } };
}
