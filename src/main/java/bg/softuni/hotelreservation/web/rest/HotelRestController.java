package bg.softuni.hotelreservation.web.rest;

import bg.softuni.hotelreservation.hotel.model.HotelDto;
import bg.softuni.hotelreservation.hotel.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

//@RestController()
//@RequestMapping("/api/v1/hotels")
public class HotelRestController {
    private final HotelService hotelService;

    public HotelRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
//    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable UUID id){
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }
}
