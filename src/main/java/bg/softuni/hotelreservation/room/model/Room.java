package bg.softuni.hotelreservation.room.model;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.picture.model.Picture;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotelId;
    @Enumerated(EnumType.STRING)
    private RoomTypeEnum roomType;
    @Column
    private int roomNumber;
    @Column(nullable = false)
    private BigDecimal pricePerNight;
    @Column()
    private Boolean available;

    public Room() {
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    public RoomTypeEnum getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEnum roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
