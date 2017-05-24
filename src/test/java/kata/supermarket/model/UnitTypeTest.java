package kata.supermarket.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnitTypeTest {

    @Test
    public void shouldBeInvalidIfKgLowerThanZero() {
        assertFalse(UnitType.KG.valid(-0.0001));
    }

    @Test
    public void shouldBeInvalidIfKgIsZero() {
        assertFalse(UnitType.KG.valid(0));
    }

    @Test
    public void shouldBeInvalidIfKgIsLowerThanACent() {
        assertFalse(UnitType.KG.valid(0.009));
    }

    @Test
    public void shouldBeValidIfKgIsOneCent() {
        assertTrue(UnitType.KG.valid(0.01));
    }

    @Test
    public void shouldBeValidIfKgIsAboveOneCent() {
        assertTrue(UnitType.KG.valid(3.32));
    }

    @Test
    public void shouldBeInvalidIfQuantityLowerThanZero() {
        assertFalse(UnitType.QUANTITY.valid(-1));
    }

    @Test
    public void shouldBeInvalidIfQuantityIsZero() {
        assertFalse(UnitType.QUANTITY.valid(0));
    }

    @Test
    public void shouldBeInvalidIfQuantityIsLessThanOne() {
        assertFalse(UnitType.QUANTITY.valid(0.05));
    }

    @Test
    public void shouldBeInvalidIfQuantityIsNotInteger() {
        assertFalse(UnitType.QUANTITY.valid(4.5));
    }

    @Test
    public void shouldBeValidIfQuantityIsOne() {
        assertTrue(UnitType.QUANTITY.valid(1));
    }

    @Test
    public void shouldBeValidIfQuantityIsInteger() {
        assertTrue(UnitType.QUANTITY.valid(4));
    }
}
