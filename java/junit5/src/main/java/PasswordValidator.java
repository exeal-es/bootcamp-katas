public class PasswordValidator {

  public static ValidationResult isValid(String password) {
    int numbers = 0;

    for (int i = 0; i < password.length(); i++) {
      if (Character.isDigit(password.charAt(i))) {
        numbers++;
      }
    }

    if (numbers == 0) return new ValidationResult(false, "The password must contain at least 2 numbers");


    if (password.length() < 8)
      return new ValidationResult(false, "Password must be at least 8 characters");
    return new ValidationResult(true);
  }
}
