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
	 * Servicio para crear una disponibilidad
	 * 
	 * @param hotelId   Identificador del hotel donde daremos de alta una
	 *                  disponibilidad.
	 * @param entryDate Fecha de inicio de la disponibilidad.
	 * @param exitDate  Fecha de fin de la disponibilidad.
	 * @param rooms     Habitaciones que habilitaremos como disponibles.
	 */
	public void createAvailability(Integer hotelId, LocalDate entryDate, LocalDate exitDate, Integer rooms);

	/**
	 * Servicio para obtener la lista de hoteles que están disponibles entre dos
	 * fechas.
	 * 
	 * @param entryDate Fecha de inicio de la disponibilidad.
	 * @param exitDate  Fecha de fin de la disponibilidad.
	 * @return Lista de hoteles disponibles.
	 */
	public List<HotelDto> getAvailability(LocalDate entryDate, LocalDate exitDate);
}
