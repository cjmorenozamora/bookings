package cjmorenozamora.booking.interfaces;

import java.util.List;

import cjmorenozamora.booking.dtos.models.HotelDto;

public interface HotelInterface {

	public List<HotelDto> findAll();
}
