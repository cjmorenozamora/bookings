package cjmorenozamora.booking.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjmorenozamora.booking.dtos.models.BookingDto;
import cjmorenozamora.booking.interfaces.BookingInterface;
import cjmorenozamora.booking.repositories.BookingRepository;

@Service
public class BookingService implements BookingInterface{

	@Autowired
	BookingRepository repository;

	@Override
	public void createBooking(Integer hotelId, LocalDate entryDate, LocalDate exitDate, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookingDto> getBookings(Integer hotelId, LocalDate entryDate, LocalDate exitDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDto getBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookings(Integer bookingId) {
		// TODO Auto-generated method stub
		
	}
}
