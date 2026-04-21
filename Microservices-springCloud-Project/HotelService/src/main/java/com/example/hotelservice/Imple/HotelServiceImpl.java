package com.example.hotelservice.Imple;

import com.example.hotelservice.entity.Hotel;
import com.example.hotelservice.exception.ResourceNotFoundException;
import com.example.hotelservice.repo.HotelRepo;
import com.example.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;
    @Override
    public Hotel createHotel(Hotel hotel) {
        UUID uuid=UUID.randomUUID();
        hotel.setHotelId(uuid.toString());
        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id is not found "));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }
}
