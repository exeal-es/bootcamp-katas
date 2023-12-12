
public class Ohce {

    private Console console;

    public Ohce(Console console) {
        this.console = console;
    }

    public void run() {
        final String word = console.readLine();
        final String reversedWord = new StringBuilder(word).reverse().toString();
        console.printLine(reversedWord);
    }
}
