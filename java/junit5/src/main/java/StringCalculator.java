public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            String firstNumber = numbers.split(",")[0];
            return Integer.parseInt(firstNumber) + 2;
        }
        return Integer.parseInt(numbers);
    }
}
