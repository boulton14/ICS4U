import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Cancer {
	// create the map of cells (+ = good - = cancer)
	private static LinkedList<String> map = new LinkedList<String>();

	private static int count = 0;

	public static void main(String[] args) throws IOException {
		// find the file in the same location as the compiled class
		File file = new File(QuoteReader.class.getProtectionDomain().getCodeSource().getLocation()
				.getFile(), "cancer.txt");

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

		// add the values to the map
		for (int i = 0; i < lines.size(); i++) {
			map.add(lines.get(i));
		}

		for (int y = 0; y < map.size(); y++) {
			for (int x = 0; x < map.get(y).length(); x++) {
				if (map.get(y).charAt(x) == '-') {
					floodFill(y, x);
					count++;
				}
			}
		}
		floodFill(0, 0);
		System.out.println("There were " + count + " cancerous blobs \nHere is the cancer map.\n");
		// print out the grid
		for (int y = 0; y < map.size(); y++) {
			for (int x = 0; x < map.get(y).length(); x++) {
				System.out.print(map.get(y).charAt(x) == ' ' ? '-' : '+');
			}
			System.out.println();
		}
	}

	public static void floodFill(int row, int col) {
		// find the cancer cells recursivly
		if (map.get(row).charAt(col) == '-') {
			map.set(row, map.get(row).replaceFirst("-", " "));
			if (row - 1 >= 0 && col - 1 >= 0 && col - 1 < map.get(row - 1).length()) {
				floodFill(row - 1, col - 1);
			}
			if (row - 1 >= 0 && col < map.get(row - 1).length()) {
				floodFill(row - 1, col);
			}
			if (row - 1 >= 0 && col + 1 < map.get(row - 1).length()) {
				floodFill(row - 1, col + 1);
			}
			if (col - 1 >= 0 && col - 1 < map.get(row).length()) {
				floodFill(row, col - 1);
			}
			if (col + 1 < map.get(row).length() && col + 1 < map.get(row).length()) {
				floodFill(row, col + 1);
			}
			if (row + 1 < map.size() && col - 1 >= 0 && col - 1 < map.get(row + 1).length()) {
				floodFill(row + 1, col - 1);
			}
			if (row + 1 < map.size() && col < map.get(row + 1).length()) {
				floodFill(row + 1, col);
			}
			if (row + 1 < map.size() && col + 1 < map.get(row + 1).length()) {
				floodFill(row + 1, col + 1);
			}
		}
	}

}
