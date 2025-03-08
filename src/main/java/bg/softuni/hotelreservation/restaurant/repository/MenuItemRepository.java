package bg.softuni.hotelreservation.restaurant.repository;

import bg.softuni.hotelreservation.restaurant.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, String> {
}
