package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.hotel.service.HotelService;
import bg.softuni.hotelreservation.reservation.service.ReservationService;
import bg.softuni.hotelreservation.user.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final HotelService hotelService;
    private final UserService userService;
    private final ReservationService reservationService;

    public AdminController(HotelService hotelService, UserService userService, ReservationService reservationService) {
        this.hotelService = hotelService;
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard"; // Thymeleaf шаблон
    }

    @GetMapping("/hotels")
    public String manageHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "admin/hotels";
    }

    @GetMapping("/users")
    public String manageUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    @GetMapping("/reservations")
    public String manageReservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "admin/reservations";
    }
}