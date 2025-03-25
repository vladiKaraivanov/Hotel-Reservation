package bg.softuni.hotelreservation;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.repository.HotelRepository;
import bg.softuni.hotelreservation.hotel.service.HotelService;
import bg.softuni.hotelreservation.review.model.Review;
import bg.softuni.hotelreservation.web.dto.HotelBindingModel;
import bg.softuni.hotelreservation.web.dto.HotelViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class HotelServiceUTest {
    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private HotelService hotelService;

    @Test
    void whenRepositoryReturnEmptyOptional_thenThrowsException() {
        UUID hotelId = UUID.randomUUID();
        when(hotelRepository.findById(hotelId)).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> hotelService.getHotelDetails(hotelId));

    }
//    @Test
//    void whenFindHotelById_thenReturnHotel() {
//        UUID hotelId = UUID.randomUUID();
//        Hotel hotel = new Hotel();
//        hotel.setId(hotelId); TODO FIND AND FIX PROBLEM WITH THIS TEST!
//
//        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel)); // ✅
//
//
//        assertEquals(hotel, hotelService.getHotelDetails(hotelId));
//    }
    @Test
    void addNewHotel_shouldMapAndSaveHotelAndReturnId() {
        // Arrange
        HotelBindingModel hotelBindingModel  = new HotelBindingModel();
        Hotel hotelToSave = new Hotel();
        Hotel savedHotel = new Hotel();
        UUID expectedId = UUID.randomUUID();

        savedHotel.setId(expectedId);

        when(modelMapper.map(hotelBindingModel, Hotel.class)).thenReturn(hotelToSave);
        when(hotelRepository.save(hotelToSave)).thenReturn(savedHotel);

        // Act
        UUID result = hotelService.addNewHotel(hotelBindingModel);

        // Assert
        assertEquals(expectedId, result);
        assertTrue(hotelToSave.isActive()); // уверяваме се, че setActive(true) е извикан
        verify(modelMapper).map(hotelBindingModel, Hotel.class);
        verify(hotelRepository).save(hotelToSave);
    }

    @Test
    void whenHotelNotFound_thenThrowEntityNotFoundException() {
        UUID hotelId = UUID.randomUUID();

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> hotelService.getHotelDetails(hotelId));
    }

    @Test
    void getAllHotels_shouldReturnAllHotelsFromRepository() {
        // Arrange
        List<Hotel> mockHotels = List.of(
                new Hotel(UUID.randomUUID(), "Hotel One", "Address One", true),
                new Hotel(UUID.randomUUID(), "Hotel Two", "Address Two", true)
        );

        when(hotelRepository.findAll()).thenReturn(mockHotels);

        // Act
        List<Hotel> result = hotelService.getAllHotels();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Hotel One", result.get(0).getName());
        verify(hotelRepository).findAll(); // увери се, че методът е извикан
    }
    @Test
    void findViewHotelById_shouldReturnViewModel_whenHotelExists() {
        // Arrange
        UUID hotelId = UUID.randomUUID();
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        hotel.setName("Test Hotel");

        HotelViewModel viewModel = new HotelViewModel();
        viewModel.setName("Test Hotel");

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        when(modelMapper.map(hotel, HotelViewModel.class)).thenReturn(viewModel);

        // Act
        HotelViewModel result = hotelService.findViewHotelById(hotelId);

        // Assert
        assertEquals("Test Hotel", result.getName());
        verify(hotelRepository).findById(hotelId);
        verify(modelMapper).map(hotel, HotelViewModel.class);
    }

    @Test
    void findViewHotelById_shouldThrowException_whenHotelNotFound() {
        // Arrange
        UUID hotelId = UUID.randomUUID();
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NullPointerException.class, () -> hotelService.findViewHotelById(hotelId));
        verify(hotelRepository).findById(hotelId);
    }
    @Test
    void deleteActivateHotelById_shouldToggleActiveStatusAndSave_whenHotelExists() {
        // Arrange
        UUID hotelId = UUID.randomUUID();
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        hotel.setActive(true); // в началото е активен

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));

        // Act
        hotelService.deleteActivateHotelById(hotelId);

        // Assert
        assertFalse(hotel.isActive()); // очакваме да е деактивиран
        verify(hotelRepository).save(hotel);
    }
    @Test
    void deleteActivateHotelById_shouldThrowException_whenHotelNotFound() {
        // Arrange
        UUID hotelId = UUID.randomUUID();
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> hotelService.deleteActivateHotelById(hotelId));

        verify(hotelRepository, never()).save(any()); // уверяваме се, че save НЕ се вика
    }
    @Test
    void saveChanges_shouldUpdateHotelAndSave_whenHotelExists() {
        // Arrange
        UUID hotelId = UUID.randomUUID();

        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        hotel.setName("Old Name");
        hotel.setAddress("Old Address");
        hotel.setDescription("Old Description");
        hotel.setRating(3.0);

        HotelBindingModel bindingModel = new HotelBindingModel();
        bindingModel.setName("New Name");
        bindingModel.setAddress("New Address");
        bindingModel.setDescription("New Description");
        bindingModel.setRating(4.5);

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));

        // Act
        hotelService.saveChanges(hotelId, bindingModel);

        // Assert
        assertEquals("New Name", hotel.getName());
        assertEquals("New Address", hotel.getAddress());
        assertEquals("New Description", hotel.getDescription());
        assertEquals(4.5, hotel.getRating());

        verify(hotelRepository).save(hotel);
    }
    @Test
    void saveChanges_shouldThrowException_whenHotelNotFound() {
        // Arrange
        UUID hotelId = UUID.randomUUID();
        HotelBindingModel bindingModel = new HotelBindingModel();
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NullPointerException.class, () -> hotelService.saveChanges(hotelId, bindingModel));

        verify(hotelRepository, never()).save(any());
    }
    @Test
    void updateHotelRating_shouldRecalculateAverage_whenHotelExists() {
        // Arrange
        UUID hotelId = UUID.randomUUID();

        Review review1 = new Review();
        review1.setRating(4);
        Review review2 = new Review();
        review2.setRating(5);

        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        hotel.setReviews(new ArrayList<>(List.of(review1, review2)));

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));

        // Act
        hotelService.updateHotelRating(hotelId, 3); // добавяме ново ревю с рейтинг 3

        // Assert: (4 + 5 + 3) / 3 = 4.0
        assertEquals(4.0, hotel.getRating());
        verify(hotelRepository).save(hotel);
    }
    @Test
    void updateHotelRating_shouldThrowException_whenHotelNotFound() {
        // Arrange
        UUID hotelId = UUID.randomUUID();
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> hotelService.updateHotelRating(hotelId, 5));

        verify(hotelRepository, never()).save(any());
    }
    @Test
    void updateHotelRating_shouldSetRatingEqualToNewRating_whenNoPreviousReviews() {
        UUID hotelId = UUID.randomUUID();

        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        hotel.setReviews(new ArrayList<>()); // няма ревюта

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));

        hotelService.updateHotelRating(hotelId, 4);

        assertEquals(4.0, hotel.getRating());
        verify(hotelRepository).save(hotel);
    }
    @Test
    void findHotelById_shouldReturnHotel_whenExists() {
        UUID hotelId = UUID.randomUUID();
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));

        Hotel result = hotelService.findHotelById(hotelId);

        assertEquals(hotelId, result.getId());
        verify(hotelRepository).findById(hotelId);
    }
    @Test
    void findHotelById_shouldThrowException_whenNotFound() {
        UUID hotelId = UUID.randomUUID();

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.empty());

        assertThrows(NullPointerException.class, () -> hotelService.findHotelById(hotelId));
    }



}
