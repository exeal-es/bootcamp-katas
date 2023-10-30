import io.vavr.control.Validation;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationShould {

  @Test
  public void shouldReturnTrue() {
    ValidationResult result = PasswordValidator.isValid("exe1alaaaaa");
    Assertions.assertThat(result.isValid()).isTrue();
    Assertions.assertThat(result.errors()).isEmpty();
  }

  @Test
  public void shouldReturnFalseWhenLengthIsBelow8() {
    ValidationResult result = PasswordValidator.isValid("exeal1");
    Assertions.assertThat(result.isValid()).isFalse();
    Assertions.assertThat(result.errors()).contains("Password must be at least 8 characters");
  }

  @Test
  public void shouldNotContainNumbers() {

    ValidationResult result = PasswordValidator.isValid("notnumbersa");

    Assertions.assertThat(result.isValid()).isFalse();
    Assertions.assertThat(result.errors()).contains("The password must contain at least 2 numbers");
  }

}
