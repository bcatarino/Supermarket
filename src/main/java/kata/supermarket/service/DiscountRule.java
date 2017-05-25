package kata.supermarket.service;

import java.math.BigDecimal;

public enum DiscountRule {

    THREE_FOR_TWO("3 for 2") {
        @Override
        public double calculateDiscount(int numItems, double unitPrice) {
            return new BigDecimal(numItems - numItems / 3 * 2 - numItems % 3)
                    .multiply(new BigDecimal(unitPrice)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }, TWO_FOR_ONE_POUND("2 for £1") {
        @Override
        public double calculateDiscount(int numItems, double unitPrice) {
            return new BigDecimal(numItems).multiply(new BigDecimal(unitPrice))
                    .subtract(new BigDecimal(numItems / 2)).subtract(new BigDecimal(numItems % 2).multiply(new BigDecimal(unitPrice)))
                    .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    };

    private String name;

    DiscountRule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateDiscount(int numItems, double unitPrice);
}