package bg.softuni.hotelreservation.review.service;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.service.HotelService;
import bg.softuni.hotelreservation.review.model.Review;
import bg.softuni.hotelreservation.review.repository.ReviewRepository;
import bg.softuni.hotelreservation.user.service.UserService;
import bg.softuni.hotelreservation.web.dto.ReviewBindingModel;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final HotelService hotelService;
    private final ModelMapper modelMapper;

    public ReviewService(ReviewRepository reviewRepository, UserService userService, HotelService hotelService, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
        this.hotelService = hotelService;
        this.modelMapper = modelMapper;
    }
    public void addReview(ReviewBindingModel reviewBinding, UUID userId) {
        Review review = new Review();
        review.setContent(reviewBinding.getContent());
        review.setTitle(reviewBinding.getTitle());
        Hotel hotel = hotelService.findHotelById(reviewBinding.getHotelID());
        review.setHotel(hotel);
        review.setAuthor(userService.findUserById(userId));
//        review.setHotel(hotelService.findHotelById(hotelId));
        review.setRating(reviewBinding.getRating());
        review.setDateOfReview(LocalDate.now());
        hotelService.updateHotelRating(reviewBinding.getHotelID(), review.getRating());
        reviewRepository.save(review);
    }
}
