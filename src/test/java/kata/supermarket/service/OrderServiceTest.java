package kata.supermarket.service;

import kata.supermarket.model.Order;
import kata.supermarket.model.OrderItem;
import kata.supermarket.model.Receipt;
import org.junit.Test;

import java.util.Collections;
import java.util.Optional;

import static kata.supermarket.testobjects.OrderItemFactory.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    private OrderService service = new OrderService();

    private Receipt mockReceipt = new Receipt(Collections.emptyList(), 0d, 0d);

    @Test
    public void shouldReturn0IfNoOrder() {
        assertEquals(Optional.empty(), service.calculateTotal(null));
    }

    @Test
    public void shouldReturnProductCostForSingleProductOrder() {
        Receipt receipt = service.calculateTotal(new Order(beansItem())).orElse(mockReceipt);
        assertArrayEquals(new OrderItem[]{beansItem()}, receipt.getItems().toArray());
        assertEquals(0.5d, receipt.getTotal(), 0d);
        assertEquals(0.5d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldSumCostForMultipleProductOrder() {
        Receipt receipt = service.calculateTotal(new Order(beansItem(), cokeItem())).orElse(mockReceipt);
        assertArrayEquals(new OrderItem[]{beansItem(), cokeItem()}, receipt.getItems().toArray());
        assertEquals(1.2d, receipt.getTotal(), 0d);
        assertEquals(1.2d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldSumCostForMultipleProductsOfSameKind() {
        Receipt receipt = service.calculateTotal(new Order(beansItem(), beansItem())).orElse(mockReceipt);
        assertArrayEquals(new OrderItem[]{beansItem(), beansItem()}, receipt.getItems().toArray());
        assertEquals(1d, receipt.getTotal(), 0d);
        assertEquals(1d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldMultiplyKgQuantityForPrice() {
        Receipt receipt = service.calculateTotal(new Order(orangesItem())).orElse(mockReceipt);
        assertArrayEquals(new OrderItem[]{orangesItem()}, receipt.getItems().toArray());
        assertEquals(0.4d, receipt.getTotal(), 0d);
        assertEquals(0.4d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldCalculateTotalInLargeOrder() {
        Receipt receipt = service.calculateTotal(new Order(beansItem(), beansItem(), beansItem(), cokeItem(), cokeItem(), orangesItem())).orElse(mockReceipt);
        assertArrayEquals(new OrderItem[]{beansItem(), beansItem(), beansItem(), cokeItem(), cokeItem(), orangesItem()}, receipt.getItems().toArray());
        assertEquals(3.3d, receipt.getTotal(), 0d);
        assertEquals(3.3d, receipt.getSubtotal(), 0d);
    }
}
