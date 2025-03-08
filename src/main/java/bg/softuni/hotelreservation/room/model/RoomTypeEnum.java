package bg.softuni.hotelreservation.room.model;

public enum RoomTypeEnum {
    SINGLE("Single"),
    DOUBLE("Double"),
    SUITE("Suite");

    private final String displayName;

    RoomTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
