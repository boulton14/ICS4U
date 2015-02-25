import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class QuoteReader {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        // find the file in the same location as the compiled class
        final File file = new File(QuoteReader.class.getProtectionDomain()
                .getCodeSource().getLocation().getFile(), "quotes.txt");

        // create an empty dynamic array
        final ArrayList<String> quotes = new ArrayList<String>();
        try {
            // init the buffered reader
            final BufferedReader reader = new BufferedReader(new FileReader(
                    file));
            String line;
            // read the lines
            while ((line = reader.readLine()) != null) {
                quotes.add(line);// add the quotes
            }
            // close teh reader
            reader.close();
        } catch (final FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "The file was not found.");
        } catch (final IOException e) {
            JOptionPane.showMessageDialog(null,
                    "There was an error reading the file.");
        }
        // print out a random line
        JOptionPane.showMessageDialog(null, "The quote of the day is: "
                + quotes.get(new Random().nextInt(quotes.size())));
    }
}
