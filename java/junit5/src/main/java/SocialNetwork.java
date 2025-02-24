public class SocialNetwork {
    Console console;

    public SocialNetwork(Console console) {
        this.console = console;
    }

    public void start() {
        var postingCommand = this.console.readLine();
        this.console.readLine();
        this.console.printLine(postingCommand.split(" -> ")[1]);
    }
}
