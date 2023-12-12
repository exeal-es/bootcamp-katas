
public class Ohce {

    private Console console;

    public Ohce(Console console) {
        this.console = console;
    }

    public void run() {
        console.printLine(reverse(console.readLine()));
    }

    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
