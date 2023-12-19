import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public final class AccountServiceShould {

  private AccountRepository accountRepository;
  private StatementPrinter statementPrinter;
  private Clock clock;
  private Console console;
  private AccountService accountService;


  @BeforeEach
  void setUp() {
    accountRepository = Mockito.mock(AccountRepository.class);
    statementPrinter = Mockito.mock(StatementPrinter.class);
    clock = Mockito.mock(Clock.class);
    console = Mockito.mock(Console.class);
    accountService = new AccountService(accountRepository, statementPrinter, clock, console);
  }

  @Test
  public void printStatement() {
    final List<Transaction> transactions = List.of(new Transaction());
    Mockito.when(accountRepository.getTransactions()).thenReturn(transactions);

    accountService.printStatement();

    Mockito.verify(statementPrinter).print(transactions);
  }
}
