package dog;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Client {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        // tell the user the dogs will be created
        JOptionPane.showMessageDialog(null, "Two dogs will be created");

        // create a blank array of 2 dogs.
        final Dog[] dogs = new Dog[2];

        // set up the dogs information for all of the dogs
        for (int i = 0; i < dogs.length; i++) {
            final String name = JOptionPane.showInputDialog("What is the "
                    + (i + 1) + " dogs name?");
            final String breed = JOptionPane.showInputDialog("What is the "
                    + (i + 1) + " dogs breed?");

            // randomly apply some of the dogs variables
            final Random r = new Random();
            int initial_age = r.nextInt(15);
            int inital_hunger = r.nextInt(11);
            int initial_agression = r.nextInt(11);

            // verify the information with the user
            final String age = JOptionPane
                    .showInputDialog("Dog "
                            + (i + 1)
                            + " is "
                            + initial_age
                            + " years old. Is that okay? (If yes type \"ok\" otherwise type the new age)");
            final String hunger = JOptionPane
                    .showInputDialog("Dog "
                            + (i + 1)
                            + "'s hunger on a scale from 1-10 is "
                            + inital_hunger
                            + " . Is that okay? (If yes type \"ok\" otherwise type the new hunger level)");
            final String agression = JOptionPane
                    .showInputDialog("Dog "
                            + (i + 1)
                            + "'s agression on a scale from 1-10 is "
                            + initial_agression
                            + " . Is that okay? (If yes type \"ok\" otherwise type the new agression level)");
            if (!age.equalsIgnoreCase("ok")) {
                initial_age = Integer.parseInt(age);
            }
            if (!hunger.equalsIgnoreCase("ok")) {
                inital_hunger = Integer.parseInt(hunger);
            }
            if (!agression.equalsIgnoreCase("ok")) {
                initial_agression = Integer.parseInt(agression);
            }

            // create the instance of the dog
            dogs[i] = new Dog(name, breed, initial_age, inital_hunger,
                    initial_agression);

            // print out the dogs information
            JOptionPane.showMessageDialog(null, dogs[i].getName() + " is a "
                    + dogs[i].getBreed() + " which is " + dogs[i].getAge()
                    + " of age. The dog hunger level is " + dogs[i].getHunger()
                    + " and its agression level is " + dogs[i].getAggression());
        }

        // simulate a fight if the their agressions together are > 10 and hungers are < 5
        if (dogs[0].getAggression() + dogs[1].getAggression() > 10
                && dogs[0].getHunger() + dogs[1].getHunger() < 5) {
            JOptionPane.showMessageDialog(null, "The didn't like eachother!");
            return;
        } else {// otherwise no fight
            JOptionPane.showMessageDialog(null, "The dogs had a great time!");
        }
    }
}
