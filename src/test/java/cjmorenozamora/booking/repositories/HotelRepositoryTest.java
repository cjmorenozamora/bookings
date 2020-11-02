package cjmorenozamora.booking.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cjmorenozamora.booking.entities.Hotel;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HotelRepositoryTest {

	@Autowired
	HotelRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindAllOk() {
		List<Hotel> hotels = repository.findAll();

		assertEquals(3, hotels.size());
	}
}
