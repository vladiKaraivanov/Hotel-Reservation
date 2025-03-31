package bg.softuni.hotelreservation.web.rest;

import bg.softuni.hotelreservation.user.model.UserDto;
import bg.softuni.hotelreservation.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

//@RestController
//@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRestController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

//    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
       UserDto userDto= modelMapper.map(userService.findUserById(id),UserDto.class);
        return ResponseEntity.ok(userDto);
    }
}
