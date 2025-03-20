package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.user.model.User;
import bg.softuni.hotelreservation.user.service.UserService;
import bg.softuni.hotelreservation.web.dto.UserBindingModel;
import bg.softuni.hotelreservation.web.dto.UserViewModel;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminUserController {
    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/manage/users")
    public String manageUsers(@RequestParam(value = "username", required = false) String username, Model model) {
        UserBindingModel manageUser;
        if (username != null) {
            UserViewModel userViewModel = userService.findUserByUsername(username);
            manageUser = userService.convertToBindingModel(userViewModel);
        } else {
            manageUser = new UserBindingModel(); // Ако няма избран потребител
        }

        model.addAttribute("manageUser", manageUser);
        return "admin/users"; // Връща Thymeleaf страницата с попълнени данни
    }



    @PostMapping("/manage/users")
    public String manageUser(@Valid UserBindingModel manageUser,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("manageUser", manageUser);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.manageUser", bindingResult);
            return "redirect:/admin/manage/users";
        }

        userService.manageUser(manageUser);
        return "redirect:/admin/manage/users?username=" + manageUser.getUsername();
    }
    @ModelAttribute("userViewModels")
    public List<UserViewModel> userViewModels() {
        return new ArrayList<>(userService.getAllUsers());
    }
    @ModelAttribute("userBinding")
    public UserBindingModel manageUser() {
        return new UserBindingModel();
    }

}
