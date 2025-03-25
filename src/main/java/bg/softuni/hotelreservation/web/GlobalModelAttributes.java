package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.notificationEvent.model.Notification;
import bg.softuni.hotelreservation.notificationEvent.service.NotificationService;
import bg.softuni.hotelreservation.security.AuthenticationDetails;
import bg.softuni.hotelreservation.user.model.User;
import bg.softuni.hotelreservation.user.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalModelAttributes {
    private final NotificationService notificationService;
    private final UserService userService;

    public GlobalModelAttributes(NotificationService notificationService, UserService userService) {
        this.notificationService = notificationService;
        this.userService = userService;
    }

    @ModelAttribute("unreadCount")
    public int unreadCount() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !(auth.getPrincipal() instanceof AuthenticationDetails details)) {
            return 0;
        }
        User user = userService.findUserById(details.getId());

        return notificationService.getUnreadNotifications(user).size();
    }

    @ModelAttribute("unreadNotification")
    public List<Notification> getUnreadNotifications() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !(auth.getPrincipal() instanceof AuthenticationDetails details)) {
            return List.of();
        }

        User user = userService.findUserById(details.getId());
        return notificationService.getUnreadNotifications(user);
    }

}
