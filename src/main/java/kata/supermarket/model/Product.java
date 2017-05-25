package kata.supermarket.model;

import kata.supermarket.service.DiscountRule;

import java.util.Optional;

public class Product {
    private String name;
    private UnitType unit;
    private double pricePerUnit;
    private Optional<DiscountRule> discount;

    public Product(String name, UnitType unit, double pricePerUnit) {
        this(name, unit, pricePerUnit, Optional.empty());
    }

    public Product(String name, UnitType unit, double pricePerUnit, Optional<DiscountRule> discount) {
        if (name == null || unit == null) {
            throw new NullPointerException("Mandatory fields not provided");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name must have at least one character");
        }
        this.name = name;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public UnitType getUnit() {
        return unit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public Optional<DiscountRule> getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.pricePerUnit, pricePerUnit) != 0) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return unit == product.unit;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        temp = Double.doubleToLongBits(pricePerUnit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
