import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Fibonacci {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        try {
            //loop to allow the user to check multiple times
            while (true) {
                //display a message dialogue asking the user which term they would like to see, along with the value of it
                JOptionPane.showMessageDialog(null, "The value is: "+ fibonacci(Integer.parseInt(JOptionPane.showInputDialog("What term of fibonacci would you like to see?"))));
            }
        } catch (Exception e) {
        }

    }

    public static int fibonacci(int n) {
        //recursive call
        return  n == 1 || n==2 ? 1 :fibonacci(n - 1) + fibonacci(n - 2);
    }

}
