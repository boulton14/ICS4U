import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GCD {

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        try {
            // loop to allow for multiple calculations
            while (true) {
                // find numerator
                int num = Integer.parseInt(JOptionPane
                        .showInputDialog("What is the numerator?"));
                // find denominator
                int den = Integer.parseInt(JOptionPane
                        .showInputDialog("What is the denominator?"));
                // find the greatest common divisor (factor)
                int gcd = getGCD(num, den);

                // calculate new fractions
                int min_num = num / gcd;
                int min_den = den / gcd;

                // tell the user
                System.out.println("The fraction " + num + "/" + den
                        + " can be reduced to " + min_num + "/" + min_den);
            }
        } catch (Exception e) {
        }
    }

    private static int getGCD(int num, int den) {
        // when the denominator is 0 return the numerator, if the denominator > numerator flip and recalculate GCD otherwise recursivly call getGDC the denominator, numerator %denominator
        // ex 30/25
        // 1. flip and do getGDC 25, 30
        // 2. calculate remainder of numerator % denominator (30%25) == 5
        // 3. recursivly call getGDC with the new values of 30, 5
        // 4. calculate remainder of numerator % denominator (30%5) == 0
        // 5. recursivly call with new values of 30, 0
        // 6. we found our denominator is now 0, return the numerator [which is now the GCD] (5)
        return den == 0 ? num : den > num ? getGCD(den, num) : getGCD(den, num
                % den);
    }
}
