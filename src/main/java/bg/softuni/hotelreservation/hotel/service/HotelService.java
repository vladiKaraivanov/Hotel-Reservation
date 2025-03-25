package bg.softuni.hotelreservation.hotel.service;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.repository.HotelRepository;
import bg.softuni.hotelreservation.reservation.model.Reservation;
import bg.softuni.hotelreservation.reservation.repository.ReservationRepository;
import bg.softuni.hotelreservation.review.model.Review;
import bg.softuni.hotelreservation.user.model.User;
import bg.softuni.hotelreservation.user.repository.UserRepository;
import bg.softuni.hotelreservation.web.dto.HotelBindingModel;
import bg.softuni.hotelreservation.web.dto.HotelDetailsViewModel;
import bg.softuni.hotelreservation.web.dto.HotelViewModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
//    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;
//    private final UserRepository userRepository;

    public HotelService(HotelRepository hotelRepository, ModelMapper modelMapper) {
        this.hotelRepository = hotelRepository;
//        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
//        this.userRepository = userRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public HotelViewModel findViewHotelById(UUID id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new NullPointerException("Hotel not found"));

        return modelMapper.map(hotel, HotelViewModel.class);
    }


    public void saveChanges(UUID id, HotelBindingModel hotelBindingModel) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new NullPointerException("Hotel not found"));

            hotel.setName(hotelBindingModel.getName());
            hotel.setAddress(hotelBindingModel.getAddress());
            hotel.setDescription(hotelBindingModel.getDescription());
            hotel.setRating(hotelBindingModel.getRating());

            hotelRepository.save(hotel);
    }

    public void deleteActivateHotelById(UUID id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID"));
        hotel.setActive(!hotel.isActive());
        hotelRepository.save(hotel);
    }

    public UUID addNewHotel(HotelBindingModel hotelBindingModel) {
        Hotel hotel = modelMapper.map(hotelBindingModel, Hotel.class);
        hotel.setActive(true);
        hotel = hotelRepository.save(hotel);
        return hotel.getId();
    }

    public HotelDetailsViewModel getHotelDetails(UUID id) {
        Hotel hotel = hotelRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID"));
        if (hotel == null) {
            return null;
        }
        return (modelMapper.map(hotel, HotelDetailsViewModel.class));
    }



    public Hotel findHotelById(UUID hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new NullPointerException("Hotel not found"));
    }
    public void updateHotelRating(UUID hotelId, Integer newRating) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID"));
//        Integer oldRating = hotel.getRating().intValue();
        List<Integer> ratings = hotel.getReviews().stream().map(Review::getRating).collect(Collectors.toList());

        ratings.add(newRating);  // предполага се, че вече е добавено новото ревю с рейтинга
        double averageRating = ratings.stream()  // Стартира поток от списъка с рейтинги
                .mapToDouble(Integer::doubleValue)  // Конвертира Integer в double
                .average()                          // Изчислява средно аритметичното
                .orElse(0.0);
        hotel.setRating(averageRating);
        hotelRepository.save(hotel);
    }

//        public void createReservation(UUID hotelId, String username, LocalDate checkInDate, LocalDate checkOutDate) {
//        Hotel hotel = hotelRepository.findById(hotelId)
//                .orElseThrow(() -> new RuntimeException("Hotel not found"));
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        Reservation reservation = new Reservation();
//        reservation.setHotel(hotel);
//        reservation.setUserId(user);
//        reservation.setCheckInDate(checkInDate);
//        reservation.setCheckOutDate(checkOutDate); TODO RESERVATION WILL BE IN REST API
//
//        reservationRepository.save(reservation);
//    }
}

