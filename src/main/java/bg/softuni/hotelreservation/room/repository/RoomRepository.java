package bg.softuni.hotelreservation.room.repository;

import bg.softuni.hotelreservation.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findRoomByHotel_Id(String hotelId);

    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId AND r.reserved = false")
    List<Room> findFreeRoomsByHotelId(@Param("hotelId") String hotelId);

    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId AND r.reserved = true")
    List<Room> findReservedRoomsByHotelId(@Param("hotelId") String hotelId);

}
