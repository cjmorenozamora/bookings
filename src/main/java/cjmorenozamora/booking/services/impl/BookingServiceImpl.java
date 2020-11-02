package cjmorenozamora.booking.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cjmorenozamora.booking.dtos.models.BookingDto;
import cjmorenozamora.booking.entities.Booking;
import cjmorenozamora.booking.entities.Hotel;
import cjmorenozamora.booking.mappers.MapperBooking;
import cjmorenozamora.booking.repositories.AvailabilityRepository;
import cjmorenozamora.booking.repositories.BookingRepository;
import cjmorenozamora.booking.services.BookingService;
import cjmorenozamora.booking.specifications.GetBookingsSpecifications;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	AvailabilityRepository availabilityRepository;

	@Autowired
	MapperBooking mapperBooking;

	@Override
	@Transactional
	public void createBooking(Integer hotelId, LocalDate entryDate, LocalDate exitDate, String email) {

		// primero tengo que ver si hay disponibilidad en ese hotel y en esas fechas, en
		// el caso de que haya proceder a realizar la reserva

		List<Hotel> hotels = availabilityRepository.findHotels(entryDate, entryDate);
		Boolean available = false;

		Iterator<Hotel> it = hotels.iterator();
		
		while(it.hasNext() && available == false) {
			
			if(it.next().getId() == hotelId) {
				available=true;
			}
		}

		if (available) {
			Booking booking = Booking.builder().hotelId(hotelId).dateFrom(entryDate).dateTo(exitDate).email(email)
					.build();
			bookingRepository.save(booking);
			availabilityRepository.updateAvailability(entryDate, exitDate, hotelId);
		}else {
			throw new RuntimeException("No hay reservas");
		}

	}

	@Override
	public List<BookingDto> getBookings(Integer hotelId, LocalDate entryDate, LocalDate exitDate) {

		List<Specification<Booking>> specifications = new ArrayList<>();
		List<Booking> bookingList = new ArrayList<>();
		List<BookingDto> bookingDtoList = new ArrayList<BookingDto>();
		Specification<Booking> specification = null;

		if (hotelId == null && entryDate == null && exitDate == null) {
			
			bookingList = bookingRepository.findAll();
			
		} else {

			if (hotelId != null) {

				specifications.add(GetBookingsSpecifications.containsHotel(hotelId));

			}
			if (entryDate != null) {

				specifications.add(GetBookingsSpecifications.containsDateFrom(entryDate));

			}
			if (exitDate != null) {

				specifications.add(GetBookingsSpecifications.containsDateTo(exitDate));

			}

			Iterator<Specification<Booking>> it = specifications.iterator();
			specification = it.next();
			while (it.hasNext()) {
				specification = Specification.where(specification).and(it.next());
			}

			bookingList = bookingRepository.findAll(specification);

		}

		for (Booking booking : bookingList) {
			BookingDto bookingDto = mapperBooking.mapperBooking(booking);
			bookingDtoList.add(bookingDto);
		}

		return bookingDtoList;
	}

	@Override
	public BookingDto getBooking(Integer bookingId) {

		Booking booking = bookingRepository.findById(bookingId).get();
		return mapperBooking.mapperBooking(booking);
	}

	@Override
	@Transactional
	public void deleteBookings(Integer bookingId) {
		

		Booking booking = bookingRepository.findById(bookingId).get();

		bookingRepository.deleteById(bookingId);
		
		availabilityRepository.updateAvailabilityAddRooms(booking.getDateFrom(), booking.getDateTo(), booking.getHotelId());

	}
}
