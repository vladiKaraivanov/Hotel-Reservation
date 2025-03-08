package bg.softuni.hotelreservation.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    @NotNull(message = "Username is required.")
    private String username;
    @Email(message = "Enter valid email.")
    @NotNull(message = "Email is required.")
    private String email;
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    @NotNull(message = "Oops! You forgot to enter a password.")
    private String password;
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    @NotNull(message = "Oops! You forgot to enter a confirm password.")
    private String confirmPassword;

    public UserRegisterBindingModel() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
