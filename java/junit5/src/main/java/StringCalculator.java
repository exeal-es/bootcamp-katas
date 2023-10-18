public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            String firstNumber = numbers.split(",")[0];
            String secondNumber = numbers.split(",")[1];
            return Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
        }
        return Integer.parseInt(numbers);
    }
}
