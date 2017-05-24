package kata.supermarket.testobjects;

import kata.supermarket.model.Product;
import kata.supermarket.model.UnitType;

public final class ProductFactory {

    private ProductFactory() {}

    public static Product beans() {
        return new Product("beans", UnitType.QUANTITY, 0.5);
    }

    public static Product coke() {
        return new Product("coke", UnitType.QUANTITY, 0.7);
    }

    public static Product oranges() {
        return new Product("oranges", UnitType.KG, 1.99);
    }
}