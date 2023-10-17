public class Calculator {
  private final Integer numItems;
  private final Double itemPrice;
  private final Double taxImport;

  public Calculator(final Integer numItems, final Double itemPrice, final Double taxImport) {
    this.numItems = numItems;
    this.itemPrice = itemPrice;
    this.taxImport = taxImport;
  }

  public Calculator(final Integer numItems, final Double itemPrice) {
    this.numItems = numItems;
    this.itemPrice = itemPrice;
    this.taxImport = 0.0685;
  }

  public Double getTotal() {
    return (numItems * itemPrice) * (1 + taxImport);
  }
}
