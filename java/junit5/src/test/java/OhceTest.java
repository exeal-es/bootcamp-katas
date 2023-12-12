import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;


public class OhceTest {

    Ohce ohce;

    @Test
    void shouldPrintJamonReversed() {
        // given
        Console console = Mockito.mock(Console.class);
        when(console.readLine()).thenReturn("jamon");
        ohce = new Ohce(console);
        // when
        ohce.run();
        // then
        Mockito.verify(console).printLine("nomaj");
    }

    @Test
    void shouldPrintHolaReversed() {
        // given
        Console console = Mockito.mock(Console.class);
        when(console.readLine()).thenReturn("hola");
        ohce = new Ohce(console);
        // when
        ohce.run();
        // then
        Mockito.verify(console).printLine("aloh");
    }
}
