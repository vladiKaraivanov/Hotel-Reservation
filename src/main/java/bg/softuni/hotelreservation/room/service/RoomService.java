package bg.softuni.hotelreservation.room.service;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.repository.HotelRepository;
import bg.softuni.hotelreservation.room.model.Room;
import bg.softuni.hotelreservation.room.repository.RoomRepository;
import bg.softuni.hotelreservation.web.dto.RoomBindingModel;
import bg.softuni.hotelreservation.web.dto.RoomViewModel;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository, ModelMapper modelMapper) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.modelMapper = modelMapper;
    }

    public List<Room> findAllRoomInHotel(String hotelId) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        List<Room> rooms = new ArrayList<>();
        if (hotel.isPresent()) {
            rooms = roomRepository.findRoomByHotelId_Id(hotel.get().getId());
        }
        return rooms;
    }

    public void addRoom(RoomBindingModel roomBindingModel, String hotelId) {
        Room room = modelMapper.map(roomBindingModel, Room.class);
        if(hotelRepository.findById(hotelId).isPresent()) {
            room.setHotelId(hotelRepository.findById(hotelId).get());
        }
        roomRepository.save(room);
    }

    public void setAvailability(String roomId, boolean availability) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));
        room.setAvailable(availability);
        roomRepository.save(room);
    }
}