package bg.softuni.hotelreservation.hotel.service;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.model.HotelDto;
import bg.softuni.hotelreservation.hotel.repository.HotelRepository;
import bg.softuni.hotelreservation.web.dto.HotelBindingModel;
import bg.softuni.hotelreservation.web.dto.HotelViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    public HotelService(HotelRepository hotelRepository, ModelMapper modelMapper) {
        this.hotelRepository = hotelRepository;
        this.modelMapper = modelMapper;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public HotelViewModel findHotelById(String id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel == null) {
            return null;
        }
        return modelMapper.map(hotelRepository.findById(id), HotelViewModel.class);
    }

    public void saveChanges(String id, HotelBindingModel hotelBindingModel) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            hotel.setName(hotelBindingModel.getName());
            hotel.setAddress(hotelBindingModel.getAddress());
            hotel.setDescription(hotelBindingModel.getDescription());
            hotel.setRating(hotelBindingModel.getRating());

            hotelRepository.save(hotel);
        }
    }

    public void deleteActivateHotelById(String id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID"));
        hotel.setActive(!hotel.isActive());
        hotelRepository.save(hotel);
        }

    public String addNewHotel(HotelBindingModel hotelBindingModel) {
        Hotel hotel = modelMapper.map(hotelBindingModel, Hotel.class);
        hotel.setActive(true);
//        hotel.setRooms(new HashSet<>());
//        hotel.setPictures(new ArrayList<>());
        hotel = hotelRepository.save(hotel);
        return hotel.getId();
//        return (modelMapper.map(, HotelDto.class));
    }
}

