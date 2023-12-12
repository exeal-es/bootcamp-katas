
public class Ohce {

    private final String userName;
    private Console console;
    private final Clock clock;

    public Ohce(String userName, Console console, Clock clock) {
        this.userName = userName;
        this.console = console;
        this.clock = clock;
    }

    public void run() {
        greetUser();
        final String word = console.readLine();
        if (word != null) {
            console.printLine(reverse(word));
        }
    }

    private void greetUser() {
        if (clock.getHour() == 21) {
            console.printLine(String.format("¡Buenas noches %s!", userName));
        } else {
            console.printLine(String.format("¡Buenos días %s!", userName));
        }
    }

    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
