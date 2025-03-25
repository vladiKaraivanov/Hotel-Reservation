package bg.softuni.hotelreservation.notificationEvent.model;

import bg.softuni.hotelreservation.user.model.User;

import java.time.LocalDate;
import java.util.UUID;

public class NotificationEventDto {
    private UUID userId;
    private String text;
    private LocalDate date;
    private boolean read;

    public NotificationEventDto(String text, UUID userId) {
this.text = text;
this.userId = userId;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public NotificationEventDto() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
