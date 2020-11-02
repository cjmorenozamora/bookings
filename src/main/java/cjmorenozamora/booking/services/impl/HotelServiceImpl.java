package cjmorenozamora.booking.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.entities.Hotel;
import cjmorenozamora.booking.repositories.HotelRepository;
import cjmorenozamora.booking.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository repository;

	@Override
	public List<HotelDto> findAll() {
		List<Hotel> hotels = repository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		List<HotelDto> hotelsRest = new ArrayList<>();

		hotels.forEach(hotel -> hotelsRest.add(modelMapper.map(hotel, HotelDto.class)));
		return hotelsRest;
	}

}
