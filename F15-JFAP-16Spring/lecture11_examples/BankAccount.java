/**
 * Bank Account class to demo synchronization.
 * @author Terry Lee
 */
public class BankAccount {
    /**
     * current balance.
     */
    private double balance;

    /**
     * Returns current balance.
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits amount into balance.
     * @param amount amount to deposit
     */
    public synchronized void depositAmount(double amount) {
        balance += amount;
    }

    /**
     * Withdraws amount from balance.
     * @param amount amount to withdraw
     */
    public synchronized void withdrawAmount(double amount) {
        balance -= amount;
    }
}