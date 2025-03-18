package bg.softuni.hotelreservation.hotel.service;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.repository.HotelRepository;
import bg.softuni.hotelreservation.reservation.model.Reservation;
import bg.softuni.hotelreservation.reservation.repository.ReservationRepository;
import bg.softuni.hotelreservation.reservation.service.ReservationService;
import bg.softuni.hotelreservation.user.model.User;
import bg.softuni.hotelreservation.user.repository.UserRepository;
import bg.softuni.hotelreservation.web.dto.HotelBindingModel;
import bg.softuni.hotelreservation.web.dto.HotelDetailsViewModel;
import bg.softuni.hotelreservation.web.dto.HotelViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public HotelService(HotelRepository hotelRepository, ReservationRepository reservationRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public HotelViewModel findHotelById(UUID id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel == null) {
            return null;
        }
        return modelMapper.map(hotelRepository.findById(id), HotelViewModel.class);
    }

    public void saveChanges(UUID id, HotelBindingModel hotelBindingModel) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            hotel.setName(hotelBindingModel.getName());
            hotel.setAddress(hotelBindingModel.getAddress());
            hotel.setDescription(hotelBindingModel.getDescription());
            hotel.setRating(hotelBindingModel.getRating());

            hotelRepository.save(hotel);
        }
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
//        hotel.setRooms(new HashSet<>());
//        hotel.setPictures(new ArrayList<>());
        hotel = hotelRepository.save(hotel);
        return hotel.getId();
//        return (modelMapper.map(, HotelDto.class));
    }

    public HotelDetailsViewModel getHotelDetails(UUID id) {
        Hotel hotel = hotelRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID"));
        if (hotel == null) {
            return null;
        }
        return (modelMapper.map(hotel, HotelDetailsViewModel.class));
    }

    public void createReservation(UUID hotelId, String username, LocalDate checkInDate, LocalDate checkOutDate) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Reservation reservation = new Reservation();
        reservation.setHotel(hotel);
        reservation.setUserId(user);
        reservation.setCheckInDate(checkInDate);
        reservation.setCheckOutDate(checkOutDate);

        reservationRepository.save(reservation);
    }
}

