import java.util.List;

public interface TransactionRepository {
    List<Transaction> getTransactions();

    void addTransaction(Transaction e);
}
