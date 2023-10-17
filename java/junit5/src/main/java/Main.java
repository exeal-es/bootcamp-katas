import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduce el precio del objeto: ");
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        int price = scanner.nextInt();

        System.out.println("Introduce el numero de items del objeto: ");
        int items = scanner.nextInt();

        System.out.println("Introduce su estado: UT (1) o NV (2)");
        int state = scanner.nextInt();

        if (state == 1) {
            double total = calculator.getTotalUtah(items, price);
            System.out.println("El precio total es para Utah: " + total);
        } else {
            double total = calculator.getTotalNv(items, price);
            System.out.println("El precio total es para Nevada: " + total);
        }

    }
}
