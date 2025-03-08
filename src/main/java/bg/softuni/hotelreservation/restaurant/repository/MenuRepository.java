package bg.softuni.hotelreservation.restaurant.repository;

import bg.softuni.hotelreservation.restaurant.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {
}
