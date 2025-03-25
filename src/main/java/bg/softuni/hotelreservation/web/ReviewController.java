package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.review.model.Review;
import bg.softuni.hotelreservation.review.service.ReviewService;
import bg.softuni.hotelreservation.security.AuthenticationDetails;
import bg.softuni.hotelreservation.web.dto.ReviewBindingModel;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping("/add")
     String addReview(@Valid @ModelAttribute("reviewBinding")  ReviewBindingModel reviewBinding, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, @AuthenticationPrincipal AuthenticationDetails userDetails) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("reviewBinding", reviewBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.reviewBinding", bindingResult);
            UUID hotelId = reviewBinding.getHotelID();
//            return "redirect:/hotels/reviews/add";
            return "redirect:/hotels/" + hotelId + "/details";

        }
        UUID userId = userDetails.getId();
        UUID hotelId = reviewBinding.getHotelID();
        reviewService.addReview(reviewBinding, userId);


        //reviewBinding  is added as model attribute in HotelController
        // HotelID is set in HotelController to reviewBinding
        return "redirect:/hotels/" + hotelId + "/details";
    }

}
