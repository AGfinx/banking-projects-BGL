import java.util.Scanner;

/**
 * Main class for the Banking Application.
 *
 * This version includes input validation to prevent
 * crashes caused by non-numeric user input.
 */
public class Main {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Account clint = new Account(1000);

        boolean isExit = true;

        System.out.println("--------------------BANKING---------------------");

        while (isExit) {

            System.out.println("--------------------------------------------------");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Exit");
            System.out.print("Enter Option: ");

            // Validate menu input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1-4.");
                scanner.next(); // clear invalid input
                continue;
            }

            int option = scanner.nextInt();

            switch (option) {

                case 1 -> clint.showBalance();

                case 2 -> {
                    System.out.print("Enter the amount to Deposit: ");

                    // Validate deposit input
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount! Please enter a numeric value.");
                        scanner.next(); // clear invalid input
                        break;
                    }

                    double dep_amt = scanner.nextDouble();

                    try {
                        clint.deposit(dep_amt);
                    } catch (NegativeFundException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 3 -> {
                    System.out.print("Enter the amount to Withdraw: ");

                    // Validate withdrawal input
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount! Please enter a numeric value.");
                        scanner.next(); // clear invalid input
                        break;
                    }

                    double withdraw_amt = scanner.nextDouble();

                    try {
                        clint.withdrawal(withdraw_amt);
                    } catch (InsufficientFundsException | NegativeFundException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 4 -> {
                    System.out.println("------------Exiting-----------");
                    isExit = false;
                }

                default -> System.out.println("Invalid option! Please select 1-4.");
            }
        }

        scanner.close();
    }
}
