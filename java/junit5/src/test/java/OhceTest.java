import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OhceTest {

    Ohce ohce;

    @Mock private Console console;
    @Mock private Clock clock;

    @Test
    void shouldPrintJamonReversed() {
        // given
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
      ohce = new Ohce("Javier", console, clock);
      // when
      ohce.run();
      // then
      Mockito.verify(console).printLine("¡Buenos días Javier!");
  }

  @Test
  public void shouldGreetWithGoodNightsWhenHourIs21() {
      // given
      Mockito.when(clock.getHour()).thenReturn(21);
      ohce = new Ohce("Javier", console, clock);
      // when
      ohce.run();
      // then
      Mockito.verify(console).printLine("¡Buenas noches Javier!");
  }
}
