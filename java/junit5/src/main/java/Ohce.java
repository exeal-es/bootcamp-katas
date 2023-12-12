
public class Ohce {

    private Console console;

    public Ohce(Console console) {
        this.console = console;
    }

    public void run() {
        final String word = console.readLine();
        final String reversedWord = reverse(word);
        console.printLine(reversedWord);
    }

    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
