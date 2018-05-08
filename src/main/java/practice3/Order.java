package practice3;

import java.math.BigDecimal;
import java.util.List;


public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;
    PriceCaculator priceCaculator ;
    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
        this.priceCaculator = new PriceCaculator(orderLineItemList,tax,discounts);
    }

    public BigDecimal calculate() {
        return priceCaculator.compute();

    }
}
