public class Calculator {
    public int getTotal(int price) {
        return price;
    }

    public int getTotal(int items, int price) {
        return items * price;
    }

    public double getTotalUtah(int items, int price) {
        return items * price * 1.0685;
    }
}
