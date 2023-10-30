public class PasswordValidator {

	public static ValidationResult isValid(String password) {
		if (password.length() < 8) return new ValidationResult(false, "Password must be at least 8 characters");
		return new ValidationResult(true);

	}
}
