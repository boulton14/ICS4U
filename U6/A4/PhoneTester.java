import javax.swing.JOptionPane;

public class PhoneTester {
	public static void main(String[] args) {
		// create a cellphone object
		CellPhone phone = new CellPhone("Rogers", "iPhone", 1.2, 64.0, 10);

		// use getters to printout its information
		System.out.println("Carrier = " + phone.getCarrier());
		System.out.println("Type of phone = " + phone.getType());
		System.out.println("Speed of phone = " + phone.getSpeed() + " Ghz");
		System.out.println("Memory = " + phone.getMemory() + " Gb");
		System.out.println("Number of Apps = " + phone.getApps());
		System.out.println();
		System.out.println();

		// loop until printed out valid information
		while (true) {
			// initilize default variables
			String carrier = "";
			String type = "";
			double speed = 0.0;
			double memory = 0.0;
			int apps = 0;
			try {
				// assigin variables
				carrier = JOptionPane.showInputDialog("What is the phones carrier?");
				type = JOptionPane.showInputDialog("What is the phones type?");
				speed = Double
						.parseDouble(JOptionPane.showInputDialog("What is the phones speed?"));
				memory = Double.parseDouble(JOptionPane
						.showInputDialog("What is the phones memory?"));
				apps = Integer
						.parseInt(JOptionPane.showInputDialog("How many apps are installed?"));
			} catch (Exception e) {
				// error restart the loop
				System.out.println("There was an error entering the information please try again");
				continue;
			}
			// create the custom phone for the user
			CellPhone custom = new CellPhone(carrier, type, speed, memory, apps);

			// print out the custom phones information
			System.out.println("Carrier = " + custom.getCarrier());
			System.out.println("Type of phone = " + custom.getType());
			System.out.println("Speed of phone = " + custom.getSpeed() + " Ghz");
			System.out.println("Memory = " + custom.getMemory() + " Gb");
			System.out.println("Number of Apps = " + custom.getApps());

			// exit once the information is entered
			break;
		}

	}
}
