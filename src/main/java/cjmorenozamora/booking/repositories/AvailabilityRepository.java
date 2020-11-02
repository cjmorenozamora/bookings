package cjmorenozamora.booking.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cjmorenozamora.booking.entities.Availability;
import cjmorenozamora.booking.entities.AvailabilityPk;
import cjmorenozamora.booking.entities.Hotel;

/**
 * Repositorio de disponibilidad.
 * 
 * @author cjmoreno
 *
 */
public interface AvailabilityRepository extends JpaRepository<Availability, AvailabilityPk> {

	/**
	 * Consulta de hoteles disponibles
	 * 
	 * @param entryDate Fecha de inicio.
	 * @param exitDate  Fecha de fin.
	 * @return Lista de hoteles disponibles.
	 */
	@Query("SELECT DISTINCT a.hotel FROM Availability a JOIN a.hotel WHERE a.rooms>0 AND a.date BETWEEN ?1 AND ?2")
	List<Hotel> findHotels(LocalDate entryDate, LocalDate exitDate);

	/**
	 * Actualización de la disponibilidad si se realiza una reserva.
	 * 
	 * @param entryDate Fecha de inicio.
	 * @param exitDate  Fecha de fin.
	 * @param hotelId   Identificador del hotel.
	 * @return Valor para conocer si se realizado la actualización.
	 */
	@Modifying
	@Query("UPDATE Availability a SET a.rooms = a.rooms-1 WHERE (a.date BETWEEN ?1 AND ?2) AND (a.hotel.id = ?3)")
	Integer updateAvailability(LocalDate entryDate, LocalDate exitDate, Integer hotelId);

	/**
	 * Actialización de la disponibilidad si se cancela una reserva.
	 * 
	 * @param entryDate Fecha de entrada.
	 * @param exitDate  Fecha de salida.
	 * @param hotelId   Identificador del hotel.
	 * @return Valor para conocer si se realizado la actualización.
	 */
	@Modifying
	@Query("UPDATE Availability a SET a.rooms = a.rooms+1 WHERE (a.date BETWEEN ?1 AND ?2) AND (a.hotel.id = ?3)")
	Integer updateAvailabilityAddRooms(LocalDate entryDate, LocalDate exitDate, Integer hotelId);

}
