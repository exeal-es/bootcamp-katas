import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactionRepository implements TransactionRepository {
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void addTransaction(Transaction e) {
        transactions.add(e);
    }
}