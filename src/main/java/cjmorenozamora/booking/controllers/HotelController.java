package cjmorenozamora.booking.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.services.impl.HotelServiceImpl;

/**
 * Controller que gestionará los servicios correspondientes a la entidad Hotel
 * 
 * @author cjmoreno
 *
 */
@RestController
public class HotelController {

	@Autowired
	HotelServiceImpl service;

	/**
	 * Recurso que utilizaremos para consultar los hoteles de nuestra bade de datos.
	 * 
	 * @return Lista de hoteles.
	 */
	@GetMapping("/hotels")
	public List<HotelDto> getHotels() {
		List<HotelDto> listHotels = new ArrayList<>();

		listHotels = service.findAll();
		return listHotels;
	}
}
