package kata.supermarket.service;

import kata.supermarket.model.Order;
import kata.supermarket.model.OrderItem;
import kata.supermarket.model.Receipt;

import java.math.BigDecimal;
import java.util.Optional;

public class OrderService {

    public Optional<Receipt> calculateTotal(Order order) {

        if (order == null) {
            return Optional.empty();
        }

        double total = order.getItems().stream()
                .map(this::totalPriceForItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        return Optional.of(new Receipt(order.getItems(), total, total));
    }

    public BigDecimal totalPriceForItem(OrderItem item) {
        return new BigDecimal(item.getQuantity()).multiply(new BigDecimal(item.getProduct().getPricePerUnit()));
    }
}
