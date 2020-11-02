package cjmorenozamora.booking.controllers;

import java.time.LocalDate;
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
import cjmorenozamora.booking.services.impl.BookingServiceImpl;

/**
 * Controller que gestionará los servicios correspondientes a la entidad Bookng.
 * 
 * @author cjmoreno
 *
 */
@RestController
public class BookingController {

	@Autowired
	BookingServiceImpl service;

	/**
	 * Recurso para crear una reserva.
	 * 
	 * @param request Parámetro que indica toda la información necesaria para dar de
	 *                alta una reserva.
	 */
	@PostMapping("/booking")
	public void createBooking(@Valid @RequestBody BookingRequest request) {

		service.createBooking(request.getHotel(), request.getEntryDate(), request.getExitDate(), request.getEmail());

	}

	/**
	 * Recurso mediante el cual obtenemos las reservas de un hotel y unas fechas en
	 * concreto.
	 * 
	 * @param hotel     Indica el hotel donde queremos consultar las reservas.
	 * @param entryDate Fecha de entrada de la reserva.
	 * @param exitDate  Fecha de salida de la reserva.
	 * @return Lista de reservas realizadas.
	 */
	@GetMapping("/bookings")
	public List<BookingDto> getBookings(@RequestParam(required = false) Integer hotel,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entryDate,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exitDate) {

		List<BookingDto> bookings = service.getBookings(hotel, entryDate, exitDate);

		return bookings;
	}

	/**
	 * Recurso para obtener la información de una reserva en concreto.
	 * 
	 * @param bookingId Identidicador de la reserva.
	 * @return Objeto que contiene la información de una reserva.
	 */
	@GetMapping("/bookings/{bookingId}")
	public BookingDto getBooking(@NotNull(message = "Booking id is mandatory") @PathVariable Integer bookingId) {

		BookingDto booking = new BookingDto();

		booking = service.getBooking(bookingId);

		return booking;

	}

	/**
	 * Recurso que utilizamos para borrar una reserva
	 * 
	 * @param booking Identidicador de la reserva.
	 */
	@DeleteMapping("/bookings/{booking}")
	public void deleteBookings(@PathVariable Integer booking) {

		service.deleteBookings(booking);
	}

}
