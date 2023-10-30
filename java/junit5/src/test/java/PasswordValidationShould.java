import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationShould {

	@Test
	public void shouldReturnTrue() {
		ValidationResult result = PasswordValidator.isValid("exealaaaaa");
		Assertions.assertThat(result.isValid())
			.isTrue();
		Assertions.assertThat(result.errors()).isEmpty();
	}

	@Test

	public void shouldReturnFalseWhenLengthIsBelow8() {
		ValidationResult result = PasswordValidator.isValid("exeal");
		Assertions.assertThat(result.isValid()).isFalse();
		Assertions.assertThat(result.errors()).contains("Password must be at least 8 characters");
	}
}
