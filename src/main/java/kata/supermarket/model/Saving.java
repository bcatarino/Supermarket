package kata.supermarket.model;

public class Saving {

    private String discountName;

    private String productName;

    private double savingAmount;

    public Saving(String discountName, String productName, double savingAmount) {
        this.discountName = discountName;
        this.productName = productName;
        this.savingAmount = savingAmount;
    }

    public String getDiscountName() {
        return discountName;
    }

    public String getProductName() {
        return productName;
    }

    public double getSavingAmount() {
        return savingAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Saving saving = (Saving) o;

        if (Double.compare(saving.savingAmount, savingAmount) != 0) return false;
        if (discountName != null ? !discountName.equals(saving.discountName) : saving.discountName != null)
            return false;
        return productName != null ? productName.equals(saving.productName) : saving.productName == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = discountName != null ? discountName.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        temp = Double.doubleToLongBits(savingAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
