import java.time.LocalDate;

public class StatementLine {
    private Transaction transaction;
    private int balance;

    public StatementLine(Transaction transaction, int balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return transaction.getDate();
    }

    public int getCredit() {
        return transaction.getCredit();
    }

    public int getDebit() {
        return transaction.getDebit();
    }

    public int getBalance() {
        return balance;
    }
}
