package bg.softuni.hotelreservation.web.dto;

import bg.softuni.hotelreservation.room.model.RoomTypeEnum;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public class RoomBindingModel {
   private RoomTypeEnum roomType;

    private int roomNumber;

    private BigDecimal pricePerNight;

    private Boolean available;

    public RoomBindingModel() {
    }

    public RoomTypeEnum getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEnum roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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
