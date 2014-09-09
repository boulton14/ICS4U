import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CustomerList {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, IOException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		// Variables to be used
		ArrayList<String> existing_customers = new ArrayList<String>();
		ArrayList<String> new_customers = new ArrayList<String>();

		// find the file in the same location as the compiled class
		File file = new File(CustomerList.class.getProtectionDomain()
				.getCodeSource().getLocation().getFile(), "customers.txt");

		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		} else {
			System.out.println("Current users\n");
			try {
				// init the buffered reader
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				// read the lines
				while ((line = reader.readLine()) != null) {
					existing_customers.add(line);// add the customers
				}
				// close the reader
				reader.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "The file was not found.");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"There was an error reading the file.");
			}

			// print out existing coustomers
			for (String line : existing_customers) {
				String[] splits = line.split("\\|");
				for (String split : splits) {
					System.out.println(split);
				}
				System.out.println("\n");
			}
		}

		boolean cont = true;
		// loop until the user wishes to exit
		while (cont) {
			try {
				String opertation = JOptionPane
						.showInputDialog("Operations:\n1. Add a user\n2. Show current users\n3. Save & exit");

				switch (opertation) {
				case "1":
					String name = JOptionPane
							.showInputDialog("What is the customers name?");
					String address = JOptionPane
							.showInputDialog("What is the address?");
					String city = JOptionPane
							.showInputDialog("What is the city?");
					String province = JOptionPane
							.showInputDialog("What is the province?");
					String postalcode = JOptionPane
							.showInputDialog("What is the postalcode?");
					if (!postalcode
							.matches("^[A-Z]{1}\\d{1}[A-Z]*\\d{1}[A-Z]{1}\\d{1}$")) {// verify postal codes length
						System.err
								.println("Invalid postal code entered. Please use the format L#L#L#");
						break;
					}
					// add them to the new list of coustomers
					new_customers.add("Name: " + name + "|Address: " + address
							+ "|City: " + city + "|Province: " + province
							+ "|Postalcode: " + postalcode);
					break;
				case "2":
					// pritn out exising users
					for (String customer : existing_customers) {
						String[] splits = customer.split("\\|");
						for (String split : splits) {
							System.out.println(split);
						}
						System.out.println("\n");
					}
					// print out new users
					for (String customer : new_customers) {
						String[] splits = customer.split("\\|");
						for (String split : splits) {
							System.out.println(split);
						}
						System.out.println("\n");
					}
					break;
				case "3":
					// exit
					cont = false;
					break;
				}
			} catch (Exception e) {
				System.err
						.println("You have clicked cancle. To exit the program please type 3.");
			}
		}
		// write using append mode
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		for (String customer : new_customers) {
			writer.write(customer);// write the line
		}
		// flush and close the stream
		writer.flush();
		writer.close();
	}
}
