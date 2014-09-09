package bank;

public class ATM {

    private double balance;

    private final String bank;

    // Constructor with a string for the name and a double for the initial balance
    public ATM(String bank, double balance) {
        this.bank = bank;
        this.setBalance(balance);
    }

    /**
     * @return the banks name
     */
    public String getBank() {
        return bank;
    }

    /**
     * @return The persons balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set the persons new balance @see {@link ATM#withdraw(double)} @see {@link ATM#deposit(double)} @see {@link ATM#unsafeDeposit(double)}
     * 
     * @param balance
     *            The amount to set the new balance to.
     */
    private void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * 
     * @param amount
     *            The amount to withdraw
     * @throws Exception
     *             - The amount to withdraw was greater than the users balance
     */
    public void withdraw(double amount) throws Exception {
        if (getBalance() - amount < 0) {
            throw new Exception("Maximum withdrawal reached!");
        }
        this.setBalance(this.getBalance() - amount);
    }

    /**
     * Deposit money, up to $200
     * 
     * @param amount
     *            The amount to deposit
     * @throws Exception
     *             The amount to deposit was > 200
     */
    public void deposit(double amount) throws Exception {
        if (amount > 200) {
            throw new Exception("Balance too high!");
        }
        this.setBalance(this.getBalance() + amount);
    }

    /**
     * Deposit as much as the user wants > 200
     * 
     * @param amount
     *            The amount to deposit.
     */
    public void unsafeDeposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }

    /**
     * print out the users balance
     */
    public void displayBalance() {
        System.out.println("Your balance is: " + balance);
    }

}
