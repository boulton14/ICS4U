import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Resistor {

    private static String[] colors = new String[] { "black", "brown", "red",
            "orange", "yellow", "green", "blue", "violet", "grey", "white" };
    private static String[] values = new String[] { "0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9" };

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        String input = JOptionPane.showInputDialog("Your resistors: ");
        // output the information
        try {
            String[] inputs = input.split("-");
            String[] resistors = new String[inputs.length];
            int currIdx = 0;
            for (String s : inputs) {
                s.replaceAll("[\\W]", "");
                for (int idx = 0; idx < colors.length; idx++) {
                    if (s.equalsIgnoreCase(colors[idx])) {
                        resistors[currIdx] = values[idx];
                        currIdx++;
                        break;
                    }
                }
            }
            int resistance = 0;
            String tempResistance = "0";// prevent invalid exceptions for only one resistor
            for (int idx = 0; idx < resistors.length; idx++) {
                if (idx == resistors.length - 1) {
                    resistance = (int) (Integer.parseInt(tempResistance) * (Math
                            .pow(10, Integer.parseInt(resistors[idx]))));
                    continue;
                }
                tempResistance += resistors[idx];
            }
            JOptionPane.showMessageDialog(null,
                    "The value of the resistor is: " + resistance + " ohms");
        } catch (Exception e) {
            JOptionPane
                    .showMessageDialog(null,
                            "You failed to enter a valid resistor color! Please try again!");
            main(args);
            return;
        }
    }
}
