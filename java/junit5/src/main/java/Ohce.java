public class Ohce {

  private final String userName;
  private final Clock clock;
  private final Console console;

  public Ohce(String userName, Console console, Clock clock) {
    this.userName = userName;
    this.console = console;
    this.clock = clock;
  }

  private static boolean userWantsToStop(String word) {
    return word.equals("Stop!");
  }

  private void sayGoodbye() {
    console.printLine(String.format("Adios %s", userName));
  }

  private static String reverse(String word) {
    return new StringBuilder(word).reverse().toString();
  }

  private static boolean isPalindromic(String word) {
    return word.equals(reverse(word));
  }

  private void printReversed(String word) {
    console.printLine(reverse(word));
  }

  private void congratsIfPalindromic(String word) {
    if (isPalindromic(word)) {
      console.printLine("¡Bonita palabra!");
    }
  }

  public void run() {
    greetUser();
    final String word = console.readLine();
    if (word == null) {
      return;
    }
    if (userWantsToStop(word)) {
      sayGoodbye();
      return;
    }
    printReversed(word);
    congratsIfPalindromic(word);
  }

  private void greetUser() {
    int hour = clock.getHour();
    if (hour >= 20 || hour <= 6) {
      console.printLine(String.format("¡Buenas noches %s!", userName));
    } else if (hour >= 12) {
      console.printLine(String.format("¡Buenas tardes %s!", userName));
    } else {
      console.printLine(String.format("¡Buenos días %s!", userName));
    }
  }
}
