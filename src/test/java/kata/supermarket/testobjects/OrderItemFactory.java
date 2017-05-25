package kata.supermarket.testobjects;

import kata.supermarket.model.OrderItem;

import static kata.supermarket.testobjects.ProductFactory.*;

public final class OrderItemFactory {

    private OrderItemFactory() {}

    public static OrderItem beansItem() {
        return new OrderItem(beans());
    }

    public static OrderItem beansItemWithSavings() {
        return new OrderItem(beans3For2());
    }

    public static OrderItem cokeItem() {
        return new OrderItem(coke());
    }

    public static OrderItem cokeItemWithSavings() {
        return new OrderItem(coke2For1Pound());
    }

    public static OrderItem orangesItem() {
        return new OrderItem(oranges(), 0.2);
    }
}
