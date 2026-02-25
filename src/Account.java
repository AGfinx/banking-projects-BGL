/**
 * The Account class represents a simple bank account.
 * It provides basic banking operations such as deposit,
 * withdrawal, and balance inquiry.
 *
 * This class implements the BANK interface.
 */
public class Account implements BANK {

    /** The current balance of the account */
    private double balance;

    /**
     * Default constructor.
     * Initializes the account balance to 0.
     */
    Account() {
        this.balance = 0;
    }

    /**
     * Parameterized constructor.
     * Initializes the account with a given balance.
     *
     * @param balance the initial balance of the account
     */
    Account(double balance) {
        this.balance = balance;
    }

    /**
     * Withdraws a specified amount from the account.
     *
     * @param withdraw_amt the amount to be withdrawn
     * @throws InsufficientFundsException if the withdrawal amount
     *         exceeds the available balance
     */
    @Override
    public void withdrawal(double withdraw_amt) throws InsufficientFundsException, NegativeFundException {

        if (withdraw_amt > this.balance) {
            throw new InsufficientFundsException();
        }
        else if (withdraw_amt < 0){
            throw  new NegativeFundException();
        }

        this.balance -= withdraw_amt;
        System.out.println("Withdrawn: " + withdraw_amt);
        showBalance();
    }

    /**
     * Deposits a specified amount into the account.
     *
     * @param deposit_amt the amount to be deposited
     * @throws NegativeFundException if the deposit amount is negative
     */
    @Override
    public void deposit(double deposit_amt) throws NegativeFundException {

        if (deposit_amt < 0) {
            throw new NegativeFundException();
        }

        this.balance += deposit_amt;
        System.out.println("Deposited: " + deposit_amt);
        showBalance();
    }

    /**
     * Displays the current account balance.
     */
    @Override
    public void showBalance() {
        System.out.println("Available Balance: " + this.balance);
    }

    public double getBalance() {
        return balance;
    }
}
