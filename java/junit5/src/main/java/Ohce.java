
public class Ohce {

    private final String userName;
    private Console console;

    public Ohce(String userName, Console console) {
        this.userName = userName;
        this.console = console;
    }

    public void run() {
        console.printLine(String.format("¡Buenos días %s!", userName));
        final String word = console.readLine();
        if (word != null) {
            console.printLine(reverse(word));
        }
    }

    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
