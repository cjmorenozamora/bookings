package cjmorenozamora.booking.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.dtos.requests.CreateAvailabilityRequest;
import cjmorenozamora.booking.services.AvailabilityService;

@RestController
public class AvailabilityController {

	@Autowired
	AvailabilityService service;

	@PutMapping("/availability")
	public void createAvailability(@Valid @RequestBody CreateAvailabilityRequest request) {

	}

	@GetMapping("/availability")
	public List<HotelDto> getAvailability() {

		List<HotelDto> listHotel = new ArrayList<HotelDto>();

		return listHotel;
	}
}
