/**
 * The BANK interface defines the basic operations
 * that any bank account must implement.
 *
 * It provides methods for:
 * - Checking account balance
 * - Withdrawing money
 * - Depositing money
 */
public interface BANK {

    /**
     * Displays the current balance of the account.
     */
    void showBalance();

    /**
     * Withdraws a specified amount from the account.
     *
     * @param withdraw_amt the amount to withdraw
     * @throws InsufficientFundsException if the withdrawal amount
     *         exceeds the available balance
     */
    void withdrawal(double withdraw_amt) throws InsufficientFundsException, NegativeFundException;

    /**
     * Deposits a specified amount into the account.
     *
     * @param deposit_amt the amount to deposit
     * @throws NegativeFundException if the deposit amount is negative
     */
    void deposit(double deposit_amt) throws NegativeFundException;
}

