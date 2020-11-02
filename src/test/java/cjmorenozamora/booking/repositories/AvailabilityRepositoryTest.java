package cjmorenozamora.booking.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cjmorenozamora.booking.entities.Availability;
import cjmorenozamora.booking.entities.Hotel;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AvailabilityRepositoryTest {

	
	@Autowired
	AvailabilityRepository repository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testFindAllOk() {
		 List<Availability> availabilities = repository.findAll();
		
		assertEquals(54, availabilities.size());
	}
	
	public void testGetAvailablesHotels() {
		LocalDate entryDate = LocalDate.of(2020, Month.DECEMBER, 10);
		LocalDate exitDate = LocalDate.of(2020, Month.DECEMBER, 15);
		
		List<Hotel> hotels = repository.findHotels(entryDate, exitDate);
		
		
		assertEquals(3, hotels.size());
		
	}

}
