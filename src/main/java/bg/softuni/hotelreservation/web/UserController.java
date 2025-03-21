package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.user.model.UserRegisterDto;
import bg.softuni.hotelreservation.user.service.UserService;
import bg.softuni.hotelreservation.web.dto.UserAdditionalInformationBindingModel;
import bg.softuni.hotelreservation.web.dto.UserRegisterBindingModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:/users/register";
        }
        UserRegisterDto newUser = userService.registerUser(userRegisterBindingModel);
        if (newUser == null) {
            redirectAttributes.addFlashAttribute("exist", "You have already registered");
            return "redirect:/users/login";

        }

        String newUsername = newUser.getUsername();

        redirectAttributes.addAttribute("registeredUsername", newUsername);
        return "redirect:/users/profile";
    }

    @GetMapping("/profile")
    public String profile(@RequestParam(value = "registeredUsername", required = false) String registeredUsername, Model model) {
//        System.out.println("Received username in /profile GET: " + registeredUsername);
        model.addAttribute("registeredUsername", registeredUsername); // Запазваме го за Thymeleaf
        return "/personal-information";
    }

    @PostMapping("/profile")
    public String addPersonalInformation(@Valid UserAdditionalInformationBindingModel userAdditionalInformationBindingModel,
                                         BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                         @RequestParam(value = "registeredUsername", required = false) String registeredUsername) {

//        System.out.println("Received username in /profile POST: " + registeredUsername); // ✅ Проверка в конзолата

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userAdditionalInformationBindingModel", userAdditionalInformationBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userAdditionalInformationBindingModel", bindingResult);
            return "redirect:/users/profile?registeredUsername=" +  registeredUsername;
        }

//        System.out.println("Received username in /profile POST: " + registeredUsername);

        userService.addProfileInformation(userAdditionalInformationBindingModel, registeredUsername);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String ErrorParam, Model model) {
        if (ErrorParam != null) {
            model.addAttribute("errorMessage", "Invalid username or password");
        }
        return "login";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserAdditionalInformationBindingModel userAdditionalInformationBindingModel() {
        return new UserAdditionalInformationBindingModel();
    }
}
