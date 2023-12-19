import java.util.List;

public interface AccountRepository {

  List<Transaction> getTransactions();

  void save(Transaction transaction);
}
