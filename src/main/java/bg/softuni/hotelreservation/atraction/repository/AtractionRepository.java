package bg.softuni.hotelreservation.atraction.repository;

import bg.softuni.hotelreservation.atraction.model.Atraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtractionRepository extends JpaRepository<Atraction, String> {
}
