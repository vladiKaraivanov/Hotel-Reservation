package bg.softuni.hotelreservation.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {
    @GetMapping("/test-security")
    public String testSecurity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "User: " + authentication.getName() + " | Roles: " + authentication.getAuthorities();
    }
}
