package bg.softuni.hotelreservation.restaurant.model;

public enum PriceLevelEnum {

        BUDGET("Budget", "€"),  // Нисък ценови клас
        MODERATE("Moderate", "€€"),  // Среден ценови клас
        PREMIUM("Premium", "€€€"),  // Висок ценови клас
        LUXURY("Luxury", "€€€€");  // Луксозен клас

        private final String label;
        private final String symbol;

    PriceLevelEnum(String label, String symbol) {
            this.label = label;
            this.symbol = symbol;
        }

        public String getLabel() {
            return label;
        }

        public String getSymbol() {
            return symbol;
        }

}
