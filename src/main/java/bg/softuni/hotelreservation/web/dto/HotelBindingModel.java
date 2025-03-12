package bg.softuni.hotelreservation.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class HotelBindingModel {
    @Size(min = 5, max = 50, message = "Hotel name must be at least 5 characters.")
    private String name;
    @Size(min = 5, max = 50, message = "Address must be at least 5 characters.")
    private String address;
    @Size(min = 10, max = 1000, message = "Description must be at least 10 characters.")
    private String description;
    @Min(value = 1, message = "Rating must be min 1.")
    private Double rating;
    private MultipartFile image;;

    public HotelBindingModel() {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
