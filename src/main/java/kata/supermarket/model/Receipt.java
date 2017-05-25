package kata.supermarket.model;

import java.util.List;

public class Receipt {

    private List<OrderItem> items;

    private double subtotal;

    private List<Saving> savings;

    private double total;

    public Receipt(List<OrderItem> items, double subtotal, List<Saving> savings, double total) {
        this.items = items;
        this.subtotal = subtotal;
        this.savings = savings;
        this.total = total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public List<Saving> getSavings() {
        return savings;
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
        if (items != null ? !items.equals(receipt.items) : receipt.items != null) return false;
        return savings != null ? savings.equals(receipt.savings) : receipt.savings == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = items != null ? items.hashCode() : 0;
        temp = Double.doubleToLongBits(subtotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (savings != null ? savings.hashCode() : 0);
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
