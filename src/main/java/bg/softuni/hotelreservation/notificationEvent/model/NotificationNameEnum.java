package bg.softuni.hotelreservation.notificationEvent.model;

public enum NotificationNameEnum {
    NEW_RESERVATION("✅ A new reservation has been made. Please review the details."),
    NEW_REGISTRATION("👤 A new user has registered. Welcome aboard!"),
    NEW_RESERVATION_CONFIRMATION("✅ Your reservation has been confirmed! We look forward to seeing you."),
    CANCEL_RESERVATION("❌ A reservation has been canceled. If you have any questions, feel free to contact us.");

    private final String message;

    NotificationNameEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

