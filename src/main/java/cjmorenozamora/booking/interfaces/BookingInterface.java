package cjmorenozamora.booking.interfaces;

import java.time.LocalDate;
import java.util.List;

import cjmorenozamora.booking.dtos.models.BookingDto;

public interface BookingInterface {
	
	public void createBooking(Integer hotelId, LocalDate entryDate, LocalDate exitDate, String email);
	
	public List<BookingDto> getBookings(Integer hotelId, LocalDate entryDate, LocalDate exitDate);
	
	public BookingDto getBooking(Integer bookingId);
	
	public void deleteBookings(Integer bookingId);

}
