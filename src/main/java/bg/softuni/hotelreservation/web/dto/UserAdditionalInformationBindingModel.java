package bg.softuni.hotelreservation.web.dto;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class UserAdditionalInformationBindingModel {
    @Size(min = 3, max = 20, message = "First name length must be between 3 and 20 chr.")
    private String firstName;
    @Size(min = 3, max = 20, message = "Last name length must be between 3 and 20 chr.")
    private String lastName;
    @PastOrPresent(message = "Date must be in past or presents")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private List<String> interests;

    public UserAdditionalInformationBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
