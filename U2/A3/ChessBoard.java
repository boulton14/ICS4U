import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChessBoard {

	//Create the board
	private static final int[][] board = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		//Set 8 locations on the board
		for (int locations = 0; locations < 8; locations++) {
			//create a loop to check if the location is valid
			while (true) {
				//get the location from an input box in the form x,y
				String location = JOptionPane
						.showInputDialog(null,
								"Enter the location in the form \"x,y\" or type exit to quit");
				//an optional way to just quit the program
				if (location.equalsIgnoreCase("exit")) {
					return;
				}
				//check if the location string they entered is valid
				if (location == null || !location.contains(",")) {
					JOptionPane.showMessageDialog(null,
							"Please use the format \"x,y\"");
					continue;
				}
				//split the string at the comma
				String[] split = location.split(",");
				try {
					//check that they only entered 2 coords
					if (split.length == 2) {
						int x = Integer.parseInt(split[0]);
						int y = Integer.parseInt(split[1]);
						//verify the x/y values are correct
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
						//set the values and exit the while loop
						board[x - 1][y - 1] = 1;
						break;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Please use the format \"x,y\"");
					continue;
				}
				JOptionPane.showMessageDialog(null,
						"Please use the format \"x,y\"");
				continue;
			}
		}
		
		//print out the values in a loop i is the row
		for (int i = 0; i < board.length; i++) {
			//j is the coloum
			for (int j = 0; j < board[i].length; j++) {
				//print the value at the specified coordnate
				System.out.print("|" + board[i][j]);
			}
			//print the line
			System.out.print("|");
			System.out.println();
		}
	}
}
