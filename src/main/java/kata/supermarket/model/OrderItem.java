package kata.supermarket.model;

public class OrderItem {

    private Product product;
    private double quantity;

    public OrderItem(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (Double.compare(orderItem.quantity, quantity) != 0) return false;
        return product.equals(orderItem.product);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = product.hashCode();
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
