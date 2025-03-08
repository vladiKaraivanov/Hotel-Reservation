package bg.softuni.hotelreservation.reservation.service;

import bg.softuni.hotelreservation.reservation.model.Reservation;
import bg.softuni.hotelreservation.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
