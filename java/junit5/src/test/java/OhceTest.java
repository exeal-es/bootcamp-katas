import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OhceTest {

  Ohce ohce;

  @Mock private Console console;
  @Mock private Clock clock;

  @ParameterizedTest
  @CsvSource({"jamon", "hola"})
  void shouldPrintWordReversed(String word) {
    // given
    when(console.readLine()).thenReturn(word, "Stop!");
    ohce = new Ohce("Javier", console, clock);
    // when
    ohce.run();
    // then
    Mockito.verify(console).printLine(new Word(new StringBuilder(word).reverse().toString()));
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
    Mockito.verify(console).printLine(new Word("¡Buenos días Javier!"));
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
    Mockito.verify(console).printLine(new Word("¡Buenas tardes Javier!"));
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
    Mockito.verify(console).printLine(new Word("¡Buenas noches Javier!"));
  }

  @Test
  public void shouldCongratsWhenWordIsPalindromicAfterReverseIt() {
    // given
    when(console.readLine()).thenReturn("oto", "Stop!");
    ohce = new Ohce("Javier", console, clock);
    // when
    ohce.run();
    // then
    final InOrder console = Mockito.inOrder(this.console);
    console.verify(this.console).printLine(new Word("oto"));
    console.verify(this.console).printLine(new Word("¡Bonita palabra!"));
  }

  @Test
  public void shouldSayByeWhenUserWantsToStop() {
    // given
    when(console.readLine()).thenReturn("Stop!");
    ohce = new Ohce("Javier", console, clock);
    // when
    ohce.run();
    // then
    Mockito.verify(console).printLine(new Word("Adios Javier"));
  }

  @Test
  public void shouldAskUserUntilItWantsToStop() {
    // given
    when(console.readLine()).thenReturn("oto", "Stop!");
    ohce = new Ohce("Javier", console, clock);
    // when
    ohce.run();
    // then
    final InOrder console = Mockito.inOrder(this.console);
    console.verify(this.console).printLine(new Word("oto"));
    console.verify(this.console).printLine(new Word("¡Bonita palabra!"));
    console.verify(this.console).printLine(new Word("Adios Javier"));
  }

  @Test
  public void shouldNotReverseStopWord() {
    // given
    when(console.readLine()).thenReturn("Stop!");
    ohce = new Ohce("Javier", console, clock);
    // when
    ohce.run();
    // then
    Mockito.verify(console).printLine(new Word("Adios Javier"));
  }
}
