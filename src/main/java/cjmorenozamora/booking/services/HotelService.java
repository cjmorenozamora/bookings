package cjmorenozamora.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.entities.Hotel;
import cjmorenozamora.booking.interfaces.HotelInterface;
import cjmorenozamora.booking.repositories.HotelRepository;

@Service
public class HotelService implements HotelInterface{

	@Autowired
	HotelRepository repository;

	@Override
	public List<HotelDto> findAll() {
		List<Hotel> hotels = repository.findAll();
		ModelMapper modelMapper = new ModelMapper(); 
		List<cjmorenozamora.booking.dtos.models.HotelDto> hotelsRest = new ArrayList<>();
	
		hotels.forEach(hotel -> hotelsRest.add(modelMapper.map(hotel,  cjmorenozamora.booking.dtos.models.HotelDto.class)));
		return hotelsRest;
	}
	
}
