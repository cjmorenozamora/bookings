package cjmorenozamora.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjmorenozamora.booking.entities.Hotel;
import cjmorenozamora.booking.repositories.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository repository;
	
	public List<cjmorenozamora.booking.dtos.models.Hotel> findAll(){
		List<Hotel> hotels = repository.findAll();
		ModelMapper modelMapper = new ModelMapper(); 
		List<cjmorenozamora.booking.dtos.models.Hotel> hotelsRest = new ArrayList<>();
	
		hotels.forEach(hotel -> hotelsRest.add(modelMapper.map(hotel,  cjmorenozamora.booking.dtos.models.Hotel.class)));
		return hotelsRest;
	}
	
}
