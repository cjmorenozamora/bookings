package cjmorenozamora.booking.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.interfaces.AvailabilityInterface;
import cjmorenozamora.booking.repositories.AvailabilityRepository;

@Service
public class AvailabilityService implements AvailabilityInterface{

		@Autowired
		AvailabilityRepository repository;

		@Override
		public void createAvailability(Integer hotelId, LocalDate entryDate, LocalDate exitDate, Integer rooms) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<HotelDto> getAvailability(LocalDate entryDate, LocalDate exitDate) {
			// TODO Auto-generated method stub
			return null;
		}
		
}
