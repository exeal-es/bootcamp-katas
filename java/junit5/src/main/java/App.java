public final class App {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: ohce <name>");
      System.exit(1);
    }
    final String name = args[0];
    final Ohce ohce = new Ohce(name, new SystemConsole(), new LocalClock());
    ohce.run();
  }
}
