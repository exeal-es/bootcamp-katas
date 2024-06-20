import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceShould {

    @Mock
    Calendar calendar;
    @Mock
    Console console;
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        accountService = new AccountService(calendar, console);

    }

    @Test
    public void print_only_header_for_empty_account() {
        accountService.printStatement();

        verify(console).println("date || credit || debit || balance");
    }

    @Test
    public void print_a_single_deposit() {
        when(calendar.today()).thenReturn(LocalDate.of(2012, 1, 10));

        accountService.deposit(1000);
        accountService.printStatement();

        verify(console).println("10/01/2012 || 1000.00 ||  || 1000.00");
    }

    @Test
    public void print_a_single_withdraw() {
        when(calendar.today()).thenReturn(LocalDate.of(2012, 1, 10));

        accountService.withdraw(2000);
        accountService.printStatement();

        verify(console).println("10/01/2012 ||  || 2000.00 || -2000.00");
    }
}
