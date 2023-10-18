public class StringCalculator {

    public static int add(String numbers) {
        switch (numbers) {
            case "":
                return 0;
            default:
                return Integer.parseInt(numbers);
        }
    }
}
