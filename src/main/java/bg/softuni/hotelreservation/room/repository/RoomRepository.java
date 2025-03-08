package bg.softuni.hotelreservation.room.repository;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.picture.model.Picture;
import bg.softuni.hotelreservation.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Picture, String> {
    List<Room> findRoomByHotelId_Id(String hotelId);
}
