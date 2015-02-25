import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Cancer {
    public static void floodFill(final int row, final int col) {
        // find the cancer cells recursivly
        if (Cancer.map.get(row).charAt(col) == '-') {
            Cancer.map.set(row, Cancer.map.get(row).replaceFirst("-", " "));
            if (row - 1 >= 0 && col - 1 >= 0
                    && col - 1 < Cancer.map.get(row - 1).length()) {
                Cancer.floodFill(row - 1, col - 1);
            }
            if (row - 1 >= 0 && col < Cancer.map.get(row - 1).length()) {
                Cancer.floodFill(row - 1, col);
            }
            if (row - 1 >= 0 && col + 1 < Cancer.map.get(row - 1).length()) {
                Cancer.floodFill(row - 1, col + 1);
            }
            if (col - 1 >= 0 && col - 1 < Cancer.map.get(row).length()) {
                Cancer.floodFill(row, col - 1);
            }
            if (col + 1 < Cancer.map.get(row).length()
                    && col + 1 < Cancer.map.get(row).length()) {
                Cancer.floodFill(row, col + 1);
            }
            if (row + 1 < Cancer.map.size() && col - 1 >= 0
                    && col - 1 < Cancer.map.get(row + 1).length()) {
                Cancer.floodFill(row + 1, col - 1);
            }
            if (row + 1 < Cancer.map.size()
                    && col < Cancer.map.get(row + 1).length()) {
                Cancer.floodFill(row + 1, col);
            }
            if (row + 1 < Cancer.map.size()
                    && col + 1 < Cancer.map.get(row + 1).length()) {
                Cancer.floodFill(row + 1, col + 1);
            }
        }
    }

    public static void main(final String[] args) throws IOException {
        // find the file in the same location as the compiled class
        final File file = new File(QuoteReader.class.getProtectionDomain()
                .getCodeSource().getLocation().getFile(), "cancer.txt");

        // open the reader
        final BufferedReader reader = new BufferedReader(new FileReader(file));

        final ArrayList<String> lines = new ArrayList<String>();

        // read the lines in the file
        String s;
        while ((s = reader.readLine()) != null) {
            lines.add(s);
        }

        // close the reader
        reader.close();

        // add the values to the map
        for (int i = 0; i < lines.size(); i++) {
            Cancer.map.add(lines.get(i));
        }

        for (int y = 0; y < Cancer.map.size(); y++) {
            for (int x = 0; x < Cancer.map.get(y).length(); x++) {
                if (Cancer.map.get(y).charAt(x) == '-') {
                    Cancer.floodFill(y, x);
                    Cancer.count++;
                }
            }
        }
        Cancer.floodFill(0, 0);
        System.out.println("There were " + Cancer.count
                + " cancerous blobs \nHere is the cancer map.\n");
        // print out the grid
        for (int y = 0; y < Cancer.map.size(); y++) {
            for (int x = 0; x < Cancer.map.get(y).length(); x++) {
                System.out
                        .print(Cancer.map.get(y).charAt(x) == ' ' ? '-' : '+');
            }
            System.out.println();
        }
    }

    // create the map of cells (+ = good - = cancer)
    private static LinkedList<String> map = new LinkedList<String>();

    private static int count = 0;

}
