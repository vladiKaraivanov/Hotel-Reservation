package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.service.HotelService;
import bg.softuni.hotelreservation.room.model.Room;
import bg.softuni.hotelreservation.room.service.RoomService;
import bg.softuni.hotelreservation.web.dto.HotelViewModel;
import bg.softuni.hotelreservation.web.dto.RoomBindingModel;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/")
public class AdminRoomController {
private final RoomService roomService;
private final HotelService hotelService;
private final ModelMapper modelMapper;

    public AdminRoomController(RoomService roomService, HotelService hotelService, ModelMapper modelMapper) {
        this.roomService = roomService;
        this.hotelService = hotelService;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hotels/{hotelId}/add-room")
    public String showAddRoomForm(@PathVariable UUID hotelId, Model model) {

        HotelViewModel hotel = hotelService.findHotelById(hotelId);
        model.addAttribute("hotelName", hotel.getName());
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("roomBindingModel", new RoomBindingModel());

        List<Room> rooms = roomService.findAllRoomInHotel(hotelId);
        model.addAttribute("rooms", rooms);
        return "admin/add-room";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/hotels/{hotelId}/add-room")
    public String addRoom(@PathVariable UUID hotelId, @Valid RoomBindingModel roomBindingModel,
                          BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("roomBindingModel", roomBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.roomBindingModel", bindingResult);
            return "redirect:/admin/hotels/" + hotelId + "/add-room";
        }
        roomService.addRoom(roomBindingModel, hotelId);
        return "redirect:/admin/hotels/" + hotelId + "/add-room";
    }
    @GetMapping("/hotels/{hotelId}/rooms/{roomId}/available")
    public String makeAvailable(@PathVariable("hotelId") UUID hotelId,
                                @PathVariable("roomId") UUID roomId) {
        roomService.setAvailability(roomId, true);
        return "redirect:/admin/hotels/" + hotelId + "/add-room";
    }

    @GetMapping("/hotels/{hotelId}/rooms/{roomId}/unavailable")
    public String makeUnavailable(@PathVariable("hotelId") UUID hotelId,
                                  @PathVariable("roomId") UUID roomId) {
        roomService.setAvailability(roomId, false);
        return "redirect:/admin/hotels/" + hotelId + "/add-room";
    }
    @GetMapping("/rooms")
    public String roomsAdministrated(Model model) {
      List<Hotel> hotels =  hotelService.getAllHotels();
//      List<Room> rooms = roomService.findAllRoomInHotel();
        //TODO MAKE TWO LIST WITH AVAILABLE AND NOT ROOMS AND ADD LIKE ATTRIBUTES
      model.addAttribute("hotels", hotels);

        return "admin/rooms";
    }

}
