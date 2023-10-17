import java.util.Scanner;

public final class Main {
  public static void main(String[] args) {
    System.out.println("Introduce el número de items:");
    Scanner scanner = new Scanner(System.in);
    Integer numItems = scanner.nextInt();

    final Calculator calculator = new Calculator(numItems);
    System.out.println("El total de la compra es: " + calculator.getTotal());
  }
}
