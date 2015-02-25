package lock;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ComboLockDriver {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        // get the users input to set up a lock
        final int one = Integer
                .parseInt(JOptionPane
                        .showInputDialog("What is the first digit you would like to set?"));
        final int two = Integer
                .parseInt(JOptionPane
                        .showInputDialog("What is the second digit you would like to set?"));
        final int three = Integer
                .parseInt(JOptionPane
                        .showInputDialog("What is the third digit you would like to set?"));
        final ComboLock lock = new ComboLock(one, two, three);
        JOptionPane.showMessageDialog(null, "Now to open the lock!");
        // loop until they open their own lock
        while (true) {
            final int num1 = Integer.parseInt(JOptionPane
                    .showInputDialog("What is the first digit?"));
            final int num2 = Integer.parseInt(JOptionPane
                    .showInputDialog("What is the second digit?"));
            final int num3 = Integer.parseInt(JOptionPane
                    .showInputDialog("What is the third digit?"));
            // verify the combo
            if (num1 == lock.getOne() && num2 == lock.getTwo()
                    && num3 == lock.getThree()) {
                JOptionPane.showMessageDialog(null, "Correct!");
                break;
            }
            JOptionPane.showMessageDialog(null, "Incorrect!");
        }

        // create a lock with random numbers upto 3
        final Random ran = new Random();
        final ComboLock random = new ComboLock(ran.nextInt(3) + 1,
                ran.nextInt(3) + 1, ran.nextInt(3) + 1);

        // tell them to gess the lock
        JOptionPane
                .showMessageDialog(null,
                        "Guess the next locks combo, you have 3 trys. Each digit is between 1-3");

        // put them in a loop which will execute 3 times before moving on
        for (int guesses = 0; guesses < 3; guesses++) {
            final int num1 = Integer.parseInt(JOptionPane
                    .showInputDialog("What is the first digit?"));
            final int num2 = Integer.parseInt(JOptionPane
                    .showInputDialog("What is the second digit?"));
            final int num3 = Integer.parseInt(JOptionPane
                    .showInputDialog("What is the third digit?"));
            // verify the match
            if (num1 == random.getOne() && num2 == random.getTwo()
                    && num3 == random.getThree()) {
                // notify they guessed right
                JOptionPane.showMessageDialog(null, "Correct!");
                return;// exit
            }
            JOptionPane.showMessageDialog(null, "Incorrect!");
        }
        // tell them they had 3 incorrect trys and give them the combo
        JOptionPane.showMessageDialog(null,
                "3 incorrect guesses! The combo was " + random.getOne() + " - "
                        + random.getTwo() + " - " + random.getThree());
    }
}
