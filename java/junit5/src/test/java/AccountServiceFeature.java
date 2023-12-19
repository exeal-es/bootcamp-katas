import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public final class AccountServiceFeature {

  private Clock clock;
  private Console console;
  private AccountService accountService;

  @BeforeEach
  void setUp() {
    clock = Mockito.mock(Clock.class);
    console = Mockito.mock(Console.class);
    accountService =
        new AccountService(
            new InMemoryAccountRepository(), new ConsoleStatementPrinter(console), clock, console);
  }

  @Test
  public void shouldPrintStatements() {
    Mockito.when(clock.getCurrentDate()).thenReturn(LocalDate.of(2012, 1, 10));
    accountService.deposit(1000);
    Mockito.when(clock.getCurrentDate()).thenReturn(LocalDate.of(2012, 1, 13));
    accountService.deposit(2000);
    Mockito.when(clock.getCurrentDate()).thenReturn(LocalDate.of(2012, 1, 14));
    accountService.withdraw(500);

    accountService.printStatement();

    Mockito.verify(console).println("Date || Amount || Balance");
    Mockito.verify(console).println("14/01/2012 || -500 || 2500");
    Mockito.verify(console).println("13/01/2012 || 2000 || 3000");
    Mockito.verify(console).println("10/01/2012 || 1000 || 1000");
  }
}
