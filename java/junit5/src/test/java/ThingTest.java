import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ThingTest {

  @Test
  void fail() {
    Thing thing = new Thing();
    String value = thing.callForAction();
    assertThat(value).isEqualTo("Food");
  }

  @Test
  void it_should_not_fail() {
    assertThat(42).isEqualTo(42);
  }
}
