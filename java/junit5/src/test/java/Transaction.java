import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final int credit;
    private final int debit;
    private final int balance;

    public Transaction(LocalDate date, int credit, int debit, int balance) {

        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCredit() {
        return credit;
    }

    public int getDebit() {
        return debit;
    }

    public int getBalance() {
        return balance;
    }
}
