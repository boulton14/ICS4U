import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PslamReader {

	public static void main(String[] args) throws IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		// find the file in the same location as the compiled class
		File file = new File(QuoteReader.class.getProtectionDomain().getCodeSource().getLocation()
				.getFile(), "psalms.txt");

		// open the reader
		BufferedReader reader = new BufferedReader(new FileReader(file));

		ArrayList<String> lines = new ArrayList<String>();

		// read the lines in the file
		String s;
		while ((s = reader.readLine()) != null) {
			lines.add(s);
		}

		// close the reader
		reader.close();

		// loop asking for a psalm number
		while (true) {
			String option = JOptionPane.showInputDialog("Please enter a psalm number.");
			if (option == null) {
				//they pressed cancle
				System.out.println("Thanks for using my program.");
				return;
			}
			//find the index of the match
			int match = linearSearch(lines, option);
			//print out the message at the matches index + 1
			System.out.println(match != -1 ? lines.get(match + 1) : "No match found");
		}

	}

	// slightly modified search algorithm which will return -1 when none was
	// found otherwise it will return the index.
	private static int linearSearch(ArrayList<String> lines, String match) {
		int k;
		for (k = 0; k < lines.size(); k++) {
			//match found return
			if (lines.get(k).equals(match)) {
				return k;
			}
		}
		return -1;
	}

}
