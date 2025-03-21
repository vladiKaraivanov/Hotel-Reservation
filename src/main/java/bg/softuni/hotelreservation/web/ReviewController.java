package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.review.model.Review;
import bg.softuni.hotelreservation.security.AuthenticationDetails;
import bg.softuni.hotelreservation.web.dto.ReviewBindingModel;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/hotels/reviews")
public class ReviewController {


//    @GetMapping("/add")
//    public String addReview(Review review) {
//        return "/hotels/hotel-details";
//    }
    @PostMapping("/add/")
     String addReview(@Valid @ModelAttribute("reviewBinding")  ReviewBindingModel reviewBinding, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, @AuthenticationPrincipal AuthenticationDetails userDetails) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("reviewBinding", reviewBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.reviewBinding", bindingResult);
            return "redirect:/hotels/reviews/add";
        }
        UUID userId = userDetails.getId();
        UUID hotelId = reviewBinding.getHotelID();

        //TODO Create functionality to send new review to reviewService

        //reviewBinding  is added as model attribute in HotelController
        // HotelID is set in HotelController to reviewBinding
        return "redirect:/hotels/reviews";
    }

}
