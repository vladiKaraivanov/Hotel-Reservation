package bg.softuni.hotelreservation.hotel.model;

import bg.softuni.hotelreservation.picture.model.Picture;
import bg.softuni.hotelreservation.room.model.Room;

import java.util.List;
import java.util.Set;

public class HotelDto {
    private String id;
    private String name;
    private String address;
    private String description;
    private Double rating;
    private boolean active;
//    private List<Picture> pictures;
//    private Set<Room> rooms;

    public HotelDto() {
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

//    public List<Picture> getPictures() {
//        return pictures;
//    }
//
//    public void setPictures(List<Picture> pictures) {
//        this.pictures = pictures;
//    }
//
//    public Set<Room> getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(Set<Room> rooms) {
//        this.rooms = rooms;
//    }
}
