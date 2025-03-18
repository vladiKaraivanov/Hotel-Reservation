package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.hotel.service.HotelService;
import bg.softuni.hotelreservation.room.model.Room;
import bg.softuni.hotelreservation.room.model.RoomTypeEnum;
import bg.softuni.hotelreservation.room.service.RoomService;
import bg.softuni.hotelreservation.web.dto.HotelDetailsViewModel;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;
    private final RoomService roomService;

    public HotelController(HotelService hotelService, RoomService roomService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable UUID id, Model model) {
        HotelDetailsViewModel hotel = hotelService.getHotelDetails(id);

        List<Room> freeRooms = roomService.findByHotelIdAndReservedFalse(hotel.getId());
        List<Room> reservedRooms = roomService.findByHotelIdAndReservedTrue(hotel.getId());
//        if (hotel != null) {
        Map<RoomTypeEnum, Long> freeRoomsCountByType = freeRooms.stream()
                .collect(Collectors.groupingBy(Room::getRoomType, Collectors.counting()));

        model.addAttribute("hotel", hotel);
        model.addAttribute("freeRooms", freeRooms);
        model.addAttribute("freeRoomsCountByType", freeRoomsCountByType);
        model.addAttribute("reservedRooms", reservedRooms);
//        }
        return "hotels/hotel-details";
    }

    @PostMapping("/{id}/details")
    public String makeReservation(@PathVariable UUID id,
                                  @RequestParam("checkInDate") LocalDate checkInDate,
                                  @RequestParam("checkOutDate") LocalDate checkOutDate,
                                  @AuthenticationPrincipal UserDetails userDetails,
                                  RedirectAttributes redirectAttributes) {
        hotelService.createReservation(id, userDetails.getUsername(), checkInDate, checkOutDate);
        redirectAttributes.addFlashAttribute("message", "Reservation successful!");
        return "redirect:/hotels/" + id + "/details";
    }
}
