package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {
    private BigDecimal subTotal = new BigDecimal(0);
    private BigDecimal grandTotal;
    private final List<OrderLineItem> orderLineItemList;
    private final List<BigDecimal> discounts;
    private final BigDecimal tax;


    public PriceCaculator(List<OrderLineItem> orderLineItemList, BigDecimal tax,
                     List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.tax = tax;
        this.discounts = discounts;
    }

    public BigDecimal compute() {
        computeSubTotal();
        return subTotal.add(subTotal.multiply(this.tax));
    }

    private void computeSubTotal() {
        // Total up line items
        for (OrderLineItem lineItem : this.orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }

        // Subtract discounts
        for (BigDecimal discount : this.discounts) {
            subTotal = subTotal.subtract(discount);
        }
    }

}
