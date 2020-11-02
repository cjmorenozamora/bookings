package cjmorenozamora.booking.services;

import java.util.List;

import cjmorenozamora.booking.dtos.models.HotelDto;

public interface HotelService {

	public List<HotelDto> findAll();
}
