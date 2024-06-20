import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AccountServiceShould {

    @Test
    public void print_only_header_for_empty_account() {
        Calendar calendar = Mockito.mock(Calendar.class);
        Console console = Mockito.mock(Console.class);

        AccountService accountService = new AccountService(calendar, console);
        accountService.printStatement();

        verify(console).println("date || credit || debit || balance");
    }

    @Test
    public void print_a_single_deposit() {
        Calendar calendar = Mockito.mock(Calendar.class);
        Console console = Mockito.mock(Console.class);
        when(calendar.today()).thenReturn(LocalDate.of(2012, 1, 10));

        AccountService accountService = new AccountService(calendar, console);
        accountService.deposit(1000);
        accountService.printStatement();

        verify(console).println("10/01/2012 || 1000.00 ||  || 1000.00");
    }
}
