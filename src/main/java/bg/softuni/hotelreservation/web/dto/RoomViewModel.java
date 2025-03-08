package bg.softuni.hotelreservation.web.dto;

import java.math.BigDecimal;

public class RoomViewModel {
    private String roomType;
    private BigDecimal pricePerNight;

    public RoomViewModel(String roomType, BigDecimal pricePerNight) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomType() {
        return roomType;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }
}
