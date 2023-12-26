import java.util.NoSuchElementException;
import java.util.Scanner;

public final class SystemConsole implements Console {

  private final Scanner scanner;

  public SystemConsole() {
    scanner = new Scanner(System.in);
  }

  @Override
  public void printLine(Word word) {
    System.out.println(word);
  }

  @Override
  public Word readLine() {
    try {
      return new Word(readLineFromSystemIn());
    } catch (NoSuchElementException ex) {
      System.err.println("Error reading from System.in");
      return null;
    }
  }

  private String readLineFromSystemIn() throws NoSuchElementException {
    String word;
    do {
      word = scanner.nextLine();
    } while (word == null || word.isEmpty());
    return word;
  }
}
