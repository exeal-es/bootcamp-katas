import java.util.List;

public class SqlTransactionRepository implements TransactionRepository{
    @Override
    public List<Transaction> getTransactions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addTransaction(Transaction e) {
        throw new UnsupportedOperationException();
    }
}
