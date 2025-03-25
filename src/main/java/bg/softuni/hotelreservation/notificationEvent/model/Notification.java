package bg.softuni.hotelreservation.notificationEvent.model;

import bg.softuni.hotelreservation.user.model.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name= "notification")
public class Notification {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne()
    private User user;
    @Column(nullable = false)
    private String notificationText;
    @Column()
    private LocalDate notificationDate;
    @Column()
    private boolean readStatus;


    public Notification() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User toUser) {
        this.user = toUser;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public LocalDate getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(LocalDate notificationDate) {
        this.notificationDate = notificationDate;
    }

    public boolean isReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean read) {
        this.readStatus = read;
    }
}
