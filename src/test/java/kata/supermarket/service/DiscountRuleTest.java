package kata.supermarket.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountRuleTest {

    @Test
    public void threeForTwoShouldReturnZeroForZeroItems() {
        assertEquals(0d, DiscountRule.THREE_FOR_TWO.calculateDiscount(0, 4), 0d);
    }

    @Test
    public void threeForTwoShouldReturnZeroForOneItems() {
        assertEquals(0d, DiscountRule.THREE_FOR_TWO.calculateDiscount(1, 4), 0d);
    }

    @Test
    public void threeForTwoShouldReturnDiscountForThreeItems() {
        assertEquals(5d, DiscountRule.THREE_FOR_TWO.calculateDiscount(3, 5), 0d);
    }

    @Test
    public void threeForTwoShouldReturnDiscountForFourItems() {
        assertEquals(5d, DiscountRule.THREE_FOR_TWO.calculateDiscount(4, 5), 0d);
    }

    @Test
    public void threeForTwoShouldReturnDiscountForFifteenItems() {
        assertEquals(25d, DiscountRule.THREE_FOR_TWO.calculateDiscount(15, 5), 0d);
    }

    @Test
    public void twoForOnePoundShouldReturnZeroForZeroItems() {
        assertEquals(0d, DiscountRule.TWO_FOR_ONE_POUND.calculateDiscount(0, 0.7), 0d);
    }

    @Test
    public void twoForOnePoundShouldReturnZeroForOneItem() {
        assertEquals(0d, DiscountRule.TWO_FOR_ONE_POUND.calculateDiscount(1, 0.7), 0d);
    }

    @Test
    public void twoForOnePoundShouldReturnDiscountForTwoItems() {
        assertEquals(0.4d, DiscountRule.TWO_FOR_ONE_POUND.calculateDiscount(2, 0.7), 0d);
    }

    @Test
    public void twoForOnePoundShouldReturnDiscountForThreeItems() {
        assertEquals(0.4d, DiscountRule.TWO_FOR_ONE_POUND.calculateDiscount(3, 0.7), 0d);
    }

    @Test
    public void twoForOnePoundShouldReturnDiscountForTenItems() {
        assertEquals(2d, DiscountRule.TWO_FOR_ONE_POUND.calculateDiscount(10, 0.7), 0d);
    }
}
