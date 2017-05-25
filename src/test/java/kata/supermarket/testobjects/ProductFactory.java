package kata.supermarket.testobjects;

import kata.supermarket.model.Product;
import kata.supermarket.model.UnitType;
import kata.supermarket.service.DiscountRule;

import java.util.Optional;

public final class ProductFactory {

    private ProductFactory() {}

    public static Product beans() {
        return new Product("beans", UnitType.QUANTITY, 0.5);
    }

    public static Product beans3For2() {
        return new Product("beans", UnitType.QUANTITY, 0.5, Optional.of(DiscountRule.THREE_FOR_TWO));
    }

    public static Product coke() {
        return new Product("coke", UnitType.QUANTITY, 0.7);
    }

    public static Product coke2For1Pound() {
        return new Product("coke", UnitType.QUANTITY, 0.7, Optional.of(DiscountRule.TWO_FOR_ONE_POUND));
    }

    public static Product oranges() {
        return new Product("oranges", UnitType.KG, 1.99);
    }
}