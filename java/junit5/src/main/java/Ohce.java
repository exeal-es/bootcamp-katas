public class Ohce {

  private final String userName;
  private final Clock clock;
  private final Console console;

  public Ohce(String userName, Console console, Clock clock) {
    this.userName = userName;
    this.console = console;
    this.clock = clock;
  }

  private void greetUser() {
    int hour = clock.getHour();
    if (hour >= 20 || hour <= 6) {
      console.printLine(new Word(String.format("¡Buenas noches %s!", userName)));
    } else if (hour >= 12) {
      console.printLine(new Word(String.format("¡Buenas tardes %s!", userName)));
    } else {
      console.printLine(new Word(String.format("¡Buenos días %s!", userName)));
    }
  }

  private static boolean userWantsToStop(Word word) {
    return word.equals(new Word("Stop!"));
  }

  private void sayGoodbye() {
    console.printLine(new Word(String.format("Adios %s", userName)));
  }

  private static Word reverse(Word word) {
    return new Word(new StringBuilder(word.value()).reverse().toString());
  }

  private static boolean isPalindromic(Word word) {
    return word.equals(reverse(word));
  }

  private void printReversed(Word word) {
    console.printLine(reverse(word));
  }

  private void congratsIfPalindromic(Word word) {
    if (isPalindromic(word)) {
      console.printLine(new Word("¡Bonita palabra!"));
    }
  }

  public void run() {
    greetUser();
    Word word;
    boolean userWantsToStop = false;
    do {
      word = console.readLine();
      if (word == null) {
        break;
      }
      userWantsToStop = userWantsToStop(word);
      if (userWantsToStop) {
        break;
      }
      printReversed(word);
      congratsIfPalindromic(word);
    } while (true);
    sayGoodbye();
  }
}
