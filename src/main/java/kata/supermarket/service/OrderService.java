package kata.supermarket.service;

import kata.supermarket.model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderService {

    public Optional<Receipt> calculateTotal(Order order) {

        if (order == null) {
            return Optional.empty();
        }

        List<OrderItem> groupedItems = sumQuantitiesForSameItem(order.getItems());

        double subtotal = groupedItems.stream()
                .map(this::totalPriceForItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        List<Saving> savings = groupedItems.stream()
                .filter(item -> item.getProduct().getDiscount().isPresent() && item.getProduct().getUnit() == UnitType.QUANTITY)
                .map(this::mapToSaving)
                .collect(Collectors.toList());

        double totalDiscount = savings.stream().mapToDouble(Saving::getSavingAmount).sum();
        double total = new BigDecimal(subtotal).subtract(new BigDecimal(totalDiscount))
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return Optional.of(new Receipt(order.getItems(), subtotal, savings, total));
    }

    private Saving mapToSaving(OrderItem item) {
        DiscountRule discountRule = item.getProduct().getDiscount().get();
        double discountValue = discountRule.calculateDiscount((int)item.getQuantity(), item.getProduct().getPricePerUnit());
        return new Saving(discountRule.getName(), item.getProduct().getName(), discountValue);
    }

    private List<OrderItem> sumQuantitiesForSameItem(List<OrderItem> items) {
        return items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summarizingDouble(OrderItem::getQuantity)))
                .entrySet().stream()
                .map(entry -> new OrderItem(entry.getKey().getProduct(), entry.getValue().getSum()))
                .collect(Collectors.toList());
    }

    private BigDecimal totalPriceForItem(OrderItem item) {
        return new BigDecimal(item.getQuantity()).multiply(new BigDecimal(item.getProduct().getPricePerUnit()));
    }
}
