public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            return Integer.parseInt(numbers.split(",")[0]) + Integer.parseInt(numbers.split(",")[1]);
        }
        return Integer.parseInt(numbers);
    }
}
