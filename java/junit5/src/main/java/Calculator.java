import java.util.HashMap;
import java.util.Map;

public class Calculator {
  private static final Map<String, Double> stateTaxes = new HashMap<>();
  static {
    stateTaxes.put("UT", 0.0685);
    stateTaxes.put("NV", 0.08);
    stateTaxes.put("TX", 0.0625);
    stateTaxes.put("AL", 0.04);
    stateTaxes.put("CA", 0.0825);
  }

  private final Integer numItems;
  private final Double itemPrice;
  private final Double taxImport;

  public Calculator(final Integer numItems, final Double itemPrice, final Double taxImport) {
    this.numItems = numItems;
    this.itemPrice = itemPrice;
    this.taxImport = taxImport;
  }

  public Calculator(final Integer numItems, final Double itemPrice, final String stateCode) {
    this.numItems = numItems;
    this.itemPrice = itemPrice;
    this.taxImport = stateTaxes.get(stateCode);
  }

  public Double getTotal() {
    return (numItems * itemPrice) * (1 + taxImport);
  }
}
