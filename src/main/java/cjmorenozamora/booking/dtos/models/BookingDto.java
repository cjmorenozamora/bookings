package cjmorenozamora.booking.dtos.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author cjmoreno
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

	/**
	 * Identificador de la reserva.
	 */
	private Integer bookingId;

	/**
	 * Objeto Hotel
	 */
	private HotelDto hotel;

	/**
	 * Fecha de inicio de la reserva.
	 */
	private LocalDate dateFrom;

	/**
	 * Fecha final de la reserva.
	 */
	private LocalDate dateTo;

	/**
	 * Email de la reserva.
	 */
	private String email;
}
