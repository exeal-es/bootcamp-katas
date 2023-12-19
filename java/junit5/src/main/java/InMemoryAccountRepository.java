import java.util.Collections;
import java.util.List;

public final class InMemoryAccountRepository implements AccountRepository {

  @Override
  public List<Transaction> getTransactions() {
    return Collections.emptyList();
  }
}
