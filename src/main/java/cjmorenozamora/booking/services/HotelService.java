package cjmorenozamora.booking.services;

import java.util.List;

import cjmorenozamora.booking.dtos.models.HotelDto;

public interface HotelService {
	/**
	 * Servicio para obtener la lista de hoteles
	 * 
	 * @return Lista de hoteles de nuestra aplicación.
	 */
	public List<HotelDto> findAll();
}
