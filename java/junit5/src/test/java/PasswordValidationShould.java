import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationShould {

	@Test
	public void shouldReturnTrue() {
		boolean result = PasswordValidator.isValid("exealaaaaa");
		Assertions.assertThat(result)
			.isTrue();
	}

	@Test

	public void shouldReturnFalseWhenLengthIsBelow8() {
		boolean result = PasswordValidator.isValid("exeal");
		Assertions.assertThat(result).isFalse();
	}
}
