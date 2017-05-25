package kata.supermarket.testobjects;

import kata.supermarket.model.Saving;
import kata.supermarket.service.DiscountRule;

public final class SavingsFactory {

    private SavingsFactory() {}

    public static Saving beansSaving() {
        return new Saving(DiscountRule.THREE_FOR_TWO.getName(), ProductFactory.beans().getName(), 0.5);
    }

    public static Saving cokeSaving() {
        return new Saving(DiscountRule.TWO_FOR_ONE_POUND.getName(), ProductFactory.coke().getName(), 0.4);
    }
}
