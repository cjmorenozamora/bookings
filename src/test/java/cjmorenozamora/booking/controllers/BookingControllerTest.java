package cjmorenozamora.booking.controllers;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import cjmorenozamora.booking.dtos.requests.BookingRequest;
import cjmorenozamora.booking.services.impl.BookingServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private BookingServiceImpl service;

	@Autowired
	protected ObjectMapper jacksonMapper;

	@Test
	public void createBookingOk() throws Exception {
		BookingRequest booking = BookingRequest.builder().hotel(1).entryDate(LocalDate.of(2020, Month.DECEMBER, 10))
				.exitDate(LocalDate.of(2020, Month.DECEMBER, 10)).email("email@email.com").build();

		doNothing().when(service).createBooking(booking.getHotel(), booking.getEntryDate(), booking.getExitDate(),
				booking.getEmail());

		this.mvc.perform(post("/booking").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.content(jacksonMapper.writeValueAsString(booking))).andExpect(status().isOk());

	}
}
