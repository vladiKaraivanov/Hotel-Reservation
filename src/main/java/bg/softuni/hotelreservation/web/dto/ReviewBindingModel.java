package bg.softuni.hotelreservation.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class ReviewBindingModel {

    @Size(min = 5, max = 20, message = "Title must be between 5 and 20 chr.")
    private String title;
    private String content;
    @Min(value = 1)
    @Max(value = 5)
    private int rating;
    private UUID hotelID;

    public ReviewBindingModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public UUID getHotelID() {
        return hotelID;
    }

    public void setHotelID(UUID hotelID) {
        this.hotelID = hotelID;
    }
}
