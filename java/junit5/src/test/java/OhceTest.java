import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

  @ParameterizedTest
  @CsvSource({"7", "8", "12"})
  public void shouldGreetUserWithGoodMorningWhenIsMorning(int hour) {
    // given
      Mockito.when(clock.getHour()).thenReturn(hour);
      ohce = new Ohce("Javier", console, clock);
      // when
      ohce.run();
      // then
      Mockito.verify(console).printLine("¡Buenos días Javier!");
  }

  @ParameterizedTest
  @CsvSource({"20", "21", "5", "6"})
  public void shouldGreetWithGoodNightsWhenIsNight(int hour) {
      // given
      Mockito.when(clock.getHour()).thenReturn(hour);
      ohce = new Ohce("Javier", console, clock);
      // when
      ohce.run();
      // then
      Mockito.verify(console).printLine("¡Buenas noches Javier!");
  }
}
