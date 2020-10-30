package cjmorenozamora.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjmorenozamora.booking.repositories.AvailabilityRepository;

@Service
public class AvailabilityService {

		@Autowired
		AvailabilityRepository repository;
		
}
