package bg.softuni.hotelreservation.web.dto;

import bg.softuni.hotelreservation.image.model.Image;
import bg.softuni.hotelreservation.room.model.Room;

import java.util.List;
import java.util.UUID;

public class HotelDetailsViewModel {
    private UUID id;
    private String name;
    private String address;
    private String description;
    private List<Room> rooms;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    private List<Image> images;

    public HotelDetailsViewModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
