import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduce el precio del objeto: ");
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        int price = scanner.nextInt();

        System.out.println("Introduce el numero de items del objeto: ");
        int items = scanner.nextInt();

        double total = calculator.getTotalUtah(items, price);

        System.out.println("El precio total es para Utah: " + total);

    }
}
