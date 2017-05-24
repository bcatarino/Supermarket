package kata.supermarket.model;

import org.junit.Test;

import static kata.supermarket.testobjects.OrderItemFactory.beansItem;
import static kata.supermarket.testobjects.OrderItemFactory.orangesItem;
import static org.junit.Assert.assertArrayEquals;

public class ProductTest {

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfNullNameIsProvided() {
        new Product(null, UnitType.QUANTITY, 2d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfEmptyNameIsProvided() {
        new Product("", UnitType.QUANTITY, 2d);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfNullUnitTypeIsProvided() {
        new Product("something", null, 2d);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerIfNullFirstArgumentGiven() {
        new Order(null);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerIfNullArgumentGiven() {
        new Order(beansItem(), null);
    }

    @Test
    public void shouldAppendItems() {
        Order order = new Order(beansItem(), orangesItem());
        assertArrayEquals(new OrderItem[]{beansItem(), orangesItem()}, order.getItems().toArray());
    }

    @Test
    public void shouldAppendItemsWhenRepeated() {
        Order order = new Order(beansItem(), orangesItem(), beansItem());
        assertArrayEquals(new OrderItem[]{beansItem(), orangesItem(), beansItem()}, order.getItems().toArray());
    }
}
