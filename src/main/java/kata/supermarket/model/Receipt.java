package kata.supermarket.model;

import java.util.List;

public class Receipt {

    private List<OrderItem> items;

    private double subtotal;

    private double total;

    public Receipt(List<OrderItem> items, double subtotal, double total) {
        this.items = items;
        this.subtotal = subtotal;
        this.total = total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (Double.compare(receipt.subtotal, subtotal) != 0) return false;
        if (Double.compare(receipt.total, total) != 0) return false;
        return items.equals(receipt.items);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = items.hashCode();
        temp = Double.doubleToLongBits(subtotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
