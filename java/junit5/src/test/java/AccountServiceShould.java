import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

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

    @Test
    public void print_two_deposits() {
        when(calendar.today()).thenReturn(
                LocalDate.of(2012, 1, 10),
                LocalDate.of(2012, 1, 11)
        );

        accountService.deposit(1000);
        accountService.deposit(500);
        accountService.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).println("11/01/2012 || 500.00 ||  || 1500.00");
        inOrder.verify(console).println("10/01/2012 || 1000.00 ||  || 1000.00");
    }

    @Test
    public void print_a_deposit_and_a_withdrawal() {
        when(calendar.today()).thenReturn(
                LocalDate.of(2012, 1, 10),
                LocalDate.of(2012, 1, 11)
        );

        accountService.deposit(1000);
        accountService.withdraw(400);
        accountService.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).println("11/01/2012 ||  || 400.00 || 600.00");
        inOrder.verify(console).println("10/01/2012 || 1000.00 ||  || 1000.00");
    }
}
