package bg.softuni.hotelreservation.room.repository;

import bg.softuni.hotelreservation.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
    List<Room> findRoomByHotel_Id(UUID hotelId);

    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId AND r.reserved = false")
    List<Room> findFreeRoomsByHotelId(@Param("hotelId") UUID hotelId);

    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId AND r.reserved = true")
    List<Room> findReservedRoomsByHotelId(@Param("hotelId") UUID hotelId);

}
