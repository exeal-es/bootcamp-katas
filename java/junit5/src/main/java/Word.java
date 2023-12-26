import java.util.Objects;

public final class Word {
  private final String value;

  public Word(String value) {
    this.value = value;
  }

  public Word reverse() {
    return new Word(new StringBuilder(value()).reverse().toString());
  }

  public boolean isPalindromic() {
    return equals(reverse());
  }

  public boolean userWantsToStop() {
    return equals(new Word("Stop!"));
  }

  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Word word = (Word) o;
    return Objects.equals(value, word.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value;
  }
}
