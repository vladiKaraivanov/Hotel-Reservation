package bg.softuni.hotelreservation.room.service;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.repository.HotelRepository;
import bg.softuni.hotelreservation.room.model.Room;
import bg.softuni.hotelreservation.room.repository.RoomRepository;
import bg.softuni.hotelreservation.web.dto.RoomBindingModel;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

    public List<Room> findAllRoomInHotel(UUID hotelId) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        List<Room> rooms = new ArrayList<>();
        if (hotel.isPresent()) {
            rooms = roomRepository.findRoomByHotel_Id(hotel.get().getId());
        }
        return rooms;
    }

    public void addRoom(RoomBindingModel roomBindingModel, UUID hotelId) {
        Room room = modelMapper.map(roomBindingModel, Room.class);
        if(hotelRepository.findById(hotelId).isPresent()) {
            room.setHotel(hotelRepository.findById(hotelId).get());
        }
        roomRepository.save(room);
    }

    public void setAvailability(UUID roomId, boolean availability) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));
        room.setAvailable(availability);
        roomRepository.save(room);
    }

    public List<Room> findByHotelIdAndReservedFalse(UUID id) {
        List<Room> rooms = roomRepository.findFreeRoomsByHotelId(id);
        rooms = rooms.stream().filter(Room::getAvailable).toList();
        return rooms;
    }

    public List<Room> findByHotelIdAndReservedTrue(UUID id) {
        return roomRepository.findReservedRoomsByHotelId(id);

    }
}