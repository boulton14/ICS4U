package bank;

import javax.swing.JOptionPane;

public class MyBankMachine {

    // create an instance of the ATM
    private static final ATM bank = new ATM("My Bank", 0);

    public static void main(String[] args) {
        while (true) {
            String option = JOptionPane
                    .showInputDialog("Would you like to:\n1. Deposit\n2. Withdraw\n3. View your balance.\n4. Set up intrest\n5. Exit");
            // switch through the users options
            switch (option) {
                case "1":
                    // deposit
                    try {
                        bank.deposit(Double.parseDouble(JOptionPane
                                .showInputDialog("How much would you like to deposit?")));
                    } catch (Exception e) {// failsafe
                        if (e instanceof NumberFormatException) {
                            JOptionPane
                                    .showMessageDialog(null,
                                            "You must enter a valid number to deposit.");
                            break;
                        }
                        JOptionPane.showMessageDialog(null,
                                "You can't deposit more than $200");
                    }
                    break;
                case "2":
                    // withdraw
                    try {
                        bank.withdraw(Double.parseDouble(JOptionPane
                                .showInputDialog("How much would you like to withdraw?")));
                    } catch (Exception e) {// failasfe
                        if (e instanceof NumberFormatException) {
                            JOptionPane
                                    .showMessageDialog(null,
                                            "You must enter a valid number to withdraw.");
                            break;
                        }
                        JOptionPane.showMessageDialog(null,
                                "You have exceeded you maximum withdraw limit of: "
                                        + bank.getBalance());
                    }
                    break;
                case "3":
                    // display the balance
                    bank.displayBalance();
                    break;
                case "4":
                    // calculate intrest
                    double start = Double
                            .parseDouble(JOptionPane
                                    .showInputDialog("How much would you like to start with?"));
                    if (start > bank.getBalance()) {// failsafe to check start amount is good
                        JOptionPane.showMessageDialog(null,
                                "You have exceeded you maximum balance of: "
                                        + bank.getBalance());
                        continue;
                    }
                    double rate = Double
                            .parseDouble(JOptionPane
                                    .showInputDialog("What is the annual intrest rate"));
                    int days = Integer
                            .parseInt(JOptionPane
                                    .showInputDialog("How many days would you like to collect intrest?"));
                    double intrest = start * Math.pow((1 + rate), days);
                    bank.unsafeDeposit(intrest);
                    JOptionPane.showMessageDialog(null, "You have gained $"
                            + intrest + " of intrest over " + days + " days.");
                    break;
                case "5":// exit
                    System.exit(0);
                    break;
            }
        }
    }
}
