package bg.softuni.hotelreservation.notificationEvent.repository;

import bg.softuni.hotelreservation.user.model.User;
import bg.softuni.hotelreservation.notificationEvent.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    List<Notification> findAllByUserOrderByNotificationDateDesc(User user);
}
