package bg.softuni.hotelreservation.notificationEvent;

import bg.softuni.hotelreservation.notificationEvent.model.NotificationEventDto;
import org.springframework.context.ApplicationEvent;

public class NotificationCreatedEvent extends ApplicationEvent {
    private final NotificationEventDto notificationEventDto;

    public NotificationCreatedEvent(NotificationEventDto notificationEventDto) {
        super(notificationEventDto);
        this.notificationEventDto = notificationEventDto;
    }

    public NotificationEventDto getNotificationEventDto() {
        return notificationEventDto;
    }
}
