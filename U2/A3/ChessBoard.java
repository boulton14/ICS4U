import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChessBoard {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // Set 8 locations on the board
        for (int locations = 0; locations < 8; locations++) {
            // create a loop to check if the location is valid
            while (true) {
                // get the location from an input box in the form x,y
                final String location = JOptionPane
                        .showInputDialog(null,
                                "Enter the location in the form \"x,y\" or type exit to quit");
                // an optional way to just quit the program
                if (location.equalsIgnoreCase("exit")) {
                    return;
                }
                // check if the location string they entered is valid
                if (location == null || !location.contains(",")) {
                    JOptionPane.showMessageDialog(null,
                            "Please use the format \"x,y\"");
                    continue;
                }
                // split the string at the comma
                final String[] split = location.split(",");
                try {
                    // check that they only entered 2 coords
                    if (split.length == 2) {
                        final int x = Integer.parseInt(split[0]);
                        final int y = Integer.parseInt(split[1]);
                        // verify the x/y values are correct
                        if (x > 8 || x < 1) {
                            JOptionPane.showMessageDialog(null,
                                    "X value must be between 1 and 8");
                            continue;
                        }
                        if (y > 8 || y < 1) {
                            JOptionPane.showMessageDialog(null,
                                    "Y value must be between 1 and 8");
                            continue;
                        }
                        // set the values and exit the while loop
                        ChessBoard.board[x - 1][y - 1] = 1;
                        break;
                    }
                } catch (final Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Please use the format \"x,y\"");
                    continue;
                }
                JOptionPane.showMessageDialog(null,
                        "Please use the format \"x,y\"");
                continue;
            }
        }

        // print out the values in a loop i is the row
        for (final int[] element : ChessBoard.board) {
            // j is the coloum
            for (final int element2 : element) {
                // print the value at the specified coordnate
                System.out.print("|" + element2);
            }
            // print the line
            System.out.print("|");
            System.out.println();
        }
    }

    // Create the board
    private static final int[][] board = new int[][] {
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
}
