import java.util.List;

public interface AccountRepository {

  List<Transaction> getTransactions();
}
