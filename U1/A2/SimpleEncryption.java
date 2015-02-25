import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

class GUI extends JFrame {

    /**
     * Checks if a string is a valid integer.
     *
     * @param message
     *            The string to parse.
     * @return True if the string is a valid number; otherwise false.
     */
    public static boolean canParse(final String message) {
        try {
            Integer.parseInt(message);
        } catch (final Exception e) {
            return false;
        }
        return true;
    }

    private static final long serialVersionUID = 2053636315187421222L;

    private JButton encrypt;

    private JButton decrypt;

    private JTextField text;

    private JTextField encryption;

    private JTextField amount;

    public GUI() {
        this.initComponents();
    }

    private void decryptActionPerformed(final ActionEvent e) {
        int amount = 13; // ROT 13 reference
        if (GUI.canParse(this.amount.getText())) {
            amount = Integer.parseInt(this.amount.getText());
            if (amount > 25 || amount < 1) {
                JOptionPane.showMessageDialog(this,
                        "The amount to shift must be between 1-25");
                return;
            }
        }
        text.setText(SimpleEncryption.decrypt(encryption.getText(), amount));
    }

    private void encryptActionPerformed(final ActionEvent e) {
        int amount = 13; // ROT 13 reference
        if (GUI.canParse(this.amount.getText())) {
            amount = Integer.parseInt(this.amount.getText());
            if (amount > 25 || amount < 1) {
                JOptionPane.showMessageDialog(this,
                        "The amount to shift must be between 1-25");
                return;
            }
        }
        encryption.setText(SimpleEncryption.encrypt(text.getText(), amount));
    }

    /**
     * Set up and add all of the components to the frame.
     */
    private void initComponents() {
        encrypt = new JButton();
        decrypt = new JButton();
        encryption = new JTextField();
        text = new JTextField();
        amount = new JTextField();

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                System.exit(1);
            }
        });

        this.setTitle("Simple Encryption Program by Matt");
        final Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        this.setResizable(false);

        decrypt.setText("Decrypt");
        decrypt.addActionListener(e -> GUI.this.decryptActionPerformed(e));
        contentPane.add(decrypt);
        decrypt.setBounds(5, 105, 290, 20);

        text.setText("Plain text...");
        contentPane.add(text);
        text.setBounds(5, 5, 290, 20);

        amount.setText("ROT Amount...");
        contentPane.add(amount);
        amount.setBounds(5, 55, 290, 20);

        encryption.setText("Encryption...");
        contentPane.add(encryption);
        encryption.setBounds(5, 30, 290, 20);

        encrypt.setText("Encrypt");
        contentPane.add(encrypt);
        encrypt.setBounds(5, 80, 290, 20);
        encrypt.addActionListener(e -> GUI.this.encryptActionPerformed(e));

        contentPane.setPreferredSize(new Dimension(300, 130));
        this.pack();
    }
}

/**
 * @date September 11 2012
 * @purpose A very simple encryption based off of ROT13
 * @author matthewlanglois11
 */
public class SimpleEncryption {

    /**
     * @param string
     *            The string to decrypt
     * @param shift
     *            The shift amount
     * @return The decrypted string
     */
    public static String decrypt(final String string, final int shift) {
        String decrypted = "";
        for (final char c : string.toCharArray()) {
            if (Character.isLetter(c)) {
                int abyte = (c) - shift;
                if (Character.isUpperCase(c)) {
                    if (abyte < SimpleEncryption.min_upper) {// wrap around the alphabet
                        abyte = abyte + SimpleEncryption.max_upper
                                - SimpleEncryption.min_upper + 1;
                    }
                } else {
                    if (abyte < SimpleEncryption.min_lower) {// wrap around the alphabet
                        abyte = abyte + SimpleEncryption.max_lower
                                - SimpleEncryption.min_lower + 1;
                    }
                }
                decrypted += String.valueOf((char) abyte);
            } else {
                decrypted += String.valueOf(c);
            }
        }
        return decrypted;
    }

    /**
     * @param string
     *            The string to encrypt
     * @param shift
     *            The amount to shift 1-25
     * @return The encrypted string
     */
    public static String encrypt(final String string, final int shift) {
        String encrypted = "";
        for (final char c : string.toCharArray()) {
            if (Character.isLetter(c)) {
                int abyte = (c) + shift;
                if (Character.isUpperCase(c)) {
                    if (abyte > SimpleEncryption.max_upper) {// wrap around the alphabet
                        abyte = abyte - 1 - SimpleEncryption.max_upper
                                + SimpleEncryption.min_upper;
                    }
                } else {
                    if (abyte > SimpleEncryption.max_lower) {// wrap around the alphabet
                        abyte = abyte - 1 - SimpleEncryption.max_lower
                                + SimpleEncryption.min_lower;
                    }
                }
                encrypted += String.valueOf((char) abyte);
            } else {
                encrypted += String.valueOf(c);
            }
        }
        return encrypted;
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
        // create an instance of the gui and set it visible
        new GUI().setVisible(true);
    }

    // Max/Mins unicodes for chars A-Z and a-z
    private static final int min_lower = 97;
    private static final int max_lower = 122;

    private static final int min_upper = 65;

    private static final int max_upper = 90;
}
