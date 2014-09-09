package car;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CarTester {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        // Set up some default questions
        final String[] questions = new String[] { "What is the make?",
                "What is the model?", "What is the size?" };
        final String[] info = new String[3];
        for (int i = 0; i < questions.length; i++) {
            info[i] = JOptionPane.showInputDialog(questions[i]);
        }

        // set up some more default questions
        final String[] questions2 = new String[] { "What is the make?",
                "What is the model?", "What is the year?",
                "What is the price?", "What is the color?", "What is the size?" };
        final Object[] info2 = new Object[6];
        for (int i = 0; i < questions2.length; i++) {
            info2[i] = JOptionPane.showInputDialog(questions2[i]);
        }

        // create the Car objects
        final Car car1 = new Car();
        final Car car2 = new Car(info[0], info[1], info[2]);
        final Car car3 = new Car((String) info2[0], (String) info2[1],
                Integer.parseInt((String) info2[2]),
                Integer.parseInt((String) info2[3]), (String) info2[4],
                (String) info2[5]);

        // Print out the information
        System.out.println("The first car has the following info: "
                + car1.toString());
        System.out.println("\nThe second car has the following info: "
                + car2.toString());
        System.out.println("\nThe third car has the following info: "
                + car3.toString());
    }
}
