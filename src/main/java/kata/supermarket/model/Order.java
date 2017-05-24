package kata.supermarket.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Order {
    private List<OrderItem> listItems = new ArrayList<>();

    public Order(OrderItem firstItem, OrderItem... items) {
        if (firstItem == null) {
            throw new NullPointerException("The product must not be null");
        }
        listItems.add(firstItem);
        listItems.addAll(Arrays.asList(items));
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(listItems);
    }
}
