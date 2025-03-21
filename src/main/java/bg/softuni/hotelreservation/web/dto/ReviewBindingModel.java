package bg.softuni.hotelreservation.web.dto;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.user.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public class ReviewBindingModel {
    @NotNull
    private String title;
    @NotNull
    private String content;
    @Min(value = 1)
    @Max(value = 5)
    private int rating;
    @NotNull
    private User author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfReview;
    @NotNull
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDate getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(LocalDate dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public UUID getHotelID() {
        return hotelID;
    }

    public void setHotelID(UUID hotelID) {
        this.hotelID = hotelID;
    }
}
