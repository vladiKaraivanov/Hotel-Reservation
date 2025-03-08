package bg.softuni.hotelreservation.reservation.model;

public enum StatusEnum {
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled"),
    PENDING("Pending");

    private final String displayName;

    StatusEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
