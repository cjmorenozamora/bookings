package cjmorenozamora.booking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.entities.Hotel;
import cjmorenozamora.booking.repositories.AvailabilityRepository;
import cjmorenozamora.booking.services.impl.AvailabilityServiceImpl;

@ExtendWith(SpringExtension.class)
public class AvailavilityServiceTest {

	@TestConfiguration
	static class AvailabilityServiceImplTestContextConfiguration {

		@Bean
		public AvailabilityService employeeService() {
			return new AvailabilityServiceImpl();
		}
	}

	@Autowired
	private AvailabilityService service;

	@MockBean
	private AvailabilityRepository repository;

	@Test
	public void findAllHotels() {

		LocalDate entryDate = LocalDate.of(2020, Month.DECEMBER, 10);
		LocalDate exitDate = LocalDate.of(2020, Month.DECEMBER, 15);

		List<Hotel> hotelList = List.of(Hotel.builder().category(4).id(1).name("AC CORDOBA").build(),
				Hotel.builder().category(5).id(2).name("MELIA").build(),
				Hotel.builder().category(2).id(3).name("AVERROES").build());

		Mockito.when(repository.findHotels(entryDate, exitDate)).thenReturn(hotelList);

		List<HotelDto> list = service.getAvailability(entryDate, exitDate);
		assertNotNull(list);
		assertEquals(3, list.size());
	}

}
