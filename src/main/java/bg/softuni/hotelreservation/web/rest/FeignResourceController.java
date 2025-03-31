package bg.softuni.hotelreservation.web.rest;

import bg.softuni.hotelreservation.hotel.model.HotelDto;
import bg.softuni.hotelreservation.hotel.service.HotelService;
import bg.softuni.hotelreservation.room.model.RoomDto;
import bg.softuni.hotelreservation.room.service.RoomService;
import bg.softuni.hotelreservation.user.model.UserDto;
import bg.softuni.hotelreservation.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class FeignResourceController {
    private final RoomService roomService;
    private final UserService userService;
    private final HotelService hotelService;
    private final ModelMapper modelMapper;

    public FeignResourceController(RoomService roomService, UserService userService, HotelService hotelService, ModelMapper modelMapper) {
        this.roomService = roomService;
        this.userService = userService;
        this.hotelService = hotelService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/hotels/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable UUID id){
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @GetMapping("/users/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        UserDto userDto= modelMapper.map(userService.findUserById(id),UserDto.class);
        return ResponseEntity.ok(userDto);
    }
    @GetMapping("/rooms/{id}")
    ResponseEntity<RoomDto> getRoomById(@PathVariable UUID id) {
        RoomDto roomDto = roomService.findRoomById(id);
        return ResponseEntity.ok(roomDto);
     }
}
