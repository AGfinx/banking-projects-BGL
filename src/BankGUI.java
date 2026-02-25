import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

/**
 * Modern styled Banking GUI using Swing.
 */
public class BankGUI extends JFrame {

    private final Account account;
    private final JLabel balanceLabel;
    private final JTextField amountField;

    // Modern color palette
    private final Color backgroundColor = new Color(245, 247, 250);
    private final Color primaryColor = new Color(52, 152, 219);
    private final Color successColor = new Color(46, 204, 113);
    private final Color dangerColor = new Color(231, 76, 60);
    private final Color cardColor = Color.WHITE;

    private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public BankGUI() {

        account = new Account(1000);

        setTitle("Modern Banking App");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(backgroundColor);
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(mainPanel);

        // ===== Balance Card =====
        JPanel balanceCard = new JPanel();
        balanceCard.setBackground(cardColor);
        balanceCard.setLayout(new BorderLayout());
        balanceCard.setBorder(new EmptyBorder(20, 20, 20, 20));

        balanceLabel = new JLabel(
                currencyFormat.format(account.getBalance()),
                SwingConstants.CENTER
        );
        balanceLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        balanceLabel.setForeground(primaryColor);

        JLabel titleLabel = new JLabel("Available Balance", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleLabel.setForeground(Color.GRAY);

        balanceCard.add(titleLabel, BorderLayout.NORTH);
        balanceCard.add(balanceLabel, BorderLayout.CENTER);

        mainPanel.add(balanceCard, BorderLayout.NORTH);

        // ===== Center Panel =====
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(backgroundColor);
        centerPanel.setLayout(new GridLayout(2, 1, 10, 10));

        amountField = new JTextField();
        amountField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        amountField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(primaryColor, 1),
                new EmptyBorder(8, 8, 8, 8)
        ));

        JLabel inputLabel = new JLabel("Enter Amount:");
        inputLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        centerPanel.add(inputLabel);
        centerPanel.add(amountField);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // ===== Buttons =====
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        buttonPanel.setBackground(backgroundColor);

        JButton depositBtn = createStyledButton("Deposit", successColor);
        JButton withdrawBtn = createStyledButton("Withdraw", dangerColor);
        JButton exitBtn = createStyledButton("Exit", primaryColor);

        buttonPanel.add(depositBtn);
        buttonPanel.add(withdrawBtn);
        buttonPanel.add(exitBtn);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        depositBtn.addActionListener((ActionEvent e) -> depositAction());
        withdrawBtn.addActionListener((ActionEvent e) -> withdrawAction());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    /**
     * Creates a styled modern button.
     */
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setBorder(new EmptyBorder(10, 15, 10, 15));
        return button;
    }

    /**
     * Deposit action handler.
     */
    private void depositAction() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            updateBalance();
            amountField.setText("");

        } catch (NumberFormatException ex) {
            showError("Please enter a valid number!");
        } catch (NegativeFundException ex) {
            showError(ex.getMessage());
        }
    }

    /**
     * Withdraw action handler.
     */
    private void withdrawAction() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.withdrawal(amount);
            updateBalance();
            amountField.setText("");

        } catch (NumberFormatException ex) {
            showError("Please enter a valid number!");
        } catch (InsufficientFundsException | NegativeFundException ex) {
            showError(ex.getMessage());
        }
    }

    /**
     * Updates balance display.
     */
    private void updateBalance() {
        balanceLabel.setText(currencyFormat.format(account.getBalance()));
    }

    /**
     * Shows styled error popup.
     */
    private void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Launch application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankGUI::new);
    }
}

