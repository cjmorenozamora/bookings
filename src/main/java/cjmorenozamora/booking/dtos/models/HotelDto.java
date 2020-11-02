package cjmorenozamora.booking.dtos.models;

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
public class HotelDto {

	/**
	 * Identificador del hotel.
	 */
	private Integer idHotel;

	/**
	 * Nombre del hotel.
	 */
	private String name;

	/**
	 * Categoría del hotel.
	 */
	private Integer category;
}
