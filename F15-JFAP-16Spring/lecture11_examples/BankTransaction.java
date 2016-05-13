/**
 * Example code to demo recipe 2.
 * @author Terry Lee
 *
 */
public class BankTransaction extends Thread {
    /**
     * Enum class of predifined transaction types.
     * @author Terry Lee
     */
    public static enum TransactionType {
        DEPOSIT, WITHDRAW;
    };

    /**
     * Current transaction type.
     */
    private TransactionType transactionType;
    /**
     * reference to bank account.
     */
    private BankAccount account;
    /**
     * amount to use.
     */
    private double amount;

    /**
     * Constructor
     * @param newAccount bank account
     * @param type tranaction type
     * @param newAmount amount to use
     */
    public BankTransaction(BankAccount newAccount, TransactionType type,
            double newAmount) {
        account = newAccount;
        transactionType = type;
        amount = newAmount;
    }

    /**
     * Implement run of Thread class.
     */
    @Override
    public void run() {
        switch (transactionType) {
        case DEPOSIT:
            account.depositAmount(amount);
            break;
        case WITHDRAW:
            account.withdrawAmount(amount);
            break;
        default:
            System.out.println("NOT A VALID TRANSACTION");
        }
    }
}