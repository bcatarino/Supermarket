package kata.supermarket.service;

import kata.supermarket.model.Order;
import org.junit.Test;

import static kata.supermarket.testobjects.OrderItemFactory.*;
import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    private OrderService service = new OrderService();

    @Test
    public void shouldReturn0IfNoOrder() {
        assertEquals(0d, service.calculateTotal(null), 0d);
    }

    @Test
    public void shouldReturnProductCostForSingleProductOrder() {
        assertEquals(0.5d, service.calculateTotal(new Order(beansItem())), 0d);
    }

    @Test
    public void shouldSumCostForMultipleProductOrder() {
        assertEquals(1.2d, service.calculateTotal(new Order(beansItem(), cokeItem())), 0d);
    }

    @Test
    public void shouldSumCostForMultipleProductsOfSameKind() {
        assertEquals(1d, service.calculateTotal(new Order(beansItem(), beansItem())), 0d);
    }

    @Test
    public void shouldMultiplyKgQuantityForPrice() {
        assertEquals(0.4d, service.calculateTotal(new Order(orangesItem())), 0d);
    }

    @Test
    public void shouldCalculateTotalInLargeOrder() {
        assertEquals(3.3d, service.calculateTotal(new Order(beansItem(), beansItem(), beansItem(), cokeItem(), cokeItem(), orangesItem())), 0d);
    }
}
