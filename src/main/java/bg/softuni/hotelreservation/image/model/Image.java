package bg.softuni.hotelreservation.image.model;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = true)
    private String imageUrl;
    @ManyToOne(fetch = FetchType.EAGER)
    private Hotel hotel;

    public Image() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotelId) {
        this.hotel = hotelId;
    }
  }
