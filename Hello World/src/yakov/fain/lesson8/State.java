package yakov.fain.lesson8;

public enum State implements Operation {

    ZERO("0") {
        public double apply(double x, double y){ return 0;}
    },
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("−") {
        public double apply(double x, double y) { return x - y; }
    },
    MULTIPLY("×") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    },
    EQUALS("="){
        public double apply(double x, double y) { return x; }
    };

    private final String symbol;

    State(String symbol) {
        this.symbol = symbol;
    }
    @Override
    public String toString() {
        return symbol;
    }

    public static State fromString(String text) {
        if (text != null) {
            for (State b : State.values()) {
                if (text.equalsIgnoreCase(b.toString())) {
                    return b;
                }
            }
        }
        return null;
    }

}