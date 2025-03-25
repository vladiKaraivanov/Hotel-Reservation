package bg.softuni.hotelreservation.notificationEvent.service;

import bg.softuni.hotelreservation.notificationEvent.NotificationCreatedEvent;
import bg.softuni.hotelreservation.notificationEvent.model.NotificationEventDto;
import bg.softuni.hotelreservation.user.model.User;
import bg.softuni.hotelreservation.notificationEvent.model.Notification;
import bg.softuni.hotelreservation.notificationEvent.repository.NotificationRepository;
import bg.softuni.hotelreservation.user.service.UserService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserService userService;

    public NotificationService(NotificationRepository notificationRepository, UserService userService) {
        this.notificationRepository = notificationRepository;

//        this.eventPublisher = eventPublisher;
        this.userService = userService;
    }

    @EventListener
    public void createNotification(NotificationCreatedEvent event) {
        NotificationEventDto notificationEventDto = event.getNotificationEventDto();

        Notification notification = new Notification();
        notification.setNotificationText(notificationEventDto.getText());
        notification.setUser(userService.findUserById(notificationEventDto.getUserId()));
        notification.setNotificationDate(LocalDate.now());
        notification.setReadStatus(false);
        notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsForUser(User user) {
        return notificationRepository.findAllByUserOrderByNotificationDateDesc(user);
    }

    public List<Notification> getUnreadNotifications(User user) {
        return user.getNotification().stream()
                .filter(notification -> !notification.isReadStatus()).toList();
    }

    public void markAsRead(UUID id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found"));
        notification.setReadStatus(true);
        notificationRepository.save(notification);
    }
}
