package cjmorenozamora.booking.interfaces;

import java.time.LocalDate;
import java.util.List;

import cjmorenozamora.booking.dtos.models.HotelDto;

public interface AvailabilityService {

	public void createAvailability(Integer hotelId, LocalDate entryDate, LocalDate exitDate, Integer rooms);
	
	public List<HotelDto> getAvailability(LocalDate entryDate, LocalDate exitDate);
}
