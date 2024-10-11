
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Slice {
    private Menu menu;
    private KeyboardValid keyboard;
    private ArrayList<Transaction> transactions;

    public Slice() {
        menu = new Menu();
        keyboard = new KeyboardValid();
        transactions = new ArrayList<>();
    }

    public void run() {
        System.out.println("Welcome to my Slice menu!");
        boolean keepRunning = true;
        while (keepRunning) {
            menu.display();
            MenuItem item = menu.selectMenuItem();
            if (!item.getItemName().equalsIgnoreCase("Exit")) {
                String transactionType = keyboard.getStringInput("Enter transaction type (1-cash/ 2-card): ");
                if (transactionType.equalsIgnoreCase("1")) {
                    double amountTendered = keyboard.getDoubleInput("Enter amount tendered: ", 0.00, 1000.00);
                    CashTransaction cashTransaction = new CashTransaction(item, amountTendered);
                    transactions.add(cashTransaction);
                    System.out.println("Transaction successful! Change given: " + cashTransaction.getChangeGiven());
                } else if (transactionType.equalsIgnoreCase("2")) {
                    String cardType = keyboard.getStringInput("Enter card type (1-visa/2-master): ");
                    if (cardType.equalsIgnoreCase("1")) {
                        cardType = "Visa";
                        CardTransaction cardTransaction = new CardTransaction(item, cardType);
                        transactions.add(cardTransaction);
                        System.out.println("Transaction successful!");
                    } else if (cardType.equalsIgnoreCase("2")) {
                        cardType = "MasterCard";
                        CardTransaction cardTransaction = new CardTransaction(item, cardType);
                        transactions.add(cardTransaction);
                        System.out.println("Transaction successful!");
                    } else {
                        System.out.println("The card type entered is not supported.");
                    }
                } else {
                    System.out.println("Invalid transaction type. Transaction cancelled.");
                }
            } else {
                System.out.println("Thank you for visiting our Cafe.");
            }
        }
        writeTransactionsToFile();
    }

    private void writeTransactionsToFile() {
        try {
            FileWriter writer = new FileWriter("transactions.txt");
            for (Transaction transaction : transactions) {
                writer.write(transaction.getTransactionDetails() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing transactions to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Slice slice = new Slice();
        slice.run();
    }
}