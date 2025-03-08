package bg.softuni.hotelreservation.user.model;

public enum UserRoleEnum {
    ADMIN("Admin"),
    USER("User");
//    STAFF("Staff"),
//    GUEST("Guest");

    private final String displayName;

    UserRoleEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}

