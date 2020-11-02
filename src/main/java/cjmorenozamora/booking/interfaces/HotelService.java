package cjmorenozamora.booking.interfaces;

import java.util.List;

import cjmorenozamora.booking.dtos.models.HotelDto;

public interface HotelService {

	public List<HotelDto> findAll();
}
