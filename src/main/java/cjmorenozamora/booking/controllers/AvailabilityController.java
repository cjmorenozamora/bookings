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

@RestController
public class AvailabilityController {

	@Autowired
	AvailabilityServiceImpl service;

	@PutMapping("/availability")
	public void createAvailability(@Valid @RequestBody CreateAvailabilityRequest request) {

		service.createAvailability(request.getHotel(), request.getDateFrom(), request.getDateTo(), request.getRooms());

	}

	@GetMapping("/availability")
	public List<HotelDto> getAvailability(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entryDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exitDate) {

		return service.getAvailability(entryDate, exitDate);
	}
}
