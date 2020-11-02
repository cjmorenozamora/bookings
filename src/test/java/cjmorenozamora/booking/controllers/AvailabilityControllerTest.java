package cjmorenozamora.booking.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.services.impl.AvailabilityServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AvailabilityController.class)
public class AvailabilityControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AvailabilityServiceImpl service;

	@Test
	public void findHotelsWithAvailabilities() throws Exception {

		HotelDto hotel1 = HotelDto.builder().category(4).idHotel(1).name("AC CORDOBA").build();
		HotelDto hotel2 = HotelDto.builder().category(5).idHotel(2).name("MELIA").build();
		HotelDto hotel3 = HotelDto.builder().category(2).idHotel(3).name("AVERROES").build();

		List<HotelDto> hotelList = new ArrayList<>();

		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);

		LocalDate entryDate = LocalDate.of(2020, Month.DECEMBER, 10);
		LocalDate exitDate = LocalDate.of(2020, Month.DECEMBER, 12);

		when(service.getAvailability(entryDate, exitDate)).thenReturn(hotelList);
		this.mvc.perform(get("/availability?entryDate=2020-12-10&exitDate=2020-12-15")).andDo(print()).andExpect(status().isOk());

	}

}
