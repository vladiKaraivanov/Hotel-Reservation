package bg.softuni.hotelreservation.picture.model;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.room.model.Room;
import jakarta.persistence.*;

@Entity
@Table
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String pictureURL;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    private Hotel hotelId;

    public Picture() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }
  }
