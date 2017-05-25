package kata.supermarket.service;

import kata.supermarket.model.Order;
import kata.supermarket.model.OrderItem;
import kata.supermarket.model.Receipt;
import kata.supermarket.model.Saving;
import org.junit.Test;

import java.util.Collections;
import java.util.Optional;

import static kata.supermarket.testobjects.OrderItemFactory.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static kata.supermarket.testobjects.SavingsFactory.*;

public class OrderServiceTest {

    private OrderService service = new OrderService();

    private Receipt dummyReceipt = new Receipt(Collections.emptyList(), 0d, Collections.emptyList(), 0d);

    @Test
    public void shouldReturn0IfNoOrder() {
        assertEquals(Optional.empty(), service.calculateTotal(null));
    }

    @Test
    public void shouldReturnProductCostForSingleProductOrder() {
        Receipt receipt = service.calculateTotal(new Order(beansItem())).orElse(dummyReceipt);
        assertArrayEquals(new OrderItem[]{beansItem()}, receipt.getItems().toArray());
        assertEquals(0.5d, receipt.getTotal(), 0d);
        assertEquals(Collections.emptyList(), receipt.getSavings());
        assertEquals(0.5d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldSumCostForMultipleProductOrder() {
        Receipt receipt = service.calculateTotal(new Order(beansItem(), cokeItem())).orElse(dummyReceipt);
        assertArrayEquals(new OrderItem[]{beansItem(), cokeItem()}, receipt.getItems().toArray());
        assertEquals(1.2d, receipt.getTotal(), 0d);
        assertEquals(Collections.emptyList(), receipt.getSavings());
        assertEquals(1.2d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldSumCostForMultipleProductsOfSameKind() {
        Receipt receipt = service.calculateTotal(new Order(beansItem(), beansItem())).orElse(dummyReceipt);
        assertArrayEquals(new OrderItem[]{beansItem(), beansItem()}, receipt.getItems().toArray());
        assertEquals(1d, receipt.getTotal(), 0d);
        assertEquals(Collections.emptyList(), receipt.getSavings());
        assertEquals(1d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldMultiplyKgQuantityForPrice() {
        Receipt receipt = service.calculateTotal(new Order(orangesItem())).orElse(dummyReceipt);
        assertArrayEquals(new OrderItem[]{orangesItem()}, receipt.getItems().toArray());
        assertEquals(0.4d, receipt.getTotal(), 0d);
        assertEquals(Collections.emptyList(), receipt.getSavings());
        assertEquals(0.4d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldCalculateTotalInLargeOrder() {
        Receipt receipt = service.calculateTotal(new Order(beansItem(), beansItem(), beansItem(), cokeItem(),
                cokeItem(), orangesItem())).orElse(dummyReceipt);
        assertArrayEquals(new OrderItem[]{beansItem(), beansItem(), beansItem(), cokeItem(), cokeItem(),
                orangesItem()}, receipt.getItems().toArray());
        assertEquals(3.3d, receipt.getTotal(), 0d);
        assertEquals(Collections.emptyList(), receipt.getSavings());
        assertEquals(3.3d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldApplyDiscountForBeans() {
        Receipt receipt = service.calculateTotal(new Order(beansItemWithSavings(),
                beansItemWithSavings(), beansItemWithSavings())).orElse(dummyReceipt);
        assertArrayEquals(new OrderItem[]{beansItemWithSavings(), beansItemWithSavings(), beansItemWithSavings()},
                receipt.getItems().toArray());
        assertEquals(1d, receipt.getTotal(), 0d);
        assertArrayEquals(new Saving[]{beansSaving()}, receipt.getSavings().toArray());
        assertEquals(1.5d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldApplyDiscountForCoke() {
        Receipt receipt = service.calculateTotal(new Order(cokeItemWithSavings(),
                cokeItemWithSavings())).orElse(dummyReceipt);
        assertEquals(1d, receipt.getTotal(), 0d);
        assertArrayEquals(new Saving[]{cokeSaving()}, receipt.getSavings().toArray());
        assertEquals(1.4d, receipt.getSubtotal(), 0d);
    }

    @Test
    public void shouldCalculateTotalWithSavingsInLargeOrder() {
        Receipt receipt = service.calculateTotal(new Order(beansItemWithSavings(), beansItemWithSavings(),
                beansItemWithSavings(), cokeItemWithSavings(), cokeItemWithSavings(),
                orangesItem())).orElse(dummyReceipt);
        assertEquals(2.4d, receipt.getTotal(), 0d);
        assertArrayEquals(new Saving[]{beansSaving(), cokeSaving()}, receipt.getSavings().toArray());
        assertEquals(3.3d, receipt.getSubtotal(), 0d);
    }
}
