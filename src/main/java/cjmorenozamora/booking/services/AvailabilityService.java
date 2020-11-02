package cjmorenozamora.booking.services;

import java.time.LocalDate;
import java.util.List;

import cjmorenozamora.booking.dtos.models.HotelDto;
/**
 * 
 * @author cjmoreno
 *
 */
public interface AvailabilityService {

	/**
	 * 
	 * @param hotelId
	 * @param entryDate
	 * @param exitDate
	 * @param rooms
	 */
	public void createAvailability(Integer hotelId, LocalDate entryDate, LocalDate exitDate, Integer rooms);
	/**
	 * 
	 * @param entryDate
	 * @param exitDate
	 * @return
	 */
	public List<HotelDto> getAvailability(LocalDate entryDate, LocalDate exitDate);
}
