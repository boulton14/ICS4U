import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TextFileReader {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		// determine the path of the file
		String path = JOptionPane.showInputDialog("What is the path to the file?");

		// create an instance of the file
		File file = new File(path);
		try {
			// create a buffered reader to read from the file
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			// read the lines of the file
			while ((line = reader.readLine()) != null) {
				System.out.println(line);// print the line
			}
			// close the reader
			reader.close();
		} catch (FileNotFoundException e) {// excpetions when file not found/not
											// valid
			JOptionPane.showMessageDialog(null, "The file was not found.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "There was an error reading the file.");
		}
	}

}
