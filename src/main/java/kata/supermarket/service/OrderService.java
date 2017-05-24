package kata.supermarket.service;

import kata.supermarket.model.Order;
import kata.supermarket.model.OrderItem;

import java.math.BigDecimal;

public class OrderService {

    public double calculateTotal(Order order) {

        if (order == null) {
            return 0;
        }

        return order.getItems().stream()
                .map(this::totalPriceForItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }

    public BigDecimal totalPriceForItem(OrderItem item) {
        return new BigDecimal(item.getQuantity()).multiply(new BigDecimal(item.getProduct().getPricePerUnit()));
    }
}
