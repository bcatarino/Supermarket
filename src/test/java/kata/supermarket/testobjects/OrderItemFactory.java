package kata.supermarket.testobjects;

import kata.supermarket.model.OrderItem;

import static kata.supermarket.testobjects.ProductFactory.*;

public final class OrderItemFactory {

    private OrderItemFactory() {}

    public static OrderItem beansItem() {
        return new OrderItem(beans());
    }

    public static OrderItem cokeItem() {
        return new OrderItem(coke());
    }

    public static OrderItem orangesItem() {
        return new OrderItem(oranges(), 0.2);
    }
}
