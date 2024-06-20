import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final int amount;

    public Transaction(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public int getCredit() {
        return isDeposit() ? amount : 0;
    }

    private boolean isDeposit() {
        return amount >= 0;
    }

    public int getDebit() {
        return isWithdrawal() ? -amount : 0;
    }

    private boolean isWithdrawal() {
        return !isDeposit();
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}
