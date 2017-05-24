package kata.supermarket.model;

public enum UnitType {
    QUANTITY {
        @Override
        public boolean valid(double value) {
            int intVal = (int) value;
            return intVal == value && intVal > 0;
        }
    }, KG {
        @Override
        public boolean valid(double value) {
            return value >= 0.01;
        }
    };

    public abstract boolean valid(double value);
}
