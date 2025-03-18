package bg.softuni.hotelreservation.room.model;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Enumerated(EnumType.STRING)
    private RoomTypeEnum roomType;
    @Column()
    private int roomNumber;
    @Column(nullable = false)
    private BigDecimal pricePerNight;
    @Column()
    private Boolean available;
    @Column()
    private Boolean reserved;

    public Room() {
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

}
