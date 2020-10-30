package cjmorenozamora.booking.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cjmorenozamora.booking.dtos.models.Hotel;
import cjmorenozamora.booking.dtos.requests.CreateAvailabilityRequest;
import cjmorenozamora.booking.services.AvailabilityService;

@RestController
public class AvailabilityController {

	@Autowired
	AvailabilityService service;

	@PutMapping("/availability")
	public void createAvailability(@RequestBody CreateAvailabilityRequest request) {

	}

	@GetMapping("/availability")
	public List<Hotel> getAvailability() {
		
		List<Hotel> listHotel = new ArrayList<Hotel>();
		
		return listHotel;
	}

}
