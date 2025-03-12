package bg.softuni.hotelreservation.hotel.model;

import bg.softuni.hotelreservation.image.model.Image;
import bg.softuni.hotelreservation.room.model.Room;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String address;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private Double rating;
    @Column(nullable = false)
    private boolean active;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Image> images;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "hotelId")
    private Set<Room> rooms;

    public Hotel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> pictures) {
        this.images = pictures;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
