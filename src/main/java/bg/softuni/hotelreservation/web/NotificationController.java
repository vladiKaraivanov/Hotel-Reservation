package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.notificationEvent.service.NotificationService;
import bg.softuni.hotelreservation.security.AuthenticationDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
@PostMapping("mark-as-read")
    public String markAsRead(@RequestParam UUID id, @AuthenticationPrincipal AuthenticationDetails details, Model model) {
        notificationService.markAsRead(id);
        return "redirect:/";
    }
}
