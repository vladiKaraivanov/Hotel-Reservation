package bg.softuni.hotelreservation.hotel.repository;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {
    @Query("SELECT h FROM Hotel h WHERE h.active = true")
    List<Hotel> findAllActiveHotels();
}
