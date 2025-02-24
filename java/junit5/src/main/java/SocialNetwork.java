public class SocialNetwork {
    private final String COMMAND_SEPARATOR = " -> ";

    Console console;

    public SocialNetwork(Console console) {
        this.console = console;
    }

    public void start() {
        var postingCommand = this.console.readLine();
        this.console.readLine();
        String message = postingCommand.split(COMMAND_SEPARATOR)[1];
        this.console.printLine(message);
    }
}
