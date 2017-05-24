package kata.supermarket.model;

public class Product {
    private String name;
    private UnitType unit;
    private double pricePerUnit;

    public Product(String name, UnitType unit, double pricePerUnit) {
        if (name == null || unit == null) {
            throw new NullPointerException("Mandatory fields not provided");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name must have at least one character");
        }
        this.name = name;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
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
