package cjmorenozamora.booking.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.dtos.requests.CreateAvailabilityRequest;
import cjmorenozamora.booking.services.impl.AvailabilityServiceImpl;

/*
 * Controller que gestionará los servicios correspondientes a la entidad Availavility.
 */
@RestController
public class AvailabilityController {

	@Autowired
	AvailabilityServiceImpl service;

	/**
	 * Recurso para crear una disponibilidad.
	 * 
	 * @param request Este parámetro recoge toda la información necesaria para dar
	 *                de alta una disponibilidad.
	 */
	@PutMapping("/availability")
	public void createAvailability(@Valid @RequestBody CreateAvailabilityRequest request) {

		service.createAvailability(request.getHotel(), request.getDateFrom(), request.getDateTo(), request.getRooms());

	}

	/**
	 * Recurso por el cual obtenemos los hoteles que tienen disponibilidad en las
	 * fechas indicadas.
	 * 
	 * @param entryDate Fecha de entrada al hotel.
	 * @param exitDate  Fecha de salida del hotel.
	 * @return Lista de hoteles que están disponibles para realizar una reserva.
	 */
	@GetMapping("/availability")
	public List<HotelDto> getAvailability(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entryDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exitDate) {

		return service.getAvailability(entryDate, exitDate);
	}
}
