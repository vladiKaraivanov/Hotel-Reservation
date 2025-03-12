package bg.softuni.hotelreservation.image.model;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import jakarta.persistence.*;

@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = true)
    private String imageUrl;
    @ManyToOne(fetch = FetchType.EAGER)
    private Hotel hotel;

    public Image() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
