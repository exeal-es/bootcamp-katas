public class Calculator {
  private final Integer numItems;
  private final Double itemPrice;

  public Calculator(final Integer numItems, final Double itemPrice) {
    this.numItems = numItems;
    this.itemPrice = itemPrice;
  }

  public Double getTotal() {
    return numItems * itemPrice;
  }
}
