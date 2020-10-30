package cjmorenozamora.booking.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cjmorenozamora.booking.dtos.models.Hotel;
import cjmorenozamora.booking.services.HotelService;

@RestController
public class HotelController {

	@Autowired
	HotelService service;
	@GetMapping("/hotels")
	public List<Hotel> getHotels() {
		List<Hotel> listHotels = new ArrayList<Hotel>();
		Hotel hotel = new Hotel();;
		
		hotel.setName("AC Hotel");
		
		
		listHotels.add(hotel);
		return listHotels;
	}
}
