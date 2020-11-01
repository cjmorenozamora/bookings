package cjmorenozamora.booking.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cjmorenozamora.booking.dtos.models.BookingDto;
import cjmorenozamora.booking.dtos.requests.BookingRequest;
import cjmorenozamora.booking.services.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService service;

	@PostMapping("/booking")
	public void createBooking(@Valid @RequestBody BookingRequest request) {

			service.createBooking(request.getHotel(), request.getEntryDate(), request.getExitDate(), request.getEmail());
		
	}

	@GetMapping("/bookings")
	public List<BookingDto> getBookings(@RequestParam(required = false) Integer hotel,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entryDate,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exitDate) {

		List<BookingDto> bookings = new ArrayList<BookingDto>();
		return bookings;
	}
	
	@GetMapping("/bookings/{bookingId}")
	public BookingDto getBooking(@NotNull(message = "Booking id is mandatory") @PathVariable Integer bookingId) {

		BookingDto booking = new BookingDto();
		
		booking = service.getBooking(bookingId);
		
		return booking;
		
	}
	
	@DeleteMapping("/bookings/{booking}")
	public void deleteBookings(@PathVariable Integer booking) {

	}

}
