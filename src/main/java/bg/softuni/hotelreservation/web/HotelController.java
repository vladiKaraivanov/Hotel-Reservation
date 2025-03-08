package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.hotel.model.HotelDto;
import bg.softuni.hotelreservation.hotel.service.HotelService;
import bg.softuni.hotelreservation.room.service.RoomService;
import bg.softuni.hotelreservation.web.dto.RoomBindingModel;
import bg.softuni.hotelreservation.web.dto.RoomViewModel;
import bg.softuni.hotelreservation.web.dto.hotelViewModel;
import bg.softuni.hotelreservation.web.dto.HotelBindingModel;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/hotels")
public class HotelController {
    private final HotelService hotelService;
    private final RoomService roomService;

    public HotelController(HotelService hotelService, RoomService roomService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editHotel(@PathVariable("id") String id, Model model) {
        if (hotelService.findHotelById(id) != null) {
            hotelViewModel hotelViewModel = hotelService.findHotelById(id);
            model.addAttribute("hotelView", hotelViewModel);
            return "admin/edit";
        }
        return "/admin/hotels";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    public String saveChanges(@Valid HotelBindingModel hotelBindingModel, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, @PathVariable String id) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult);
            return "redirect:/admin/hotels/edit/" + id;
        }
        hotelService.saveChanges(id, hotelBindingModel);
        return "redirect:/admin/hotels";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/changeStatus/{id}")
    public String deleteOrActivateHotel(@PathVariable String id) {
        hotelService.deleteActivateHotelById(id);
        return "redirect:/admin/hotels";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/add")
    public String addHotel(@ModelAttribute("hotelBindingModel") HotelBindingModel hotelBindingModel) {

        return "admin/add-hotel";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public String saveHotel(@Valid HotelBindingModel hotelBindingModel, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hotelBindingModel", hotelBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.hotelBindingModel", bindingResult);
            return "admin/add-hotel";
        }
        String hotelId = hotelService.addNewHotel(hotelBindingModel);
//        String hotelId = hotelDto.getId();
        if (hotelId == null) {
            redirectAttributes.addFlashAttribute("error", "Failed to save hotel. Please try again.");
            return "redirect:/admin/hotels/add";
        }
//        redirectAttributes.addAttribute("hotelId", hotelId);
        return "redirect:/admin/hotels/" + hotelId + "/add-room";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{hotelId}/add-room")
    public String showAddRoomForm(@PathVariable String hotelId, Model model) {
        hotelViewModel hotel = hotelService.findHotelById(hotelId);
        model.addAttribute("hotelName", hotel.getName());
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("roomBindingModel", new RoomBindingModel());
        return "admin/add-room";
    }
//TODO IMPLEMENT ADD ROOM TO NEW HOTEL FUNCTIONALITY


//    @ModelAttribute("editHotel")
//    public HotelBindingModel hotelBindingModel(){
//        return new HotelBindingModel();
//    }
}
