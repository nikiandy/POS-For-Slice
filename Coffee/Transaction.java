import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Transaction {
    private LocalDateTime timestamp;
    private MenuItem item;

    public Transaction(MenuItem item) {
        this.timestamp = LocalDateTime.now();
        this.item = item;
    }

    public String getTransactionDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return timestamp.format(formatter) + ", " + item.getItemName() + ", " + "€" + item.getItemPrice();
    }
}