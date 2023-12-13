import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
  @CsvSource({"7", "8", "11"})
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
  @CsvSource({"12", "13", "15", "19"})
  public void shouldGreetWithGoodAfternoonsWhenIsAfternoon(int hour) {
    // given
    Mockito.when(clock.getHour()).thenReturn(hour);
    ohce = new Ohce("Javier", console, clock);
    // when
    ohce.run();
    // then
    Mockito.verify(console).printLine("¡Buenas tardes Javier!");
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
