package cjmorenozamora.booking.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cjmorenozamora.booking.dtos.models.Booking;
import cjmorenozamora.booking.dtos.requests.BookingRequest;
import cjmorenozamora.booking.services.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService service;

	@PostMapping("/booking")
	public void createBooking(@Valid @RequestBody BookingRequest request) {

		
	}

	@GetMapping("/bookings")
	public List<Booking> getBookings(@RequestParam(required = false) Integer hotel,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entryDate,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exitDate) {

		List<Booking> bookings = new ArrayList<Booking>();
		return bookings;
	}
	
	@GetMapping("/bookings/{bookingId}")
	public Booking getBooking(@PathVariable Integer bookingId) {

		Booking booking = new Booking();
		
		return booking;
		
	}
	
	@DeleteMapping("/bookings/{booking}")
	public void deleteBookings(@PathVariable Integer booking) {

	}

}
