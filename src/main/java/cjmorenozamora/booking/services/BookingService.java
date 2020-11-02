package cjmorenozamora.booking.services;

import java.time.LocalDate;
import java.util.List;

import cjmorenozamora.booking.dtos.models.BookingDto;

public interface BookingService {
	/**
	 * Servicio para crear la reserva de un hotel.
	 * 
	 * @param hotelId   Identificador del hotel donde se realizará la reserva.
	 * @param entryDate Fecha de inicio de la reserva.
	 * @param exitDate  Fecha de fin de la reserva.
	 * @param email     Dirección de correo electrónico.
	 */
	public void createBooking(Integer hotelId, LocalDate entryDate, LocalDate exitDate, String email);

	/**
	 * Servicio para obtener las reservas de un hotel en unas fechas concretas
	 * 
	 * @param hotelId   Identificador del hotel.
	 * @param entryDate Fecha inicial.
	 * @param exitDate  Fecha fin.
	 * @return Lista de reservas.
	 */
	public List<BookingDto> getBookings(Integer hotelId, LocalDate entryDate, LocalDate exitDate);

	/**
	 * Servicio para obtener la información de una reserva en concreto.
	 * 
	 * @param bookingId Identificador de la reserva.
	 * @return Reserva que deseamos consultar.
	 */
	public BookingDto getBooking(Integer bookingId);

	/**
	 * Servicio para cancelar una reserva
	 * 
	 * @param bookingId Identificador de la reserva.
	 */
	public void deleteBookings(Integer bookingId);

}
