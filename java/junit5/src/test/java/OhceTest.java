import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;


public class OhceTest {

    Ohce ohce;

    @Test
    void shouldPrintJamonReversed() {
        // given
        Console console = Mockito.mock(Console.class);
        Clock clock = Mockito.mock(Clock.class);
        when(console.readLine()).thenReturn("jamon");
        ohce = new Ohce("Javier", console, clock);
        // when
        ohce.run();
        // then
        Mockito.verify(console).printLine("nomaj");
    }

    @Test
    void shouldPrintHolaReversed() {
        // given
        Console console = Mockito.mock(Console.class);
        Clock clock = Mockito.mock(Clock.class);
        when(console.readLine()).thenReturn("hola");
        ohce = new Ohce("Javier", console, clock);
        // when
        ohce.run();
        // then
        Mockito.verify(console).printLine("aloh");
    }

  @Test
  public void shouldGreetUser() {
      // given
      Console console = Mockito.mock(Console.class);
      Clock clock = Mockito.mock(Clock.class);
      ohce = new Ohce("Javier", console, clock);
      // when
      ohce.run();
      // then
      Mockito.verify(console).printLine("¡Buenos días Javier!");
  }

  @Test
  public void shouldGreetWithGoodNightsWhenHourIs21() {
      // given
      Console console = Mockito.mock(Console.class);
      Clock clock = Mockito.mock(Clock.class);
      Mockito.when(clock.getHour()).thenReturn(21);
      ohce = new Ohce("Javier", console, clock);
      // when
      ohce.run();
      // then
      Mockito.verify(console).printLine("¡Buenas noches Javier!");
  }
}
