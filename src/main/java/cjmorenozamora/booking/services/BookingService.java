package cjmorenozamora.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjmorenozamora.booking.repositories.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository repository;
}
