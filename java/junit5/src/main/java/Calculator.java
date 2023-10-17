public class Calculator {
  private final Integer numItems;

  public Calculator(final Integer numItems) {
    this.numItems = numItems;
  }

  public Double getTotal() {
    return numItems * 1.0;
  }
}
