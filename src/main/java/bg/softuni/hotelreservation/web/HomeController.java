package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.service.HotelService;
import bg.softuni.hotelreservation.notificationEvent.model.Notification;
import bg.softuni.hotelreservation.security.AuthenticationDetails;
import bg.softuni.hotelreservation.user.model.User;
import bg.softuni.hotelreservation.user.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final HotelService hotelService;
    private final UserService userService;

    public HomeController(HotelService hotelService, UserService userService) {
        this.hotelService = hotelService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal AuthenticationDetails authenticationDetails, Model model) {
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels", hotels);

        User user = userService.findUserById(authenticationDetails.getId());
        List<Notification> unreadNotification = user.getNotification().stream()
                .filter(notification -> !notification.isReadStatus()).toList();

//        model.addAttribute("unreadNotification", unreadNotification);
//        model.addAttribute("unreadCount", unreadNotification.size()); THEY ARE ADDED IN GLOBAL MODEL ATTRIBUTES
        return "index";
    }

}
