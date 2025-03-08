package bg.softuni.hotelreservation.user.model;

public enum InterestsEnum {
    SPORT("Sport"),
    PHOTOGRAPHY("Photography"),
    ARCHAEOLOGY("Archaeology"),
    ANIMALS("Animals"),
    ARCHITECTURE("Architecture");

    private final String displayName;

    InterestsEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
