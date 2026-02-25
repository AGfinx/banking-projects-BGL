/**
 * Thrown to indicate that a withdrawal operation
 * has failed due to insufficient balance in the account.
 *
 * This exception is triggered when the withdrawal amount
 * exceeds the available account balance.
 */
class InsufficientFundsException extends Exception {

    /**
     * Constructs a new InsufficientFundsException
     * with a default error message.
     */
    public InsufficientFundsException() {
        super("Insufficient Funds...");
    }
}


/**
 * Thrown to indicate that a deposit operation
 * attempted to add a negative amount to the account.
 *
 * This exception is triggered when the deposit amount
 * is less than zero.
 */
class NegativeFundException extends Exception {

    /**
     * Constructs a new NegativeFundException
     * with a default error message.
     */
    public NegativeFundException() {
        super("You Can't accept Negative Funds...");
    }
}
