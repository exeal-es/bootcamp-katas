import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    List<Transaction> transactions = new ArrayList<Transaction>();

    public TransactionRepository() {
    }

    List<Transaction> getTransactions() {
        return transactions;
    }

    void addTransaction(Transaction e) {
        transactions.add(e);
    }
}