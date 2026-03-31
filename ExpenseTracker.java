import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class Transaction implements Serializable {
    String type, category;
    double amount;

    Transaction(String type, String category, double amount) {
        this.type = type;
        this.category = category;
        this.amount = amount;
    }

    public String toString() {
        return type + " | " + category + " | ₹" + amount;
    }
}

public class ExpenseTrackerGUI extends JFrame {

    private JComboBox<String> typeBox, categoryBox;
    private JTextField amountField;
    private JTextArea displayArea;
    private JLabel balanceLabel;

    private ArrayList<Transaction> transactions = new ArrayList<>();
    private final String FILE_NAME = "expenses.dat";

    public ExpenseTrackerGUI() {
        setTitle("Personal Expense Tracker");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        topPanel.add(new JLabel("Type:"));
        typeBox = new JComboBox<>(new String[]{"Income", "Expense"});
        topPanel.add(typeBox);

        topPanel.add(new JLabel("Category:"));
        categoryBox = new JComboBox<>(new String[]{"Food", "Travel", "Shopping", "Bills", "Other"});
        topPanel.add(categoryBox);

        topPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        topPanel.add(amountField);

        JButton addButton = new JButton("Add Transaction");
        topPanel.add(addButton);

        JButton showButton = new JButton("Show All");
        topPanel.add(showButton);

        add(topPanel, BorderLayout.NORTH);

        // Center Display
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new BorderLayout());

        balanceLabel = new JLabel("Balance: ₹0");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bottomPanel.add(balanceLabel, BorderLayout.WEST);

        JButton clearButton = new JButton("Clear Display");
        bottomPanel.add(clearButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Load data
        loadFromFile();
        updateBalance();

        // Actions
        addButton.addActionListener(e -> addTransaction());
        showButton.addActionListener(e -> showTransactions());
        clearButton.addActionListener(e -> displayArea.setText(""));

         setVisible(true);
    }

    private void addTransaction() {
        try {
            String type = (String) typeBox.getSelectedItem();
            String category = (String) categoryBox.getSelectedItem();
            double amount = Double.parseDouble(amountField.getText());

            transactions.add(new Transaction(type, category, amount));
            saveToFile();
            updateBalance();

            JOptionPane.showMessageDialog(this, "Transaction Added!");

            amountField.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    private void showTransactions() {
        displayArea.setText("");
        for (Transaction t : transactions) {
            displayArea.append(t.toString() + "\n");
        }
    }

    private void updateBalance() {
        double balance = 0;
        for (Transaction t : transactions) {
            if (t.type.equals("Income")) balance += t.amount;
            else balance -= t.amount;
        }
        balanceLabel.setText("Balance: ₹" + balance);
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(transactions);
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            transactions = (ArrayList<Transaction>) ois.readObject();
        } catch (Exception e) {
            transactions = new ArrayList<>();
        }
    }


    public static void main(String[] args) {
        new ExpenseTrackerGUI();
    }
}
