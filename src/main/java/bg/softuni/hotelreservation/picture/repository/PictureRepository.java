package bg.softuni.hotelreservation.picture.repository;

import bg.softuni.hotelreservation.picture.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture,String> {
}
