package cjmorenozamora.booking.services;

import java.time.LocalDate;
import java.util.List;

import cjmorenozamora.booking.dtos.models.BookingDto;

public interface BookingService {
	
	public void createBooking(Integer hotelId, LocalDate entryDate, LocalDate exitDate, String email);
	
	public List<BookingDto> getBookings(Integer hotelId, LocalDate entryDate, LocalDate exitDate);
	
	public BookingDto getBooking(Integer bookingId);
	
	public void deleteBookings(Integer bookingId);

}
