package cjmorenozamora.booking.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cjmorenozamora.booking.dtos.models.BookingDto;
import cjmorenozamora.booking.entities.Booking;
import cjmorenozamora.booking.entities.Hotel;
import cjmorenozamora.booking.interfaces.BookingInterface;
import cjmorenozamora.booking.repositories.AvailabilityRepository;
import cjmorenozamora.booking.repositories.BookingRepository;

@Service
public class BookingService implements BookingInterface {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	AvailabilityRepository availabilityRepository;

	@Override
	@Transactional
	public void createBooking(Integer hotelId, LocalDate entryDate, LocalDate exitDate, String email) {

		// primero tengo que ver si hay disponibilidad en ese hotel y en esas fechas, en
		// el caso de que haya proceder a realizar la reserva
		
		List<Hotel> hotels = availabilityRepository.findHotels(entryDate, entryDate);
		Boolean available= false;
		
		for (Hotel hotel : hotels) {
			if(hotel.getId() == hotelId) {
				available = true;
				break;
			}
			else {
				//no hay reservas
				throw new RuntimeException("No hay reservas");
			}
		}
		
		if(available) {
			Booking  booking = Booking.builder().hotelId(hotelId).dateFrom(entryDate).dateTo(exitDate).email(email).build();
			bookingRepository.save(booking);
			availabilityRepository.updateAvailability(entryDate, exitDate, hotelId);
		}	

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
