import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @purpose This program converts text to mores code
 * @date sept 11 2012
 * @author matthewlanglois11
 *
 */
public class MorseCode {

	/**
	 * An enum containing all of the valid mores codes.
	 * 
	 * @author matthewlanglois11
	 *
	 */
    enum Code {
        A("A", ".-"),
        B("B", "-..."),
        C("C", "-.-."),
        D("D", "-.. "),
        E("E", "."),
        F("F", "..-."),
        G("G", "--."),
        H("H", "...."),
        I("I", ".."),
        J("J", ".---"),
        K("K", "-.-"),
        L("L", ".-.."),
        M("M", "--"),
        N("N", "-."),
        O("O", "---"),
        P("P", ".--."),
        Q("Q", "--.-"),
        R("R", ".-."),
        S("S", "..."),
        T("T", "-"),
        U("U", "..-"),
        V("V", "...-"),
        W("W", ".--"),
        X("X", "-..-"),
        Y("Y", "-.--"),
        Z("Z", "--.."),
        ONE("1", ".----"),
        TWO("2", "..---"),
        THREE("3", "...--"),
        FOUR("4", "....-"),
        FIVE("5", "....."),
        SIX("6", "-...."),
        SEVEN("7", "--..."),
        EIGHT("8", "---.."),
        NINE("9", "----."),
        TEN("0", "-----");

        Code(String input, String output) {
            this.input = input;
            this.output = output;
        }

        /**
         * Get the letter value for the code
         * @return
         */
        public String getInput() {
            return input;
        }

        /**
         * Get the mores code
         * 
         * @return
         */
        public String getCode() {
            return output;
        }

        private final String input;

        private final String output;
    }

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
        String word = JOptionPane.showInputDialog("Enter a word: ").replace(
                " ", "");
        for (Code code : Code.values()) {
        	//reokace all case-insensitive
            word = word.replaceAll("(?ui)" + code.getInput(),
                    "\n" + code.getCode());
        }
        System.out.println(word);
    }

}
