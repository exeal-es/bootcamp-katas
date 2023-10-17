import java.util.Scanner;

public final class Main {
  public static void main(String[] args) {
    System.out.println("Introduce el número de items:");
    Scanner scanner = new Scanner(System.in);
    Integer numItems = scanner.nextInt();

    System.out.println("Introduce el precio de items:");
    Double itemPrice = scanner.nextDouble();

    System.out.println("Introduce el código de estado:");
    String stateCode = scanner.next();

    final Calculator calculator = new Calculator(numItems, itemPrice, stateCode);
    System.out.println(
        "El total de la compra aplicando los impuestos de"
            + stateCode
            + " es: "
            + calculator.getTotal());
  }
}
