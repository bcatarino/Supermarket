package kata.supermarket.model;

import org.junit.Test;
import static org.junit.Assert.*;
import static kata.supermarket.testobjects.ProductFactory.*;

public class OrderItemTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfKgUnderZero() {
        new OrderItem(oranges(), -0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfKgIsZero() {
        new OrderItem(oranges(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfKgIsLessThanOneCent() {
        new OrderItem(oranges(), 0.009);
    }

    @Test
    public void shouldCreateOrderItemIfKgIsOneCent() {
        assertNotNull(new OrderItem(oranges(), 0.01));
    }

    @Test
    public void shouldCreateOrderItemIfKgIsAboveMinimum() {
        assertNotNull(new OrderItem(oranges(), 4.4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfQuantityIsNotInteger() {
        new OrderItem(beans(), 3.2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfQuantityIsLessThanZero() {
        new OrderItem(beans(), -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfQuantityIsZero() {
        new OrderItem(beans(), 0);
    }

    @Test
    public void shouldCreateOrderItemIfQuantityIsOne() {
        assertNotNull(new OrderItem(beans(), 1));
    }

    @Test
    public void shouldCreateOrderItemIfQuantityIsMoreThanOne() {
        assertNotNull(new OrderItem(beans(), 4));
    }
}
