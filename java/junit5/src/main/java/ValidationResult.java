import java.util.Collections;
import java.util.List;

public final class ValidationResult {

  private final boolean isValid;
  private final String error;

  public ValidationResult(boolean isValid) {
    this.isValid = isValid;
    error = null;
  }

  public ValidationResult(boolean isValid, String error) {
    this.isValid = isValid;
    this.error = error;
  }

  public boolean isValid() {
    return isValid;
  }

  public List<String> errors() {
    return error == null ? Collections.emptyList() : Collections.singletonList(error);
  }
}
